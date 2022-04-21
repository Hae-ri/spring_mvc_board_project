<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			<td align="center" bgcolor="#EAEAEA"><b>��ȣ</b></td>
			<td align="center" bgcolor="#EAEAEA"><b>������</b></td>
			<td align="center" bgcolor="#EAEAEA"><b>�۾���</b></td>
			<td align="center" bgcolor="#EAEAEA"><b>�����</b></td>
			<td align="center" bgcolor="#EAEAEA"><b>��ȸ��</b></td>
		</tr>
		
		<c:forEach items="${list}" var="dto">
			<tr>
				<td align="center">${dto.bId }</td>
				<td>
					<c:forEach begin="1" end="${dto.bIndent }">&nbsp;&nbsp;&nbsp;</c:forEach>
					<a href="content_view?bId=${dto.bId }">${dto.bTitle }</a>		
				</td>
				<td align="center">${dto.bName }</td>
				<td align="center">${dto.bDate }</td>
				<td align="center">${dto.bHit }</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td align="right" colspan="5"><a href="write_view">�۾���</a></td>
		</tr>
	</table>
</body>
</html>