<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>방명록</title>
<style type="text/css">
.messageItem {border-bottom: 1px #000000}
.messageGuestName {color: #dda0dd}
.messageContent {font-size: 10px}
</style>
</head>
<body>
<h1>방명록</h1>
<c:if test="${empty listResult.messages}">
등록된 메시지가 없습니다.
</c:if>

<c:forEach var="message" items="${listResult.messages}">
<div class="messageItem">
	<div class="messageGuestName">${message.guestName}님께서 남긴 글입니다:</div>
	<div class="messageContent">${message.content}</div>
</div>
</c:forEach>

<form action="write" method="post">
<p>
	<label for="guestName">방문자</label><br/>
	<input name="guestName" id="guestName" />
</p>
<p>
	<label for="content">내용</label><br/>
	<textarea name="content" id="content" rows="2" cols="30"></textarea>
</p>
<p>
	<input type="submit" value="메시지 남기기" />
</p>
</form>
</body>
</html>