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
                        <h2><spring:message code="app.session.header" /></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <br />

                        <!--SignUp Form-->
                        <form:form id="demo-form2" method="post" class="form-horizontal form-label-left" modelAttribute="session" enctype="multipart/form-data">


                            <!--Session Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name"><spring:message code="app.session.name" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="name" type="text" id="name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--Short Desc-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="shortDescription"><spring:message code="app.session.short_desc" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="shortDescription" type="text" id="last-name" name="shortDescription" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--Long Desc-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="longDescription"><spring:message code="app.session.long_desc" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:textarea path="longDescription" type="text" id="longDescription" name="shortDescription" required="required" class="form-control col-md-7 col-xs-12"></form:textarea>
                                    </div>
                                </div>    


                                <!--Session Type-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="sessionType"><spring:message code="app.session.session_type" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="sessionType" type="text" id="sessionType" name="sessionType" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>

                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                    <form:errors path="sessionType"/>
                                </div>

                            </div>

                            <!--Capacity-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="capacity"><spring:message code="app.session.capacity" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="capacity" type="number" id="capacity" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--Select Halls  -->
                                <div class="form-group">
                                    <form:select path="sessionInHalls" class="custom-select">
                                       
                                        <form:option value="0" selected=""><spring:message code="app.session.hall"/></form:option>
                                        <form:option value="1">One</form:option>
                                        <form:option value="2">Two</form:option>
                                        <form:option value="3">Three</form:option>
                                    </form:select>
                                    <form:errors path="sessionInHalls"/>
                                </div>
                                
                                <!--Select Vips  -->
                                <div class="form-group">
                                    <form:select path="vipSpeaksInSessions" class="custom-select">
                                        <form:option value="0" selected=""><spring:message code="app.session.vip"/></form:option>
                                        <form:option value="1">One</form:option>
                                        <form:option value="2">Two</form:option>
                                        <form:option value="3">Three</form:option>
                                    </form:select>
                                    <form:errors path="vipSpeaksInSessions"/>
                                </div>    

                            <!--Session Start Date-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><spring:message code="app.session.start_date" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="startDate" type="datetime-local"  id="startDate" name="startDate" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--Session End Date-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><spring:message code="app.session.end_date" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="endDate" type="datetime-local"  id="endDate" name="endDate" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>        


                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <input type="submit" class="btn btn-success" value="<spring:message code="app.session.addSession" />"></input>
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
