<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
   var count=1;
   $(function(){
	   $.getJSON("ajaxlistkehu.do",{currentPage:count},function(data){
		   $("#tab_page").append($("<tr>").html("jjj"));
	   })
	   
	   $("#btn_provious").click(function(){
		   if(--count<1){
			   count=1;
		   }
		   $("#tab_page").load("ajaxlistkehu.do",{currentPage:count},function(){})
	   })
	   
	   $("#btn_next").click(function(){
		   count++;	
		   $("#tab_page").load("ajaxlistkehu.do",{currentPage:count},function(){
			 
		   })
	   })
   })
 
</script>
<body>
       <input type="button" name="first" value="首页" id="btn_first">
    
       <input type="button" name="provious" value="上一页" id="btn_provious">
       
       <input type="button" name="next" value="下一页" id="btn_next">
   
       <input type="button" name="last" value="末页" id="btn_last">
       
       <table id="tab_page" border=1>
          
       </table>
</body>
</html>