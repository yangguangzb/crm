<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
	
  <s:form namespace="/" action="staffAction_edit">
  	<%--添加隐藏域，存放用户id --%>
  	<s:hidden name="staffId" value="%{staffId}"/>	
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><s:textfield name="loginName"/></td>
	    <td>密码：</td>
	    <td><s:password name="loginPwd" showPassword="true"/></td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><s:textfield name="staffName"/></td>
	    <td>性别：</td>
	    <td>
	    	<s:radio list="{'男','女'}" name="gender"></s:radio>
	    </td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
			<s:select list="allDepartment" name="post.department.depId"
				listKey="depId" listValue="depName" onchange="showPost(this)"
				headerKey="" headerValue="----请--选--择----"
			>
			</s:select>
	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<s:select list="post.department.postSet" name="post.postId"
	    		listKey="postId" listValue="postName" id="postSelectId"
	    		headerKey="" headerValue="----请--选--择----"
	    	>
	    	</s:select>
	    </td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<s:date name="onDutyDate" format="yyyy-MM-dd" var="myDate"/>
	    	<s:textfield name="onDutyDate" readonly="true" value="%{#myDate}" onfocus="c.showMoreDay=true;c.show(this);"/>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</s:form>
<script type="text/javascript">
	function showPost(obj){
		//获得所选中的部门
		var depId=obj.value;
		//获得引擎
		var xmlhttp=null;
		if (window.XMLHttpRequest){
			// code for all new browsers
			xmlhttp=new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			// code for IE5 and IE6
			 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		//设置回调函数
		xmlhttp.onreadystatechange=function(){
			//请求完成，正常响应
			if(xmlhttp.status==200&&xmlhttp.readyState==4){
				//获得数据(这是文本数据)
				var textData=xmlhttp.responseText;
				//将数据转化为json对象
				var jsonData=eval("("+textData+")");
				//获得职务select对象
				var postSelectElement=document.getElementById("postSelectId");
				postSelectElement.innerHTML="<option value=''>----请--选--择----</option>";
				//遍历
				for(var i=0;i<jsonData.length;i++){
					//获得一个
					var postObj=jsonData[i];
					//获得职务id
					var postId=postObj.postId;
					//获得职务名称
					var postName=postObj.postName;
					//将数据显示到select标签
					postSelectElement.innerHTML+="<option value='"+postId+"'>"+postName+"</option>";
				}
			}
		};
		//创建连接
		var url="${pageContext.request.contextPath}/postAction_findAllWithDepartment?department.depId="+depId;
		xmlhttp.open("GET",url);
		//发送请求
		xmlhttp.send(null);
	}
</script>
</body>
</html>



