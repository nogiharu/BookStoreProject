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
<title>課題④ BookStore あいまい作品検索</title>
<style type="text/css">
.error {
color: #ff0000;
}
td {
width: 300px;
}
</style>
</head>
<body>
<h1>BookStore あいまい作品検索</h1>
<hr />
<div>
<f:form modelAttribute="bookStoreModel" action="vagueList" method="post">
<f:input path="vagueFiled" />
<input type="submit" value="検索" /><br />
<f:errors path="vagueFiled" cssClass="error"></f:errors>
</f:form>
</div>

<hr />
<div>
<a href="index">MENUへ</a>
</div>
<hr />

<c:if test="${productList != null }">
<p>検索結果</p>
<hr />
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

<p>${noData}</p>



</body>
</html>