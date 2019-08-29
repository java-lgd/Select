<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="m" uri="/WEB-INF/tag" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form action="index" method="post">

<m:selectbyarray items="${statuslist}" name="txt"  all="true" current="${status}"></m:selectbyarray>

<m:selectbylist items="${list.list}" name="aa"  current="1" ></m:selectbylist>
<input type="submit">
</form>
<c:forEach items="${list.list}" var="row">
${row.name}<br>
</c:forEach>

</body>
</html>