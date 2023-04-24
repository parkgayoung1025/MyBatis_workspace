<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		* 프레임 워크
		- 개발자가 보다 편리한 환경에서 개발할 수 있도록 제공하는 뼈대, 틀
		- 소프트웨어 개발의 입장으로써는 공통으로 사용하는 라이브러리, 개발 도구, 인터페이스 등등을 의미한다.
		
		* 프레임 워크를 왜 쓰는가 ?
		- 현재 웹 프로그래밍의 규모가 커지고 있음
		  => 거대하고 복잡도가 높은 프로젝트를 완성시키기 위해 많은 사람들이 필요하고, 그 개발자들이 "통일성"있게,
		     빠르게, 안정적으로 개발하기 위한 도구로 프레임 워크가 좋은 성과를 내고 있기 때문에
		     즉, 생산성 향상에 큰 도움이 된다.
		     
		* 프레임 워크의 특징
		- 자유롭게 설계하고 코딩하는 게 아니라 프레임 워크가 제공하는 가이드라인대로 설계하고 코딩해야 함
		- 개발할 수 있는 범위가 정해져있음
		- 개발자를 위한 도구 / 플러그인들이 지원된다.
		
		* 프레임 워크의 장단점
		> 장점 : 개발 시간을 줄일 수 있음 => 오류로부터 자유로워진다.
		> 단점 : 너무 의존하다 보면 개발 능력이 떨어져서 프레임 워크 없이 개발하는 게 어려워짐
		        습득하는데 시간이 걸릴 수 있다.
		
		* 프레임 워크의 종류
		- 영속성 : 데이터 관련한(crud) 기능들을 편리하게 작업할 수 있도록 도와주는 프레임 워크(mybatis)
		- 자바 : 웹 애플리케이션에 초점을 맞춰서 필요한 요소들을 모듈화해서 제공해 주는 프레임 워크(spring)
		- 화면 구현 : Front-end를 보다 쉽게 구현할 수 있게 틀을 제공해 주는 프레임 워크(Bootstrap)
		- 기능 및 지원 : 특정 기능이나 업무 수행에 도움을 주는 기능을 제공해 주는 프레임 워크(log4j, junit)
	 -->
	 
	<!-- index 페이지가 로딩되자마자 menubar로 포워딩 -->
	<jsp:forward page="views/common/menubar.jsp"></jsp:forward>
</body>
</html>