<%-- 
    Document   : sessionTypeForm
    Created on : May 29, 2019, 12:14:34 AM
    Author     : Hend Zabady
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- page content -->
<div class="right_col" role="main">
    <div class="">
        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">

                    <div class="x_title sign-up-direction ">
                        <h2><spring:message code="sessionType.page.header" /></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <br />

                        <!--Session Types Form-->
                        <form:form id="demo-form2" method="post" class="form-horizontal form-label-left" modelAttribute="sessionType">


                            <!-- Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="session-name"><spring:message code="sessionType.name" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="name" type="text" id="session-name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--Description-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="session-description"><spring:message code="sessionType.description" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="description" type="text" id="session-description" name="session-description" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--Style-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="session-style"><spring:message code="sessionType.style" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="style" type="text" id="session-style" name="session-style" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>

                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                    <form:errors path="name"/>
                                </div>

                            </div>

                            
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" class="btn btn-success" value="<spring:message code="sessionType.add" />">
                                </div>
                            </div>


                        </form:form>
                        <!--Session type Form-->
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>

