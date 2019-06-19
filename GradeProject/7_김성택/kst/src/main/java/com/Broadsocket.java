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

	/**
	*
	* @fn 		@ServerEndpoint("/broadcasting")
	* 
	* @brief 	주소설정
	*
	* @author 	김성택
	* @date 	2019-06-20
	*
	* @param 	"/broadcasting"
	*
	* @remark	@ServerEndpoint 주소를 설정한다.	[2019-06-20; 김성택] \n
	*
	*/
	//@ServerEndpoint 주소를 설정
	
@ServerEndpoint("/broadcasting")
public class Broadsocket {
	
	/**
	 *
	 * @fn 		Collections.synchronizedList()
	 * 
	 * @brief 	동기화
	 *
	 * @author 	김성택
	 * @date 	2019-06-20
	 *
	 * @param 	new ArrayList<>()
	 *
	 * @remark	동기화된(synchronized) 컬렉션은 멀티 스레드 환경에서 하나의 스레드가 요소를 안전하게 처리하도록 도와준다.	[2019-06-20; 김성택] \n
	 *
	 */

	static List<Session> clients = Collections.synchronizedList(new ArrayList<>());

	/**
	 *
	 * @fn 		public void onOpen(Session session)
	 * 
	 * @brief 	세션을 추가
	 *
	 * @author 	김성택
	 * @date 	2019-06-20
	 *
	 * @param 	session
	 *
	 * @remark	웹 소켓이 접속되면 유저리스트(clients)에 세션(session)을 넣는다.	[2019-06-20; 김성택] \n
	 *
	 */

	@OnOpen
	public void onOpen(Session session) {
		clients.add(session);
	}
	

	/**
	 *
	 * @fn 		public void onClose(Session session)
	 * 
	 * @brief 	세션을 제거
	 *
	 * @author 	김성택
	 * @date 	2019-06-20
	 *
	 * @param 	session
	 *
	 * @remark	웹 소켓이 접속이 종료되면 유저리스트에서 세션을 제거한다.	[2019-06-20; 김성택] \n
	 *
	 */
	
	@OnClose
	public void onClose(Session session) {
		clients.remove(session);
	}


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
	 * @remark	웹 소켓에서 메시지가 오면 호출된다	[2019-06-20; 김성택] \n
	 *		   	받아온 session이랑 비교후 다르면	세션으로 메시지를 보낸다	  [2019-06-20; 김성택] \n
	 *			서버에 접속 중인 모든 이용자에게 메지지를 전송한다   [2019-06-20; 김성택] \n
	 *
	 */

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		synchronized (clients) {
			for (Session client : clients) {
				if (!client.equals(session)) {
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}

}