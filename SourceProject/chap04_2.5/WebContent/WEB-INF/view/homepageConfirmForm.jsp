<%@ page contentType="text/html; charset=EUC-KR" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� Ȯ��</title>
</head>
<body>
<form action="homepageRegistry.do" method="post">
<p>
	<label>Ȩ������ �ּ�</label>
	${registry.homepageUrl}
</p>
<p>
	<label>Ÿ��</label>
	${registry.type}
</p>
<p>
	<label>����</label>
	${registry.title}
</p>
<p>
	<label>����</label>
	${registry.description}
</p>
<p>
	<input type="submit" name="_target1" value="���� �ٽ� �Է�">
	<input type="submit" name="_finish" value="��û �Ϸ�">
	<input type="submit" name="_cancel" value="���">
</p>
</form>
</body>
</html>