<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/views/include/head.jsp" %>
<%@ include file="/views/include/header.jsp" %>
<%@ include file="/views/include/navbar.jsp" %>
<div class="container">
    <div>
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Dane klienta</a></li>
            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Kontakty z klientem</a></li>
            <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Zakupy klienta</a></li>
        </ul>
        <div class="panel-body">
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <p>${customer.id}</p>
                    <p>${customer.taxNumber}</p>
                    <p>${customer.companyName}</p>
                    <p>${customer.street}</p>
                    <p>${customer.buildingNumber}</p>
                    <p>${customer.officeNumber}</p>
                    <p>${customer.email}</p>
                    <p>${customer.website}</p>
                    <p>
                        <c:forEach items="${customer.phoneNumbers}" var="phone">
                            <p>${phone.phoneNumber}</p>
                        </c:forEach>
                    </p>
                </div>
                <div role="tabpanel" class="tab-pane" id="profile">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th class="col-sm-1">Data kontaktu</th>
                                <th class="col-sm-1">Osoba kontaktowa</th>
                                <th class="col-sm-4">Opis kontaktu</th>
                                <th class="col-sm-1">Data kolejnego kontaktu</th>
                                <th class="col-sm-1">Osoba wyznaczona</th>
                                <th class="col-sm-4">Co dalej?</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${contactList}" var="contact">
                                <tr>
                                    <td>${contact.contactDate}</td>
                                    <td>${contact.user.firstName} ${contact.user.lastName}</td>
                                    <td>${contact.description}</td>
                                    <td>${contact.nextContactDate}</td>
                                    <td>${contact.assignedUser.firstName} ${contact.assignedUser.lastName}</td>
                                    <td>${contact.taskToDo}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                </div>
                <div role="tabpanel" class="tab-pane" id="messages">
                    c
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/views/include/footer.jsp" %>