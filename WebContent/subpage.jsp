<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页</title>
</head>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
   $(function(){
	   //alert("dd");
	   $("#btn_submit_subpage").click(function(){
		   //alert("ss");
		   var p=/^[1-9][0-9]*$/;//正则表达式
		   var value=$("#txt_subpage").val();
		   //p.test判断表达式是否合法
		   if(p.test(value)){
			   if(value>0&&value<="${pageinfo.countPage}"){
				   window.open("${pageinfo.action}"+value,"_self"); 
			   }else{
				   alert("页号不在范围内");
				   $("#txt_subpage").val("");
			   }
		   }else{
			   alert("页号不合法");
			   $("#txt_subpage").val("");
		   }
	   })
   })
</script>
<body>

 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
  <tr>
    <td width="50%">共 <span class="right-text09">${pageinfo.countPage}</span> 页 | 第 <span class="right-text09">${pageinfo.currentPage}</span> 页</td>
    <td width="49%" align="right">[<a href="${pageinfo.action}1" class="right-font08">首页</a> | 
    <c:if test="${pageinfo.currentPage>1}">
       <a href="${pageinfo.action}${pageinfo.currentPage-1 }" class="right-font08">上一页</a> | 
    </c:if>
    <c:if test="${pageinfo.currentPage<pageinfo.countPage}">
        <a href="${pageinfo.action}${pageinfo.currentPage+1 }" class="right-font08">下一页</a> |
    </c:if>
    <a href="${pageinfo.action}${pageinfo.countPage}" class="right-font08">末页</a>] 
       转至：</td>
    <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">        
                    <tr>
                      <td width="1%"><input name="textfield3" type="text" class="right-textfield03" size="1" id="txt_subpage"/></td>
                      <td width="87%"><input name="Submit23222" type="button" class="right-button06" value="" id="btn_submit_subpage"/></td>
                    </tr>
                   </table> 
  </tr>
 </table>
 
</body>
</html>