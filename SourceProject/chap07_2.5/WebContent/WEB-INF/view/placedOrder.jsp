<%@ page contentType="text/html; charset=EUC-KR" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주문 완료</title>
</head>
<body>
주문을 완료했습니다.
<ul>
	<li>주문번호: ${orderResult.order.id}</li>
	<li>상품번호: ${orderResult.item.id}</li>
	<li>주문가격: ${orderResult.paymentInfo.price}</li>
</ul>
</body>
</html>