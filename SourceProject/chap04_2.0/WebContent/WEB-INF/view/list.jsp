<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>목록</title>
</head>
<body>
<c:if test="${empty articleList}">
결과가 없습니다.
</c:if>
<c:if test="${! empty articleList}">
	<c:forEach var="article" items="${articleList}">
	${article}
	</c:forEach>
</c:if>
</body>
</html>