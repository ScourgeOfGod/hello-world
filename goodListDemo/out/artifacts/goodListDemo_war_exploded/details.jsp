<%@ page import="dao.DAO" %>
<%@ page import="util.Items" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 69099
  Date: 2017/3/16
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    DAO dao = new DAO();
    Items item = null;
    item = dao.get(Integer.parseInt(request.getParameter("id"))) ;
    List<Items> itemsList ;
    String list = "";
    Cookie[] cookies = request.getCookies();
    String[] arr ;
%>
<%=item.toString()%>
<img src="images/<%=item.getPicture()%>"width="80" height="60" border="1"/><br>
<%

    for (Cookie c:cookies
         ) {
        if(c.getName().equals("ListViewCookie")){
            list = c.getValue();
        }
    }
    list += request.getParameter("id") + ",";

        arr = list.split(",");
        if(arr != null && arr.length > 0){
            if(arr.length>1000){
                list = "";
            }
        }
        Cookie cookie = new Cookie("ListViewCookie",list);
        response.addCookie(cookie);
        itemsList = dao.getList(list);
        for (int i = 0; i < itemsList.size(); i++){
            item = itemsList.get(i);
            %>
<%=item.getName()%>
<%=item.getPrice()%>
<img src="images/<%=item.getPicture()%>"width="40" height="30" border="1"/><br>
<%
}
%>
</body>
</html>
