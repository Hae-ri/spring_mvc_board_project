<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 보기</title>
</head>
<body>
	<h2>자유게시판 글보기</h2><hr>
	<table width="400" cellpadding="0" cellspacing="0" border="1">
		<form action="modify" method="post">
		<input type="hidden" name="bid" value="${content_view.bId }">
				
			<tr>
				<td align="center">번 호</td>
				<td>${content_view.bId }</td>
			</tr>
			<tr>
				<td align="center">조회수</td>
				<td>${content_view.bHit }</td>
			</tr>
			<tr>
				<td align="center">글제목</td>
				<td><input type="text" name="btitle" size="60" value="${content_view.bTitle }"></td>
			</tr>
			<tr>
				<td align="center">글쓴이</td>
				<td><input type="text" name="bname" size="60" value="${content_view.bName }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">내용</td>
			</tr>	
			<tr>	
				<td colspan="2">
					<textarea name="bcontent" rows="10"  cols="100">${content_view.bContent }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<a href="list">글 목록 보기</a>&nbsp;&nbsp;&nbsp;
					<a href="reply_view?bId=${content_view.bId }">답변쓰기</a>&nbsp;&nbsp;&nbsp;
					<a href="delete?bId=${content_view.bId }">글 삭제</a>
				</td>
			</tr>		
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글 수정">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>