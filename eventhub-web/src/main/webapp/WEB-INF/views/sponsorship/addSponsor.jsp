<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ali
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
                        <h2><spring:message code="sponsor.add.header" /></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <br />

                        <!--Add sponsor Form-->
                        <form:form id="demo-form2" method="post" class="form-horizontal form-label-left" modelAttribute="sponsor" enctype="multipart/form-data">


                                <!--Name-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name"><spring:message code="sponsor.name" />
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <form:input path="name" type="text" id="name" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        <form:errors path="name"/>
                                    </div>
                                </div>

                                <!--Description-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="description"><spring:message code="sponsor.description" />
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <form:input path="description" type="text" id="description" name="description" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        <form:errors path="description"/>
                                    </div>
                                </div>

                                <!--Logo-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message code="sponsor.logo" /></label>
                                    <label class="btn btn-primary btn-upload" for="logo" title="Upload image file">
                                        <input type="file" class="sr-only" id="logo" name="attachment" accept="image/*">
                                        <span class="docs-tooltip" data-toggle="tooltip" title="Upload image">
                                            <span class="fa fa-upload"></span>
                                        </span>
                                    </label>
                                </div>

                                <!--Url-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="url"><spring:message code="sponsor.url" />
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <form:input path="url" type="text" id="url" name="url" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        <form:errors path="url"/>
                                    </div>
                                </div>

                                <!--Sponsorship type-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message code="sponsor.sponsorship.type" /> <span class="required"></span>*</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <form:select path="sponsorshipType" items="${sponsorshipTypes}" itemLabel="name" itemValue="uuid" class="form-control">
                                        </form:select>
                                    </div>
                                </div>
                            
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" class="btn btn-success" value="<spring:message code="sponsor.add" />"></input>
                                </div>
                            </div>
                            
                            <form:hidden path="uuid"/>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>



                        </form:form>
                        
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>
