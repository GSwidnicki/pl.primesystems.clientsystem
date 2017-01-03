<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="/customers" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="customers"/> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/customers"><spring:message code="customersList"/></a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="/customers/add"><spring:message code="addNewCustomer"/></a></li>
                        </ul>
                    </li>
                    <li><a href="/contacts"><spring:message code="contacts"/></a></li>
                    <li><a href="/calendar"><spring:message code="calendar"/></a></li>
                    <li><a href="/products"><spring:message code="products"/></a></li>
                    <li><a href="/sale"><spring:message code="sale"/></a></li>
                    <li><a href="/reports"><spring:message code="reports"/></a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<%@ include file="/views/include/footer.jsp" %>