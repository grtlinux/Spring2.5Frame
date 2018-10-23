<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α��� ��</title>
</head>
<body>
<form:form commandName="login">
<form:errors />
<p>
	<label for="loginType">�α��� Ÿ��</label>
	<select id="loginType" name="loginType">
	<c:forEach var="loginType" items="${loginTypes}">
		<option>${loginType}</option>
	</c:forEach>
	</select>
</p>
<p>
	<label for="id">�α��� ID</label>
	<input type="text" id="id" name="id" value="${login.id}">
	<form:errors path="id" />
</p>
<p>
	<label for="password">�α��� ��ȣ</label>
	<input type="password" id="password" name="password">
	<form:errors path="password" />
</p>
<p>
	<input type="submit" value="�α���">
</p>
</form:form>
</body>
</html>