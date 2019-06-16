package com.example.spring04.config;

import java.util.Arrays;

		/**
		*
		* @fn 		@Value("${spring.data.mongodb}")
		* 
		* @brief 	정보설정 
		*
		* @author 	김성택
		* @date 	2019-06-16
		*
		* @param 	"${spring.data.mongodb.data}"
		*
		* @remark 	몽고db 사용자설정후 properties에 저장된 정보를 매칭		[2019-06-16; 김성택]
		* 		   	
		**/

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
	@Value("${spring.data.mongodb.username}")
	private String userName;
	@Value("${spring.data.mongodb.password}")
	private String password;
	@Value("${spring.data.mongodb.database}")
	private String database;

		/**
		*
		* @fn 		protected String getDatabaseName()
		* 
		* @brief 	이름연결 
		*
		* @author 	김성택
		* @date 	2019-06-16
		*
		*
		* @remark 	몽고db에 설정된 이름를 설정		[2019-06-16; 김성택]
		* 		   	
		**/
	
	@Override
	protected String getDatabaseName() {
		return database;
	}
	
		/**
		*
		* @fn 		public @Bean MongoTemplate mongoTemplate()
		* 
		* @brief 	빈설정 
		*
		* @author 	김성택
		* @date 	2019-06-16
		*
		*
		* @remark 	<bean></bean>역할을 수행		[2019-06-16; 김성택]
		* 		   	
		**/
	
	public @Bean MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate((MongoClient) mongoClient(), 
				database);
	}

		/**
		*
		* @fn 		public MongoClient mongoClient()
		* 
		* @brief 	주소설정 
		*
		* @author 	김성택
		* @date 	2019-06-16
		*
		*
		* @remark 	몽고db에 설정된 포트번호를 설정		[2019-06-16; 김성택]
		* 		   	
		**/
	
	@Override
	public MongoClient mongoClient() {
		MongoCredential credential = 
				MongoCredential.createCredential(
						userName, database, password.toCharArray());
		return new MongoClient(new ServerAddress(
				"localhost", 27017), Arrays.asList(credential));
	}
}
