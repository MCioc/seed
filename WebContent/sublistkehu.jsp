<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tr> 
	<td width="8%" align="center" bgcolor="#EEEEEE">选择</td>
	<td width="12%" height="20" align="center" bgcolor="#EEEEEE">公司名称</td>
    <td width="7%" align="center" bgcolor="#EEEEEE">联系人</td>
    <td width="10%" align="center" bgcolor="#EEEEEE">联系电话</td>
    <td width="14%" align="center" bgcolor="#EEEEEE">联系地址</td>
	<td width="28%" align="center" bgcolor="#EEEEEE">公司背景</td>
	<td width="10%" align="center" bgcolor="#EEEEEE">添加时间</td>
    <td width="11%" align="center" bgcolor="#EEEEEE">操作</td>
</tr>                  
<c:forEach items="${pageinfo.list}" var="c">                 
    <tr>
		<td bgcolor="#FFFFFF"><input type="checkbox" name="delid" value="${c.companyID}"/></td>
		<td height="20" bgcolor="#FFFFFF"><a href="listyuangongmingxi.html">${c.companyName }</a></td>
        <td bgcolor="#FFFFFF"><a href="listyuangongmingxi.html">${c.linkMan }</a></td>
        <td height="20" bgcolor="#FFFFFF">${c.tel }</td>
        <td bgcolor="#FFFFFF">${c.address }</td>
        <td bgcolor="#FFFFFF">${c.descript }</td>
		<td bgcolor="#FFFFFF">${c.createDate }</td>
        <td bgcolor="#FFFFFF"><a href="kehu.htm">编辑</a>&nbsp;|&nbsp;<a href="kehuminxi.html">查看</a></td>
     </tr>
</c:forEach>
    
