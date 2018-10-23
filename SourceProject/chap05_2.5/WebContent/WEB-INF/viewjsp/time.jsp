<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><spring:message code="title.currentTime"/></title>
</head>
<body>
<fmt:message key="label.currentTime"></fmt:message>
: <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${time}" /> 
</body>
</html>