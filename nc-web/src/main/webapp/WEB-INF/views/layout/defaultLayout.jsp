<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 4/13/15
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
</head>
<body style="background-color: #FFF">
<div class="page">
    <tiles:insertAttribute name="header"/>
    <div class="content">
        <div id="body">
            <tiles:insertAttribute name="body"/>
        </div>
    </div>
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>
