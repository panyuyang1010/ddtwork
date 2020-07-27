<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Employee Edit Form</title>
</head>

<body>
	<h2>編輯 員工資訊 表單</h2>
	<form action="#" th:action="@{/emp/editEmployee}" 
					 th:object="${employee}" method="post">
	
	    <table border="0" cellpadding="10">
	        <tr>
	            <td>員工姓名</td>
	            <td><input type="text" th:field="*{employeeName}" /></td>
	        </tr>
	        <tr>
	            <td>員工電話</td>
	            <td><input type="text" th:field="*{employeePhone}" /></td>
	        </tr>                          
	        <tr>
	            <td colspan="2"><button type="submit">儲存</button> </td>
	        </tr>
	    </table>
	</form>
</body>