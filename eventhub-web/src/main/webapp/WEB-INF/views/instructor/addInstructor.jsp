<%-- 
    Document   : addInstructor
    Created on : May 29, 2019, 2:08:40 AM
    Author     : Menna Helmy
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="right_col" role="main">
    <div class="">
        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">

                    <div class="x_title sign-up-direction ">
                        <h2><spring:message code="instructor.page.header"/></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <br/>

                        <!--addInstructor Form-->
                        <form:form id="demo-form2" method="post" class="form-horizontal form-label-left"
                                   modelAttribute="instructor">

                            <!--First Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12"
                                       for="first-name"><spring:message code="systemUser.firstName"/><span
                                        class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="systemUser.firstName" type="text" id="first-name"
                                                required="required"
                                                class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--Last Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><spring:message
                                        code="systemUser.lastName"/> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="systemUser.lastName" type="text" id="last-name" name="last-name"
                                                required="required"
                                                class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--User Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><spring:message
                                        code="systemUser.userName"/><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="systemUser.userName" type="text" id="user-name" name="user-name"
                                                required="required"
                                                class="form-control col-md-7 col-xs-12"></form:input>
                                </div>

                                <div class="col-md-3 col-sm-3 col-xs-12">
                                    <form:errors path="systemUser.userName"/>
                                </div>

                            </div>

                            <!--email-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12"
                                       for="first-name"><spring:message code="systemUser.email"/> <span
                                        class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="systemUser.email" type="email" id="email" required="required"
                                                class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--PassWord-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><spring:message
                                        code="systemUser.password"/> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:password path="systemUser.password" id="password" name="Password"
                                                   required="required"
                                                   class="form-control col-md-7 col-xs-12"></form:password>
                                </div>
                            </div>

                            <!--Confirm Password-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><spring:message
                                        code="systemUser.confirmPassword"/><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:password path="" id="confirmPassword" name="confirmPassword"
                                                   required="required"
                                                   class="form-control col-md-7 col-xs-12"></form:password>
                                </div>
                            </div>

                            <!--Gender-->

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
                                        code="systemUser.gender"/></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="systemUser.gender" checked="true" class="flat"
                                                              value="Male"/><label><spring:message
                                                code="systemUser.gender_male"/></label>
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="systemUser.gender" class="flat"
                                                              value="Female"/><label><spring:message
                                                code="systemUser.gender_female"/></label>
                                        </label>
                                    </div>
                                </div>
                                <form:errors path="systemUser.gender"/>
                            </div>

                            <!--Date Of Birth-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
                                        code="systemUser.dateOfBirth"/> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="systemUser.dateOfBirth" type="date" id="birthday"
                                                class="date-picker form-control col-md-7 col-xs-12"
                                                required="required"></form:input>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
                                        code="systemUser.country"/></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:select path="systemUser.country" items="${countries}" itemLabel="name"
                                                 itemValue="uuid"
                                                 class="form-control">
                                    </form:select>
                                </div>
                            </div>
                            <!--bio-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="bio"><spring:message
                                        code="instructor.bio"/> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="bio" type="text" id="bio" name="bio" required="required"
                                                class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--Job title-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
                                        code="instructor.jobTitle"/><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="jobTitle" type="text" id="job-title" name="job-title"
                                                required="required"
                                                class="form-control col-md-7 col-xs-12"></form:input>
                                </div>

                                <div class="col-md-3 col-sm-3 col-xs-12">
                                    <form:errors path="jobTitle"/>
                                </div>

                                <!--User Image -->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
                                            code="systemUser.profileImage"/></label>
                                    <label class="btn btn-primary btn-upload" for="inputImage"
                                           title="Upload image file">
                                        <input type="file" class="sr-only" id="inputImage" name="attachment"
                                               accept="image/*">
                                        <span class="docs-tooltip" data-toggle="tooltip" title="Upload image">
                                        <span class="fa fa-upload"></span>
                                    </span>
                                    </label>
                                </div>

                            </div>

                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" class="btn btn-success"
                                           value="<spring:message code="instructor.addInstructor" />"></input>
                                </div>
                            </div>


                        </form:form>
                        <!--add instructor Form-->
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>
