<%@ page contentType="text/html; charset=EUC-KR" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����</title>
</head>
<body>
��û�� ó���ϴ� �������� ������ �߻��߽��ϴ�:
${exception.message}
<%
Throwable exception = (Throwable) request.getAttribute("exception");
exception.printStackTrace();
%>
</body>
</html>