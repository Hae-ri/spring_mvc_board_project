<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글 쓰기</title>
</head>
<body>
	<h2>자유게시판 답글쓰기</h2><hr>
	<table width="400" cellpadding="0" cellspacing="0" border="1">
		<form action="reply">
		<input type="hidden" name="bid" value="${reply_view.bId }">
		<input type="hidden" name="bgroup" value="${reply_view.bGroup }">
		<input type="hidden" name="bstep" value="${reply_view.bStep }">
		<input type="hidden" name="bindent" value="${reply_view.bIndent }">
				
			<tr>
				<td align="center">번 호</td>
				<td>${reply_view.bId }</td>
			</tr>
			<tr>
				<td align="center">조회수</td>
				<td>${reply_view.bHit }</td>
			</tr>
			<tr>
				<td align="center">글제목</td>
				<td><input type="text" name="btitle" size="60" value="[re] ${reply_view.bTitle }"></td>
			</tr>
			<tr>
				<td align="center">글쓴이</td>
				<td><input type="text" name="bname" size="60"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">내용</td>
			</tr>	
			<tr>	
				<td colspan="2">
					<textarea name="bcontent" rows="10"  cols="100">
					${reply_view.bContent }
					
					------------------------------
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<a href="list">글 목록 보기</a>&nbsp;&nbsp;&nbsp;</a>
				</td>
			</tr>		
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="답글 입력">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>