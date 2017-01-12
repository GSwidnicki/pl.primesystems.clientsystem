<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/views/include/head.jsp" %>
<a href="?lang=pl"><spring:message code="polish"/></a>
<a href="?lang=en"><spring:message code="english"/></a>
<form method="post" action="/register">
    <input name="firstName" placeholder="<spring:message code="firstName"/>" required>
    <input name="lastName" placeholder="<spring:message code="lastName"/>" required>
    <input name="email" placeholder="<spring:message code="email"/>" required>
    <input name="password" placeholder="<spring:message code="password"/>" required>
    <input name="passwordConfirm" placeholder="<spring:message code="confirmPassword"/>" required>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit"><spring:message code="register"/></button>
</form>
<%@ include file="/views/include/footer.jsp" %>