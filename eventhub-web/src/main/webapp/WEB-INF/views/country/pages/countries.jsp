<%--
  Created by IntelliJ IDEA.
  User: Mohamed
  Date: 6/19/2019
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
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
                        <display:table name="${countries}" style="odd">
                            <display:column property="name" title="Countries"/>
                            <display:column title="Edit"> 
<!--                                <a href="details.jsp?${row.id}">Details</a>-->
                                <a href="#">edit</a>
                            </display:column>
                            <display:column title="Delete"> 
                                <a href="#">delete</a>
                            </display:column>
                        </display:table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>