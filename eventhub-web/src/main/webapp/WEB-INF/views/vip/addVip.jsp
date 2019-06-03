
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Document   : addVip
    Created on : May 28, 2019, 10:49:15 PM
    Author     : Aya Taha
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
                        <h2><spring:message code="page.head" /></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <br />

                        <!--Add Vip Form-->
                        <form:form id="demo-form2" method="post" class="form-horizontal form-label-left" modelAttribute="vip" enctype="multipart/form-data">

                            <!-- Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name"><spring:message code="vip.name" /><span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="name" type="text" id="name" name="name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>

                            <!--Bio-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="bio"><spring:message code="vip.bio" /> <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="bio" type="text" id="bio" name="bio" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                </div>
                            </div>









                            <%--<!-- Image-->--%>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message code="vip.image" /></label>
                                <label class="btn btn-primary btn-upload" for="inputImage" title="Upload image file">
                                    <input type="file" class="sr-only" id="inputImage" name="vipImage" accept="image/*">
                                    <span class="docs-tooltip" data-toggle="tooltip" title="Upload image">
                                        <span class="fa fa-upload"></span>
                                    </span>
                                </label>
                            </div>



                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" class="btn btn-success" value="<spring:message code="vip.addVip" />"></input>
                                </div>
                            </div>


                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form:form>

                    </div>

                </div>
            </div>
        </div>

    </div>
</div>

