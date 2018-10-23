<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주문</title>
</head>
<body>
<form:form>
<p>
	<label for="itemId">아이템ID</label>
	<form:select path="itemId">
		<form:option value="1">1</form:option>
		<form:option value="2">2</form:option>
	</form:select>
</p>
<p>
	<label for="id">주소</label>
	<form:input id="address" path="address"/>
</p>
<p>
	<input type="submit" value="주문">
</p>
</form:form>
</body>
</html>