<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/views/include/head.jsp" %>
<%@ include file="/views/include/header.jsp" %>
<form method="post" action="/customers/add">
    <input name="taxNumber" placeholder="<spring:message code="taxNumber"/>" required>
    <input name="companyName" placeholder="<spring:message code="companyName"/>" required>
    <input name="street" placeholder="<spring:message code="street"/>" required>
    <input name="buildingNumber" placeholder="<spring:message code="buildingNumber"/>" required>
    <input name="officeNumber" placeholder="<spring:message code="officeNumber"/>">
    <input name="email" placeholder="<spring:message code="email"/>">
    <input name="website" placeholder="<spring:message code="website"/>">
    <button type="submit"><spring:message code="save"/></button>
</form>
<%@ include file="/views/include/footer.jsp" %>