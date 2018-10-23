<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� �Է�</title>
</head>
<body>
<spring:hasBindErrors name="registry" />
<form action="homepageRegistry.do" method="post">
<p>
	<label>Ȩ������ �ּ�</label>
	${registry.homepageUrl}
</p>
<p>
	<label for="type">Ÿ��</label>
	<select id="type" name="type">
	<c:forEach var="type" items="${types}">
		<option>${type}</option>
	</c:forEach>
	</select>
	<form:errors path="registry.type" />
</p>
<p>
	<label for="title">����</label>
	<input type="text" id="title" name="title" value="${registry.title}">
	<form:errors path="registry.title" />
</p>
<p>
	<label for="description">����</label>
	<input type="text" id="description" name="description" value="${registry.description}">
	<form:errors path="registry.description" />
</p>
<p>
	<input type="submit" name="_target0" value="URL �ٽ� �Է��ϱ�">
	<input type="submit" name="_target2" value="���� Ȯ�� �ܰ�� �̵�">
</p>
</form>
</body>
</html>