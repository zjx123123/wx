<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书馆首页</title>
<link href="/zjx/library/css/main.css" rel="stylesheet"/>
<style>
body{
 padding:10px;
 font-size:30px;
 aligin:center;
 heigth:1500px;
 width:1500px;
}
#a{
font-size:50px;
float:right;
height:20%;
width:20%;
}
#p01{
border-style:inset;

}
.item{
height:50px;
widtn:50px;
}
.buttons{
background-color:#cccccc;
}

</style>

</head>
<body>

	<form method="get">
		<%-- param是EL表达式的内置对象，表示所有的请求参数 --%>
		<%-- ${param.keyword }使用EL表达式把名为keyword的请求参数的值获取出来 --%>
		<div  id="a" ><img alt="" src="/zjx/library/images/14325793.jpg">
		<p id="p01">科贸图书馆！！
		</p>
		</div>
		<input name='keyword' value="${param.keyword }" style="width:200px;height:30px;"/>
		<button style="width:100px;height:30px;">搜索</button>
	</form>
	<!-- 这里应该要循环从服务器返回的数据 -->
<%-- 	<%
	Page<Book> page = request.getAttribute("page");
	List<Book> content = page.getContent();
	for( Book book : content ){
	%>
		<div>
			<%=book.getName() %>
			+
		</div>
	<%} %> --%>
	
	<!-- 循环标签库 -->
	<!-- items是标签的属性，表示要遍历哪些元素 -->
	<%-- ${ page.content } 其实相当于前面的 request.getAttribute("page") + content = page.getContent() --%>
	<c:forEach items="${page.content }" var="book"
	>
		<%-- book.name相当于是book.getName() --%>
		<div class="item">
	
			<img style="" alt="" src="/zjx/library/images/${book.image }" />
			<div class="name">
				${book.name }
			</div>
			<div class="buttons">
				<span onclick="document.location.href='/zjx/library/debit?bookId=${book.id}'">添加图书</span>
			</div>
		</div>
	</c:forEach>
	
	<!-- 分页的按钮 -->
	<div>
		<c:if test="${page.number <= 0 }">
			<a>上一页</a>
		</c:if>
		<c:if test="${page.number > 0 }">
			<a href="?pageNumber=${page.number - 1 }&keyword=${param.keyword}">上一页</a>
		</c:if>
		<%-- 为什么要减一？因为number从0开始，而totalPages从1开始 --%>
		<c:if test="${page.number < page.totalPages - 1 }">
			<a href="?pageNumber=${page.number + 1 }&keyword=${param.keyword}">下一页</a>
		</c:if>
		<c:if test="${page.number >= page.totalPages - 1 }">
			<a>下一页</a>
		</c:if>
	</div>
	
</body>
</html>