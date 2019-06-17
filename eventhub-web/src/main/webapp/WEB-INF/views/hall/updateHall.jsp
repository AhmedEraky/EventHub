<%--
  Author: Islam El-Rougy
  Date: 5/29/2019
  Time: 6:12 PM
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
                        <h2><spring:message code="page.header" /></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <br />

                        <!--Add Hall Form-->
                        <form:form id="demo-form2" method="post" class="form-horizontal form-label-left" modelAttribute="hall">


                            <!--Hall Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name"><spring:message code="hall.name" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="name" type="text" id="name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--Building Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="building"><spring:message code="hall.building" />
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="building" type="text" id="building" name="building" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>


                            <!--Floor-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="floor"><spring:message code="hall.floor" />
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="floor" id="floor" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--Capacity-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="capacity"><spring:message code="hall.capacity" />
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="capacity"  id="capacity" name="capacity" type="Number" min="0" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>




                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" class="btn btn-success" value="<spring:message code="hall.submit" />"></input>
                                </div>
                            </div>


                            <form:hidden path="uuid" />
                            <form:hidden path="event.uuid" />
                        </form:form>

                    </div>

                </div>
            </div>
        </div>

    </div>
</div>

