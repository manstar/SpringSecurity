<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<body>
<form id="loginForm" method="post" >
		<p><input type="text"  name="j_username" placeholder="ID" required/></p>
		<p><input type="password" name="j_password" placeholder="Password" required/></p>
		<Button type="button" onclick="login()" >�α���</Button>
		<Button type="button" onclick="logout()" >�α׾ƿ�</Button>
		<Button type="button" onclick="makeAccount()">���̵� �����</Button>
		<div>
			<sec:authentication property="Authorities"/>
		</div>
		
</form>
</body>
<script type="text/javascript">
var loginForm = document.getElementById('loginForm');
function login(){
	loginForm.action = "j_spring_security_check";
	loginForm.submit();
}
function logout(){
	loginForm.action = "logout.do";
	loginForm.submit();
}
function makeAccount(){
	loginForm.action = "makeAccount.do";
	loginForm.submit();
}
</script>