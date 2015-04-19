<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 4/7/15
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <style>
    .error {
      color: #ff0000;
    }
  </style>
</head>
<body>
<div class="wraper">
  <div>
    <h2>Create new student</h2>
    <form:form method="POST" modelAttribute="student">
      <table>
        <tr>
          <td><label for="fio">FIO: </label></td>
          <td><form:input path="fio" id="fio"/></td>
          <td><form:errors path="fio" cssClass="error"/></td>
        </tr>
        <tr>
          <td><label >Group: </label></td>
          <td><form:select path="group" >
            <form:options  items="${groups}" itemValue="id" itemLabel="facult"/>
            <form:option label="Empty facult" value="${null}"/>
          </form:select></td>
        </tr>
        <tr>
          <td><label for="typeStipend">Type stipend: </label></td>
          <td><form:input path="typeStipend" id="typeStipend"/></td>
          <td><form:errors path="typeStipend" cssClass="error"/></td>
        </tr>
        <tr>
          <td><label for="joinDate">Joining date: </label></td>
          <td><form:input type="date" path="joinDate" id="joinDate"/></td>
          <td><form:errors path="joinDate" cssClass="error"/></td>
        </tr>
        <tr>
          <td colspan="3"><input type="submit" value="Register"/></td>
        </tr>
      </table>
    </form:form>
  </div>
</div>
</body>
</html>