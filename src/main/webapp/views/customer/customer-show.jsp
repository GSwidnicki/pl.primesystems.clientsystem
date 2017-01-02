<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/views/include/head.jsp" %>
<%@ include file="/views/include/header.jsp" %>

            <p>${customer.id}</p>
            <p>${customer.taxNumber}</p>
            <p>${customer.companyName}</p>
            <p>${customer.street}</p>
            <p>${customer.buildingNumber}</p>
            <p>${customer.officeNumber}</p>
            <p>${customer.email}</p>
            <p>${customer.website}</p>

<%@ include file="/views/include/footer.jsp" %>