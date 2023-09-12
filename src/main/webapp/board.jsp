<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="java.util.*, board.*"%>
    <%
    request.setCharacterEncoding("utf-8");
    %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To-Do LIST</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script>
function imgCl(){
	location.reload();
}

$(document).ready(function(){
	$("input:checkbox").on('click', function(){
		if($(this).prop('checked')){
			$(this).closest('td').next().addClass("selected");
		} else{
			$(this).closest('td').next().removeClass("selected");
		}
	})
});

</script>
<style>
body{
margin:0;
padding:0;
font-size:14px;
}
#main{
margin:80px auto;
width:400px;
border:1px solid black;
}
#mainImg{
display:block;
margin:30px auto;
width:150px;
height:150px;
border-radius: 70%;
overflow: hidden;
}
table{
width:400px;
text-align:center;
}
.selected{
text-decoration: line-through;
}
</style>
</head>
<body>
<div id="main">
<img src="img.jpg" alt="지친 짱구 이미지" id="mainImg" onclick="location.href='board1004'">
<div id="input">
<form name=frm action="board1004" method="get">
<input type="hidden" name="command" value="addBoard"/>
<table>
<tr>
<td><input type="text" name="tdText" style="width:220px;" placeholder="할 일을 적어보세요" onfocus="this.placeholder=''" onblur="this.placeholder='할 일을 적어보세요'" autocomplete="off"/></td>
<td><input type="date" name="tdDate" style="width:95px;"/></td>
<td><input type="submit" value="입력" style="width:50px;"/></td>
</tr>
</table>
</form>
<div id="output">
<table>
<c:choose>
<c:when test="${listBoard!=null }">
<c:forEach var="td" items="${listBoard }">
<tr>
<td width="20px"><input type="checkbox" id="chck"></td>
<td class="tdText" onclick="location.href='board1004?bno=${td.bno}&command=delete'"> ${td.tdText }</td>
<td width="95px">${td.tdDate }</td>
</tr>
</c:forEach>
</c:when>
</c:choose>
</table>
</div>
</div>
</div>
</body>
</html>