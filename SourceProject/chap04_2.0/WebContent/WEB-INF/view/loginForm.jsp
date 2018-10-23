<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인 폼</title>
</head>
<body>
<form:form commandName="login">
<form:errors />
<p>
	<label for="loginType">로그인 타입</label>
	<select id="loginType" name="loginType">
	<c:forEach var="loginType" items="${loginTypes}">
		<option>${loginType}</option>
	</c:forEach>
	</select>
</p>
<p>
	<label for="id">로그인 ID</label>
	<input type="text" id="id" name="id" value="${login.id}">
	<form:errors path="id" />
</p>
<p>
	<label for="password">로그인 암호</label>
	<input type="password" id="password" name="password">
	<form:errors path="password" />
</p>
<p>
	<input type="submit" value="로그인">
</p>
</form:form>
</body>
</html>