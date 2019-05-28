<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>

    <spring:theme code="stylesheet" var="themeName" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <tiles:insertAttribute name="style" />


</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <tiles:insertAttribute name="leftNav"/>
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="body"/>
        <tiles:insertAttribute name="footer" />

    </div>
</div>

<tiles:insertAttribute name="script" />

</body>
</html>
