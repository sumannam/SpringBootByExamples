package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

	//실행시키면 웹서버가 동작되면서 static으로 정의되어 있는 Session이 메모리로 올라온다.

	//@ServerEndpoint 주소를 설정
	
@ServerEndpoint("/broadcasting")
public class Broadsocket {

	//유저 집합 리스트 생성 , 동기화된(synchronized) 컬렉션은 멀티 스레드 환경에서 하나의 스레드가 요소를 안전하게 처리하도록 도와준다.

	static List<Session> clients = Collections.synchronizedList(new ArrayList<>());


	//웹 소켓이 접속되면 유저리스트(clients)에 세션(session)을 넣는다.

	@OnOpen
	public void onOpen(Session session) {
		clients.add(session);
	}
	
	//웹 소켓이 접속이 종료되면 유저리스트에서 세션을 제거한다.
	
	@OnClose
	public void onClose(Session session) {
		clients.remove(session);
	}

	//웹 소켓에서 메시지가 오면 호출된다.
	/**
	 *
	 * @fn 		public void onMessage(String message, Session session)
	 * 
	 * @brief 	메시지,세션비교 발송
	 *
	 * @author 	김성택
	 * @date 	2019-06-20
	 *
	 * @param 	String message, Session session
	 *
	 * @remark	폼에 입력된 값을 받아온 후 객체에 저장	[2019-06-20; 김성택] \n
	 *		   	save 메소드를 이용해 DB에 저장		[2019-06-20; 김성택] \n
	 *			서버에 접속 중인 모든 이용자에게 메지지를 전송한다	[2019-06-20; 김성택] \n
	 *
	 */
	// 서버에 접속 중인 모든 이용자에게 메지지를 전송한다

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		synchronized (clients) {	//하나의 일 처리를 수행하는동안 사용자의 변경이 일어나면 안된다. 여러 사용자의 쓰레드에서 이 메소드에 접근하기 때문에 rock을 건다
			for (Session client : clients) {	//유저를 꺼내서
				if (!client.equals(session)) {	//받아온 session이랑 비교후 다르면
					client.getBasicRemote().sendText(message);	//getBasicRemote()로 사용자의 스트림을 얻고 상대 세션으로 메시지를 보낸다
				}
			}
		}
	}

}