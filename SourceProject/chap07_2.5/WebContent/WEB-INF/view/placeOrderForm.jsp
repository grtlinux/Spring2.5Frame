<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ֹ�</title>
</head>
<body>
<form:form>
<p>
	<label for="itemId">������ID</label>
	<form:select path="itemId">
		<form:option value="1">1</form:option>
		<form:option value="2">2</form:option>
	</form:select>
</p>
<p>
	<label for="id">�ּ�</label>
	<form:input id="address" path="address"/>
</p>
<p>
	<input type="submit" value="�ֹ�">
</p>
</form:form>
</body>
</html>