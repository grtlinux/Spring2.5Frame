<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="tiles"
	uri="http://jakarta.apache.org/struts/tags-tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
<tiles:insert name="header" />
<hr />
<tiles:insert name="body" />
<hr />
<tiles:insert name="footer" />
</body>
</html>
