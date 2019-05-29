<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mahmoud Shereif
    
  Date: 5/26/2019
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- page content -->
<div class="right_col" role="main">
    <div class="">
        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">

                    <div class="x_title sign-up-direction ">
                        <h2><spring:message code="sponsoreShipType.update.pageheader" /></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <br />

                        <!--Create SponsoreShipType Form-->
                        <form:form id="demo-form2" method="post" class="form-horizontal form-label-left" modelAttribute="sponsoreShipType">


                            <!--Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name"><spring:message code="sponsoreShipType.name" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="name" type="text" id="name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--description-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="description"><spring:message code="sponsoreShipType.description" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="description" type="text" id="description" name="description" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" class="btn btn-success" value="<spring:message code="sponsoreShipType.update" />"></input>
                                </div>
                            </div>

                            <form:hidden path="uuid" />
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        </form:form>

                    </div>

                </div>
            </div>
        </div>

    </div>
</div>
