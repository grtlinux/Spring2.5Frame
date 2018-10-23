<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>정보 입력</title>
</head>
<body>
<spring:hasBindErrors name="registry" />
<form action="homepageRegistry.do" method="post">
<p>
	<label>홈페이지 주소</label>
	${registry.homepageUrl}
</p>
<p>
	<label for="type">타입</label>
	<select id="type" name="type">
	<c:forEach var="type" items="${types}">
		<option>${type}</option>
	</c:forEach>
	</select>
	<form:errors path="registry.type" />
</p>
<p>
	<label for="title">제목</label>
	<input type="text" id="title" name="title" value="${registry.title}">
	<form:errors path="registry.title" />
</p>
<p>
	<label for="description">설명</label>
	<input type="text" id="description" name="description" value="${registry.description}">
	<form:errors path="registry.description" />
</p>
<p>
	<input type="submit" name="_target0" value="URL 다시 입력하기">
	<input type="submit" name="_target2" value="정보 확인 단계로 이동">
</p>
</form>
</body>
</html>