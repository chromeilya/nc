<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 4/7/15
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper">
    <div>
        <h3 class="stud-h3">Student list</h3>
        <h4 class="inform">${success}</h4>

        <div>
            <table class="table table-striped table-condensed table-bordered">
                <thead  class="main-tr">
                    <tr>
                        <td>FIO</td>
                        <td>№ group</td>
                        <td>Facultet</td>
                        <td>Stipend</td>
                        <td>Joining date</td>
                        <td>Edit</td>
                        <td>Delete</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${students}" var="student">
                        <tr>
                            <td>${student.fio}</td>
                            <td>${student.group.group_num}</td>
                            <td>${student.group.facult}</td>
                            <td>${student.typeStipend}</td>
                            <td>${student.joinDate}</td>
                            <td><a href="<c:url value='/edit-${student.id}-student' />"><i class="icon-pencil"></i></a></td>
                            <td><a href="<c:url value='/delete-${student.id}-student' />"><i class="icon-remove"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
