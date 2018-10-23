<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form commandName="memberInfo">
<p>
	<form:label path="userId">ȸ�� ID</form:label>
	<form:input path="userId" />
	<form:errors path="userId" />
</p>
<p>
	<form:label path="name">�̸�</form:label>
	<form:input path="name" />
	<form:errors path="name" />
</p>
<p>
	<form:label path="address.address1">�ּ�1</form:label>
	<form:input path="address.address1" />
	<form:errors path="address.address1" />
</p>
<p>
	<form:label path="address.address2">�ּ�2</form:label>
	<form:input path="address.address2" />
	<form:errors path="address.address2" />
</p>
<p>
	<form:label path="jobCode">����</form:label>
	<form:select path="jobCode" >
		<option value="">--- �����ϼ��� ---</option>
		<form:options items="${jobCodes}" itemLabel="label" itemValue="code" />
	</form:select>
	<form:errors path="jobCode" />
</p>
<p>
	<form:label path="favorites">��ȣ OS</form:label>
	<c:forEach var="favoritesOsName" items="${favoritesOsNames}">
		<form:checkbox path="favorites" value="${favoritesOsName}" />
		${favoritesOsName}
	</c:forEach>
	<form:errors path="favorites" />
</p>
<p>
	<form:label path="tool">�ַ� ����ϴ� ������</form:label>
	<c:forEach var="toolValue" items="${tools}">
		<form:radiobutton path="tool" value="${toolValue}" />
		${toolValue}
	</c:forEach>
	<form:errors path="favorites" />
</p>
<p>
	<form:label path="etc">��Ÿ</form:label>
	<form:textarea path="etc" cols="20" rows="3"/>
</p>
<p>
	<input type="submit" value="ȸ�� ���">
</p>
</form:form>
