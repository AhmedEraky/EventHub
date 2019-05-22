<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<spring:message code=""/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.title"/> </title>

<spring:theme code="stylesheet" var="themeName" />
<link href='<spring:url value="/resources/css/${themeName}"/>' rel="stylesheet" />

</head>
<body>
   
    
    <a href="goBody" >Go Body</a>
    
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>