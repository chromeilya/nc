<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 4/7/15
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <h2>Регистрация студента</h2>
    <form:form method="POST" modelAttribute="student">
      <table>
        <tr>
          <td><label for="fio">ФИО: </label></td>
          <td><form:input path="fio" id="fio"/></td>
          <td><form:errors path="fio" cssClass="error"/></td>
        </tr>
        <tr>
          <td><label >Группа: </label></td>
          <td><form:select path="group" >
            <form:options  items="${groups}" itemValue="id" itemLabel="facult"/>
            <form:option label="Без факультета" value="${null}"/>
          </form:select></td>
        </tr>
        <tr>
          <td><label for="typeStipend">Тип стипендии: </label></td>
          <td><form:input path="typeStipend" id="typeStipend"/></td>
          <td><form:errors path="typeStipend" cssClass="error"/></td>
        </tr>
        <tr>
          <td><label for="joinDate">Дата зачисления: </label></td>
          <td><form:input path="joinDate" id="joinDate"/></td>
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