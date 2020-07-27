<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Employees</title>
</head>
 
<body>
 
<div th:switch="${employees}">
    <h2 th:case="null">尚沒有員工資訊!</h2>
        <div th:case="*">
            <h2>列出所有的員工資訊</h2>
            <table>
                <thead>
                    <tr>
                        <th>員工編號</th>
                        <th>員工姓名</th>
                        <th>員工編號</th>
						<th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                <tr th:each="employee : ${employees}">
                    <td th:text="${employee.employeeID}"></td>
                    <td th:text="${employee.employeeName}"></td>
					<td th:text="${employee.employeePhone}"></td>
                    <td><a th:href="@{/emp/edit/{id}(id=${employee.employeeID})}">Edit</a></td>
                    <td><a th:href="@{/emp/delete/{id}(id=${employee.employeeID})}">Delete</a></td>
                </tr>
            </tbody>
        </table>
    </div>      
    <p><a href="/emp/addEmp">新增員工資訊</a></p>
</div>
 
</body>
</html>