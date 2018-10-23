<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>인사</title>
</head>
<body>
<spring:message code="greeting" arguments="${me}, ${greeting}" />
</body>
</html>