<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/views/include/head.jsp" %>
<%@ include file="/views/include/header.jsp" %>
<%@ include file="/views/include/navbar.jsp" %>
<div class="container">
    <table class="table table-hover">
        <thead>
            <tr>
                <th><spring:message code="id"/></th>
                <th><spring:message code="taxNumber"/></th>
                <th><spring:message code="companyName"/></th>
                <th><spring:message code="street"/></th>
                <th><spring:message code="buildingNumber"/></th>
                <th><spring:message code="officeNumber"/></th>
                <th><spring:message code="email"/></th>
                <th><spring:message code="website"/></th>
                <th><spring:message code="options"/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.taxNumber}</td>
                    <td>${customer.companyName}</td>
                    <td>${customer.street}</td>
                    <td>${customer.buildingNumber}</td>
                    <td>${customer.officeNumber}</td>
                    <td>${customer.email}</td>
                    <td>${customer.website}</td>
                    <td>
                        <div class="btn-group">
                            <a class="btn btn-default" href="/customers/${customer.id}"><spring:message code="show"/></a>
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="caret"></span>
                                <span class="sr-only">Toggle Dropdown</span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="/customers/${customer.id}/edit"><spring:message code="edit"/></a></li>
                                <li><a href="/customers/${customer.id}/delete"><spring:message code="delete"/></a></li>
                            </ul>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/views/include/footer.jsp" %>