<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eraky
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

                    <div class="x_title">
                        <h2>SignUp </h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <br />

                        <!--SignUp Form-->
                        <form:form id="demo-form2" method="post" class="form-horizontal form-label-left" modelAttribute="systemUser">


                            <!--First Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">
                                    First Name <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="firstName" type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--Last Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Last Name <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="lastName" type="text" id="last-name" name="last-name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--Last Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">User Name <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="userName" type="text" id="user-name" name="user-name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--email-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Email <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="email" type="email" id="email" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--PassWord-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Password <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:password path="password"  id="password" name="Password" required="required" class="form-control col-md-7 col-xs-12"></form:password>
                                </div>
                            </div>

                            <!--Confirm Password-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Confirm Password <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:password path="" id="confirmPassword" name="confirmPassword" required="required" class="form-control col-md-7 col-xs-12"></form:password>
                                </div>
                            </div>

                            <!--Gender-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Gender</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <div id="gender" class="btn-group" data-toggle="buttons">
                                        <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                            <form:radiobutton path="gender" name="gender" value="Male"></form:radiobutton> &nbsp; Male &nbsp;
                                        </label>
                                        <label class="btn btn-primary" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                            <form:radiobutton  path="gender"  name="gender" value="Female"></form:radiobutton> Female
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <!--Date Of Birth-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Date Of Birth <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="dateOfBirth" type="date" id="birthday" class="date-picker form-control col-md-7 col-xs-12" required="required" ></form:input>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Country</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="country" type="text" name="country" id="autocomplete-custom-append" class="form-control col-md-10"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" class="btn btn-success" value="SignUp"></input>
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
