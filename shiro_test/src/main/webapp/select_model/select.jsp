<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${requestScope.all}">
<option value="-1">全部状态</option>
</c:if>
<c:forEach items="${requestScope.optionlist}" var="r" varStatus="v">
	<c:if test="${v.index!=current}">
	<option value="${v.index}">${r}</option>
	</c:if>
	<c:if test="${v.index==current}">
	<option value="${v.index}" selected="selected">${r}</option>
	</c:if>
</c:forEach>
