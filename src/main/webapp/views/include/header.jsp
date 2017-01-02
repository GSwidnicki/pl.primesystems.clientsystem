<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container">
    <div class="row">
        <div class="col-lg-2">
            <a href="/"><img src="${pageContext.servletContext.contextPath}/resources/images/logo.png" alt="Prime Systems"/></a>
        </div>
        <div class="col-lg-3">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Wyszukaj...">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button">Szukaj</button>
                </span>
            </div>
        </div>
        <div class="col-lg-3">
                <div class="panel panel-default panel-lang">
                    <div class="panel-heading">
                        <h3 class="panel-title"><spring:message code="selectLang"/></h3>
                    </div>
                    <div class="panel-body">
                        <div class="btn-group" role="group">
                            <a class="btn btn-default" href="?lang=pl"><spring:message code="polish"/></a>
                            <a class="btn btn-default" href="?lang=en"><spring:message code="english"/></a>
                        </div>
                    </div>
                </div>
            </div>
        <div class="col-lg-4">
                <div class="panel panel-default panel-user">
                    <div class="panel-heading">
                        <h3 class="panel-title">Zalogowany jako: Grzegorz Świdnicki</h3>
                    </div>
                    <div class="panel-body">
                        Stanowisko: Przedstawiciel handlowy<br />
                        Dziś jest: wtorek, 22.12.2015<br />
                        <a href="?logout">Wyloguj</a>
                    </div>
                </div>
            </div>
    </div>
</div>