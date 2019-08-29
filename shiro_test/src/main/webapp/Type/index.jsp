<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="m" uri="/WEB-INF/tag" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" src="../js/jquery-2.2.4.min.js"></script>
</head>
<body>
<script type="text/javascript">
/*  	var s="${opt}";
	function chan(o){
		if(o.value==0){
			a1.style.display="inline";
			a2.style.display="none";
		}else{
			a2.style.display="inline";
			a1.style.display="none";
		}
	}
	
	$(function(){
 		$("[name=opt]").val(s.length>0?s:0);
// 		var a = $("[name=opt]").attr("cur");
// 		$("[name=opt]").val(a?a:0);
		if(s.length==0||s==0){
			a1.style.display="inline";
			a2.style.display="none";
		}else{
			a2.style.display="inline";
			a1.style.display="none";
		}
	}) */
	
	
	$(function(){
	$("[name=bookid]").bind("change","",function(){
		var id=$(this).val();
		$.post("gettypess",{id:id},function(json){
			$("[name=id]").empty();
			for(var i=0;i<json.length;i++){
				$("[name=id]").append($("<option>").val(json[i].id).text(json[i].name));
			}
		},"json");
		
	});
	
});
</script>

<!-- <form action="index" method="post" entype="application/json"> -->

<%-- <select name="opt" onchange="chan(this)" cur="${opt }"> --%>
<!-- 	<option value="0">名称查询</option> -->
<!-- 	<option value="1">状态查询</option> -->
<!-- </select> -->
<%-- <input name="txt" id="a1" value="${txt}"> --%>
<!-- <select name="status" id="a2" style="display:none"> -->
<%-- 	<c:set var="all" value="true" scope="request"></c:set> --%>
<%-- 	<c:set var="optionlist" value="${statuslist}" scope="request"></c:set> --%>
<%-- 	<c:set var="current" value="${status}" scope="request"></c:set> --%>
<%-- 	<c:import url="../select_model/select.jsp"></c:import> --%>
<!-- </select> -->
<!-- <input type="submit"> -->
<!-- </form> -->
<%-- <c:forEach items="${list.list}" var="row"> --%>
<%-- ${row.name}<br> --%>
<%-- </c:forEach> --%>


<form action="index" method="post">
<m:selectbylist items="${booklist}" name="bookid" all="true" current="${info.bookid}"></m:selectbylist>
<m:selectbylist items="${typelist}" name="id" all="true" current="${info.id}"></m:selectbylist>
<input type="submit">
</form>
<c:forEach items="${list.list}" var="row">
${row.name}<br>
</c:forEach>

</body>
</html>