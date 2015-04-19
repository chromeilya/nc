<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 4/7/15
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wraper">
  <a href="/netcracker/">Main</a>
  <a href="/netcracker/new">Create student</a>
  <div class="searchform">
    <br/>
    <form method="GET" action="search" accept-charset="utf-8">
      <label for="search">Search: </label>
      <input onfocus type="text" id="search" name="search"/>
      <input type="submit"/>
    </form>
  </div>
</div>