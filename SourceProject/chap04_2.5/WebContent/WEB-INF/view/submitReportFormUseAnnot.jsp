<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>리포트 등록 폼</title>
</head>
<body>
<spring:hasBindErrors name="report" />
<form action="submitReport.do" method="post" enctype="multipart/form-data">
<p>
	<label for="subject">제목</label>
	<input type="text" id="subject" name="subject" value="${report.subject}">
	<form:errors path="report.subject" />
</p>
<p>
	<label for="reportFile">리포트 파일</label>
	<input type="file" id="reportFile" name="reportFile">
	<form:errors path="report.reportFile" />
</p>
<p>
	<label for="sourceCode">소스 코드</label>
	<input type="file" id="sourceCode" name="sourceCode">
	<form:errors path="report.sourceCode" />
</p>
<p>
	<input type="submit" value="리포트 전송">
</p>
</form>
</body>
</html>