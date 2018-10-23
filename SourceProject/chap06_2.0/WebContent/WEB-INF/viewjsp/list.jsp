<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����</title>
<style type="text/css">
.messageItem {border-bottom: 1px #000000}
.messageGuestName {color: #dda0dd}
.messageContent {font-size: 10px}
</style>
</head>
<body>
<h1>����</h1>
<c:if test="${empty listResult.messages}">
��ϵ� �޽����� �����ϴ�.
</c:if>

<c:forEach var="message" items="${listResult.messages}">
<div class="messageItem">
	<div class="messageGuestName">${message.guestName}�Բ��� ���� ���Դϴ�:</div>
	<div class="messageContent">${message.content}</div>
</div>
</c:forEach>

<form action="write" method="post">
<p>
	<label for="guestName">�湮��</label><br/>
	<input name="guestName" id="guestName" />
</p>
<p>
	<label for="content">����</label><br/>
	<textarea name="content" id="content" rows="2" cols="30"></textarea>
</p>
<p>
	<input type="submit" value="�޽��� �����" />
</p>
</form>
</body>
</html>