<%--
  Created by IntelliJ IDEA.
  User: Amr Elkady
  Date: 29/05/2019
  Time: 5:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!-- page content -->
<div class="right_col" role="main">
    <div class="">
        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">

                    <div class="x_title sign-up-direction ">
                        <h2><spring:message code="page.header"/></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <br/>

                        <%--@elvariable id="jobTitle" type="org.eventhub.common.model.entity.JobTitle"--%>
                        <form:form id="demo-form2" method="post" class="form-horizontal form-label-left" modelAttribute="jobTitle">

                            <!--Job Title Name-->
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">
                                    <spring:message code="jobTitle.name"/>  <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="name" type="text" id="name" required="required" class="form-control col-md-7 col-xs-12"></form:input>
                                    <form:errors path="name"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" class="btn btn-success" value="update Organization"></input>
                                </div>
                            </div>

                        </form:form>
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>
