<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 글목록</title>
</head>
<body>

	<h2>자유게시판 글 목록</h2>
	<hr>
	<table width="1000" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td align="center" bgcolor="#EAEAEA"><b>번호</b></td>
			<td align="center" bgcolor="#EAEAEA"><b>글제목</b></td>
			<td align="center" bgcolor="#EAEAEA"><b>글쓴이</b></td>
			<td align="center" bgcolor="#EAEAEA"><b>등록일</b></td>
			<td align="center" bgcolor="#EAEAEA"><b>조회수</b></td>
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
			<td align="right" colspan="5"><a href="write_view">글쓰기</a></td>
		</tr>
	</table>
</body>
</html>