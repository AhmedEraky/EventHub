<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- page content -->
<div class="right_col" role="main">
  <div>
    <div class="clearfix"></div>
    <div class="row">
      <div class="col-md-12 col-sm-12 col-xs-12">
        <c:if test="${param.success ne null}">
            <div class="alert alert-success alert-dismissible fade in" role="alert">
              <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span>
              </button>
              <strong>Holy guacamole!</strong> Best check yo self, you're not looking too good.
            </div>
        </c:if>
        <div class="x_panel">
          <div class="x_title sign-up-direction ">
            <h2><spring:message code="addcountry.page.header"/></h2>
            <div class="clearfix"></div>
          </div>
          <div class="x_content">
            <form:form id="demo-form2" method="post" class="form-horizontal form-label-left"
                       modelAttribute="country">
                <!--First Name-->
                <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="country-name">
                    <spring:message code="addcountry.country.name" />
                    <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <form:input path="name" type="text" id="country-name" 
                                required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
                </div>
                <form:input path="uuid" type="hidden"/>
                <div class="form-group">
                  <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                    <input type="submit" class="btn btn-success" 
                           value="<spring:message code="addcountry.add"/>"></input>
                  </div>
                </div>
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>