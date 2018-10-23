<%@ page contentType="text/html; charset=EUC-KR" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>정보 확인</title>
</head>
<body>
<form action="homepageRegistry.do" method="post">
<p>
	<label>홈페이지 주소</label>
	${registry.homepageUrl}
</p>
<p>
	<label>타입</label>
	${registry.type}
</p>
<p>
	<label>제목</label>
	${registry.title}
</p>
<p>
	<label>설명</label>
	${registry.description}
</p>
<p>
	<input type="submit" name="_target1" value="정보 다시 입력">
	<input type="submit" name="_finish" value="신청 완료">
	<input type="submit" name="_cancel" value="취소">
</p>
</form>
</body>
</html>