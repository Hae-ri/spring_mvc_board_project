<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� �۸��</title>
</head>
<body>

	<h2>�����Խ��� �� ���</h2>
	<hr>
	<table width="1000" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td align="center">��ȣ</td>
			<td align="center">�۾���</td>
			<td align="center">������</td>
			<td align="center">�����</td>
			<td align="center">��ȸ��</td>
		</tr>
		
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.bId }</td>
				<td>${dto.bName }</td>
				<td>${dto.bTitle }</td>
				<td>${dto.bDate }</td>
				<td>${dto.bHit }</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5"><a href="write_view">�۾���</a></td>
		</tr>
	</table>
</body>
</html>