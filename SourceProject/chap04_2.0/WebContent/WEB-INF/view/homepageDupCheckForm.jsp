<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ߺ� �˻�</title>
</head>
<body>
<spring:hasBindErrors name="registry" />
<form action="homepageRegistry.do" method="post">
<p>
	<label for="homepageUrl">Ȩ������ �ּ�</label>
	<input type="text" id="homepageUrl" name="homepageUrl" value="${registry.homepageUrl}">
	<form:errors path="registry.homepageUrl" />
</p>
<p>
	<input type="submit" name="_target1" value="�ߺ� �˻�">
</p>
</form>
</body>
</html>