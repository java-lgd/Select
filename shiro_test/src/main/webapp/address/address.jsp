<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../js/jquery-2.2.4.min.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">

var adr = "";
adr += $("#provinceoption:selected").text()+" "
                        + $("#city option:selected").text()+" "
                        + $("#country option:selected").text();

var  citys=city.split(" ");

$("#province option").each(function() { 
	if($(this).text()==citys[0]){
    $(this).attr("selected",true);
    //var sheng = $(this).val();
    f1(citys[1],citys[2])
 }
})  

$(function() {
    $.post("getSJLD.action", {
        pid : 1
    }, function(data) {
        for ( var i in data) {
            var op = $("<option value='"+data[i].id+"'>" + data[i].cityname
                    + "</option>");
            $("#province").append(op);
        }
    }, "json"
    )
})

 function f1(city,country) {
        $.post("getSJLD.action", {
            pid : $("#province").val()
        }, function(data) {
            $("#city").empty();
            for ( var i in data) {
                var op = $("<option id='city"+data[i].id+"' value='"+data[i].id+"'>" + data[i].cityname
                        + "</option>");
                $("#city").append(op);
                        if(city!=null){
                            $("#city option").each(function(){
                                if($(this).text()==city){
                                    $(this).attr("selected",true)
                                }
                                f2(country)                 
                            })
                        }
            }
        }, "json")
    }
    
function f2(country) {
    $.post("getSJLD.action", {
        pid : $("#city").val()
    }, function(data) {
        $("#country").empty();
        for ( var i in data) {
            var op = $("<option>" + data[i].cityname + "</option>");
            $("#country").append(op);
            if(country!=null){
                        $("#country option").each(function(){
                            if($(this).text()==country){
                                $(this).attr("selected",true)
                            }

                        })
                    }
        }
    }, "json")
}

</script>
<body>
	<tr>
                <td>地址:</td>
                <!--第一级:省 -->
                <td><select id="province" name="province" onchange="f1()">
                        <option>---请选择---</option>
                <!--第二级:市 -->
                </select> <select id="city" name="city" onclick="f2()">
                        <option>---请选择---</option>
                  <!--第三级:县 -->
                </select> <select name="country" id="country">
                        <option>---请选择---</option>
                </select></td>
            </tr>
</body>
</html>