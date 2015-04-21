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
<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav">
            <li><a href="/netcracker/">Main</a></li>
            <li><a href="/netcracker/new">Create student</a></li>
            <li>
                <div class="searchform">
                    <form class="navbar-search" method="GET" action="search" accept-charset="utf-8">
                        <input class="input-long search-query" type="text" placeholder="Search.." name="search"/>
                        <input class="btn btn-small" type="submit"/>
                    </form>
                </div>
            </li>
        </ul>
    </div>
</div>