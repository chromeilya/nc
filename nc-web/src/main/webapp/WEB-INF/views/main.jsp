<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h2>Список студентов</h2>
    <div>
      <table>
        <tr>
          <td>ФИО</td><td>Номер группы</td><td>Факультет</td><td>Стипендия</td><td>Дата зачисления</td><td>Удалить</td>
        </tr>
       <c:forEach items="${students}" var="student">
        <tr>
          <td>${student.fio}</td>
          <td>${student.group.group_num}</td>
          <td>${student.group.facult}</td>
          <td>${student.typeStipend}</td>
          <td>${student.joinDate}</td>
          <td><a href="<c:url value='/delete-${student.id}-student' />">Удалить</a></td>
        </tr>
       </c:forEach>
      </table>
    </div>
  </div>
</div>
