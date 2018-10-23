<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<fmt:message key="label.currentTime"></fmt:message>
: <fmt:formatDate value="${time}" /> 
