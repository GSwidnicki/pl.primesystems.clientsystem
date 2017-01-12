<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/views/include/head.jsp" %>
<spring:message code="selectLang"/>:
<a href="?lang=pl"><spring:message code="polish"/></a>
<a href="?lang=en"><spring:message code="english"/></a>
<form method="post" action="/login-process">
    <input name="username" placeholder="<spring:message code="email"/>" required>
    <input name="password" placeholder="<spring:message code="password"/>" required>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit"><spring:message code="login"/></button>
</form>
<a href="/user/password"><spring:message code="forgotPass"/></a>
<%@ include file="/views/include/footer.jsp" %>