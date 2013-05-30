<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="makeAccountSubmit.do">
	<h5>아이디 생성</h5>
		<p><input type="text" name="userId" placeholder="ID" required/></p>
		<p><input type="password" name="password" placeholder="Password" required/></p>
		<button type="submit">생성</button>
</form>
</body>
</html>