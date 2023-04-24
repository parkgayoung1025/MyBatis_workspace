package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	/*
	 * 기존 JDBC
	 * 1. getConnection() : driver.properties 파일을 읽어들여서 db와 접속된 Connection 객체를 생성해서 반환
	 * 2. close() : 전달받은 JDBC 객체를 반납시키는 구문
	 * 3. commit() / rollback() : 트랜잭션 처리해 주는 구문
	 */
	
	// 마이바티스
	public static SqlSession getSqlSession() {
		
		// mybatis-config.xml을 읽어들여서 해당 db와 접속된 SqlSession 객체를 생성해서 반환
		
		SqlSession sqlSession = null;
		
		// sqlSession 객체를 얻어오기 위해서는 SqlSessionFactory 객체가 필요
		// SqlSessionFactory 객체를 생성하기 위해서는 SqlSessionFactoryBuilder 객체가 필요함
		
		String resource = "/mybatis-config.xml"; // 실제로 싫행되는 폴더는 WEB-INF 안에 있는 폴더임, '/'는 최상위 폴더(classes)
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource); // 자원으로부터 통로를 얻어냄
			
			// 1단계 SqlSessionFactoryBuilder 객체 생성
//			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			
			// 2단계 mybatis-config 파일을 읽어들여서 SqlSessionFactory 객체 생성
//			SqlSessionFactory ssf = ssfb.build(stream);
			
			// 3단계 SqlSession 객체 생성 및 트랜잭션처리를 자동으로할지 수동으로 할지를 배개변수를 통해 구분(false:수동, true:자동 / 기본값은 false)
//			sqlSession = ssf.openSession(false); // 자동 커밋을 막아주는 변수
			
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
