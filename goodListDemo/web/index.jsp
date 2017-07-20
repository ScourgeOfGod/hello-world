<%--
  Created by IntelliJ IDEA.
  User: 69099
  Date: 2017/3/16
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.Items" %>
<%@ page import="dao.DAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>show items</title>
</head>
<body>
<h1>商品展示</h1>
<hr>

<%
    DAO dao = new DAO();
    Items item =new Items();
    List<Items> list = new ArrayList<Items>();
    list = dao.query();
%>

<%
    for (int i = 0; i < list.size(); i++) {
        item =  list.get(i);
%>
品名 ：<%=item.getName()%><br>
售价 ：<%=item.getPrice()%><br>
图片 ：<a href="details.jsp?id=<%=item.getId()%>"><img src="images/<%=item.getPicture()%>" width="120" height="90" border="1"/></a><br>
<br>
<%
    }
%> 
</body>
</html>
