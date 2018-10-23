<%@ page contentType="text/html; charset=EUC-KR" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>에러</title>
</head>
<body>
요청을 처리하는 과정에서 문제가 발생했습니다:
${exception.message}
<%
Throwable exception = (Throwable) request.getAttribute("exception");
exception.printStackTrace();
%>
</body>
</html>