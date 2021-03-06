<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 정보 수정 폼</title>
</head>
<body>
<spring:hasBindErrors name="memberInfo" />
<form action="updateMemberInfo.do" method="post">
<p>
	<label>회원 ID</label>
	${memberInfo.userId}
</p>
<p>
	<label for="name">이름</label>
	<input type="text" id="name" name="name" value="${memberInfo.name}">
	<form:errors path="memberInfo.name" />
</p>
<p>
	<label>주소1</label>
	<input type="text" id="address.address1" name="address.address1" value="${memberInfo.address.address1}">
	<form:errors path="memberInfo.address.address1" />
</p>
<p>
	<label>주소2</label>
	<input type="text" id="address.address2" name="address.address2" value="${memberInfo.address.address2}">
	<form:errors path="memberInfo.address.address2" />
</p>
<p>
	<input type="submit" value="회원 정보 수정">
</p>
</form>
</body>
</html>