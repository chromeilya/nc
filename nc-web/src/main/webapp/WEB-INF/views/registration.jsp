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
<div class="wraper">
  <div>
    <h2>Регистрация студента</h2>
    <form:form method="POST" modelAttribute="student" action="/netcracker/new">
      <table>
        <tr>
          <td><label for="fio">ФИО: </label></td>
          <td><form:input path="fio"/></td>
        </tr>
        <tr>
          <td><label >Группа: </label></td>
          <td><form:select path="group" >
            <%--<c:forEach var="groupList" items="${groups}">
              <form:option value="${groupList}">${groupList.facult}</form:option>
            </c:forEach>--%>
            <form:options  items="${groups}" itemValue="id" itemLabel="facult"/>
            <form:option label="Без факультета" value="${null}"/>
          </form:select></td>
        </tr>
        <tr>
          <td><label for="type_stipend">Тип стипендии: </label></td>
          <td><form:input path="type_stipend"/></td>
        </tr>
        <tr>
          <td colspan="3"><input type="submit" value="Register"/></td>
        </tr>
      </table>
    </form:form>
  </div>
</div>
