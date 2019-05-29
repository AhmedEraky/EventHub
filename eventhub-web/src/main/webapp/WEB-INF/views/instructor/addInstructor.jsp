<%-- 
    Document   : addInstructor
    Created on : May 29, 2019, 2:08:40 AM
    Author     : Menna Helmy
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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

                        <!--addInstructor Form-->
                        <form:form id="demo-form2" method="post" class="form-horizontal form-label-left" modelAttribute="instructor" >


                                <!--bio-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="bio"><spring:message code="instructor.bio" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="bio" type="text" id="bio" name="bio" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--Job title-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><spring:message code="instructor.jobTitle" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="jobTitle" type="text" id="job-title" name="job-title" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>

                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                    <form:errors path="jobTitle"/>
                                </div>

                            </div>

                            

                                <!--deleted attribute-->

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message code="instructor.deleted" /></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="deleted" checked="true" class="flat" value="Yes" /><label><spring:message code="systemUser.deleted-true" /></label>
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="deleted"  class="flat" value="No"  /><label><spring:message code="systemUser.deleted-false" /></label>
                                        </label>
                                    </div>
                                </div>
                                <form:errors path="deleted"/>
                            </div>

                            
                            <!--system Users-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message code="instructor.systemUser" /></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:select path="users" items="${users}" itemLabel="name" itemValue="uuid" class="form-control">
                                    </form:select>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" class="btn btn-success" value="<spring:message code="Instructor.addInstructor" />"></input>
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
