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
                        <h2><spring:message code="addevent.page.header" /></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <br />

                        <!--SignUp Form-->
                        <form:form id="demo-form2" method="post" class="form-horizontal form-label-left" modelAttribute="event" enctype="multipart/form-data">


                            <!--Event Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="event-name"><spring:message code="addevent.event.name" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="name" type="text" id="event-name" name="event-name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--Event Short Description-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="short-description"><spring:message code="addevent.event.short.description" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="shortDescription" type="text" id="short-description" name="short-description" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--Event Long Description-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="long-description"><spring:message code="addevent.event.long.description" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:textarea path="longDescription" type="text" id="long-description" name="long-description" required="required" class="form-control col-md-7 col-xs-12"></form:textarea>
                                    </div>

                                    <!--<div class="col-md-3 col-sm-3 col-xs-12">-->
                                <%--<form:errors path="userName"/>--%>
                                <!--</div>-->

                            </div>

                            <!--Slogan-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="slogan"><spring:message code="addevent.event.slogan" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="slogan" type="text" id="slogan" name="slogan" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--Abbreviation-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="abbreviation"><spring:message code="addevent.event.abbreviation" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="abbreviation"  id="abbreviation" name="abbreviation" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>

                                <!--Logo-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="logo"><spring:message code="addevent.event.logo" />
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="logo"  id="logo" name="logo" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>   
                                    
                                    <!--Background-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="background"><spring:message code="addevent.event.background" />
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="background"  id="background" name="background" class="form-control col-md-7 col-xs-12"></form:input>
                                    </div>
                                </div>   
                                    
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message code="addevent.event.organization" /></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:select path="organization" items="${organizations}" itemLabel="name" itemValue="uuid" class="form-control">
                                    </form:select>
                                </div>
                            </div>
                                    
                            <!--Start Date-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message code="addevent.event.startDate" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="startDate" type="date" id="startDate" class="date-picker form-control col-md-7 col-xs-12" required="required" ></form:input>
                                    </div>
                            </div>
                                    
                            <!--End Date-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message code="addevent.event.endDate" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="endDate" type="date" id="endDate" class="date-picker form-control col-md-7 col-xs-12" required="required" ></form:input>
                                    </div>
                            </div>        
                                    
                                    <!--Address-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address"><spring:message code="addevent.event.address" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:textarea path="address" type="text" id="address" name="address" required="required" class="form-control col-md-7 col-xs-12"></form:textarea>
                                    </div>

                                    <!--<div class="col-md-3 col-sm-3 col-xs-12">-->
                                <%--<form:errors path="userName"/>--%>
                                <!--</div>-->

                            </div>
                                    

                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <input type="submit" class="btn btn-success" value="<spring:message code="addevent.event.add" />"></input>
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
