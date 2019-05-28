<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eraky,Kady
    
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
                        <h2><spring:message code="page.header" /></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <br />

                        <!--SignUp Form-->
                        <form:form id="demo-form2" method="post" class="form-horizontal form-label-left" modelAttribute="systemUser" enctype="multipart/form-data">


                            <!--First Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name"><spring:message code="systemUser.firstName" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="firstName" type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--Last Name-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><spring:message code="systemUser.lastName" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="lastName" type="text" id="last-name" name="last-name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--User Name-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><spring:message code="systemUser.userName" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="userName" type="text" id="user-name" name="user-name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>

                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                    <form:errors path="userName"/>
                                </div>

                            </div>

                            <!--email-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name"><spring:message code="systemUser.email" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="email" type="email" id="email" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--PassWord-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><spring:message code="systemUser.password" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:password path="password"  id="password" name="Password" required="required" class="form-control col-md-7 col-xs-12"></form:password>
                                    </div>
                                </div>

                                <!--Confirm Password-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><spring:message code="systemUser.confirmPassword" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:password path="" id="confirmPassword" name="confirmPassword" required="required" class="form-control col-md-7 col-xs-12"></form:password>
                                    </div>
                                </div>

                                <!--Gender-->

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message code="systemUser.gender" /></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="gender" checked="true" class="flat" value="Male" /><label><spring:message code="systemUser.gender_male" /></label>
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="gender"  class="flat" value="Female"  /><label><spring:message code="systemUser.gender_female" /></label>
                                        </label>
                                    </div>
                                </div>
                                <form:errors path="gender"/>
                            </div>

                            <!--Date Of Birth-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message code="systemUser.dateOfBirth" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="dateOfBirth" type="date" id="birthday" class="date-picker form-control col-md-7 col-xs-12" required="required" ></form:input>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message code="systemUser.country" /></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:select path="country" items="${countries}" itemLabel="name" itemValue="uuid" class="form-control">
                                    </form:select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message code="systemUser.profileImage" /></label>
                                <label class="btn btn-primary btn-upload" for="inputImage" title="Upload image file">
                                    <input type="file" class="sr-only" id="inputImage" name="attachment" accept="image/*">
                                    <span class="docs-tooltip" data-toggle="tooltip" title="Upload image">
                                        <span class="fa fa-upload"></span>
                                    </span>
                                </label>
                            </div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" class="btn btn-success" value="<spring:message code="systemUser.signUp" />"></input>
                                </div>
                            </div>



                        </form:form>
                        <!--SignUp Of Login Form-->
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>
