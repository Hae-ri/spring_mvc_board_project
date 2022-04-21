<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	<h2>자유게시판 글쓰기</h2>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write" method="post">		
			<tr>
				<td>이름</td>
				<td><input type="text" name="bname" size="65"></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type="text" name="btitle" size="65"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bcontent" cols="50" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="3" align="right"><input type="submit" value="등록">&nbsp;&nbsp;&nbsp;
				<a href="list">목록보기</a></td>
			</tr>
		</form>
	</table>
</body>
</html>