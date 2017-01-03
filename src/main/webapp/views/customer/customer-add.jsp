<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/views/include/head.jsp" %>
<%@ include file="/views/include/header.jsp" %>
<%@ include file="/views/include/navbar.jsp" %>
<div class="container">
    <form class="form-horizontal" method="post" action="/customers/add">
        <div class="form-group">
            <label for="taxNumber" class="col-sm-3 control-label"><spring:message code="taxNumber"/></label>
            <div class="col-sm-6">
                <input name="taxNumber" type="number" maxlength="10" class="form-control no-spinners" id="taxNumber" placeholder="<spring:message code="taxNumber"/>" required>
            </div>
        </div>
        <div class="form-group">
            <label for="companyName" class="col-sm-3 control-label"><spring:message code="companyName"/></label>
            <div class="col-sm-6">
                <input name="companyName" type="text" class="form-control" id="companyName" placeholder="<spring:message code="companyName"/>" required>
            </div>
        </div>
        <div class="form-group">
            <label for="street" class="col-sm-3 control-label"><spring:message code="street"/></label>
            <div class="col-sm-6">
                <input name="street" type="text" class="form-control" id="street" placeholder="<spring:message code="street"/>" required>
            </div>
        </div>
        <div class="form-group">
            <label for="buildingNumber" class="col-sm-3 control-label"><spring:message code="buildingNumber"/></label>
            <div class="col-sm-6">
                <input name="buildingNumber" type="text" class="form-control" id="buildingNumber" placeholder="<spring:message code="buildingNumber"/>" required>
            </div>
        </div>
        <div class="form-group">
            <label for="officeNumber" class="col-sm-3 control-label"><spring:message code="officeNumber"/></label>
            <div class="col-sm-6">
                <input name="officeNumber" type="text" class="form-control" id="officeNumber" placeholder="<spring:message code="officeNumber"/>">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-3 control-label"><spring:message code="email"/></label>
            <div class="col-sm-6">
                <input name="email" type="email" class="form-control" id="email" placeholder="<spring:message code="email"/>">
            </div>
        </div>
        <div class="form-group">
            <label for="website" class="col-sm-3 control-label"><spring:message code="website"/></label>
            <div class="col-sm-6">
                <input name="website" type="text" class="form-control" id="website" placeholder="<spring:message code="website"/>">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-6">
                <button type="submit" class="btn btn-default"><spring:message code="save"/></button>
            </div>
        </div>
    </form>
</div>
<%@ include file="/views/include/footer.jsp" %>