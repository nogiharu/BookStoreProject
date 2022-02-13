<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>課題④ BookStore 全件検索</title>
<style type="text/css">
td {
width: 300px;
}
</style>
</head>
<body>
<h1>BookStore 全件検索</h1>
<hr />
<div>
<f:form modelAttribute="bookStoreModel" action="allList" method="post">
<f:radiobutton path="selectRadio" label="作者一覧" value="A" checked="true" />
<f:radiobutton path="selectRadio" label="作品一覧" value="P"/>
<input type="submit" value="検索" />
</f:form>
</div>
<hr />
<div>
<a href="index">MENUへ</a>
</div>
<hr />
<div>
<!-- 作者一覧 -->
<c:if test="${bookStoreModel.selectRadio == 'A' }">
<p>作者一覧</p>
<table border="2">
<tr>
<th>作者名</th><th>作品名</th><th>出版年</th>
</tr>
<c:forEach var="a" items="${authorList}">
<c:forEach var="p" items="${a.productList}">
<tr>
<td><c:out value="${a.author_name}"></c:out></td>
<td><c:out value="${p.product_name}"></c:out></td>
<td><c:out value="${p.publication_year}年"></c:out></td>
</tr>
</c:forEach>
</c:forEach>
</table>
</c:if>

<!-- 作品一覧 -->
<c:if test="${bookStoreModel.selectRadio == 'P' }">
<p>作品一覧</p>
<table border="2">
<tr>
<th>作品名</th><th>出版年</th><th>作者名</th>
</tr>
<c:forEach var="p" items="${productList}">

<tr>
<td><c:out value="${p.product_name}"></c:out></td>
<td><c:out value="${p.publication_year}年"></c:out></td>
<td><c:out value="${p.at.author_name}"></c:out></td>
</tr>

</c:forEach>
</table>
</c:if>




</div>
</body>
</html>