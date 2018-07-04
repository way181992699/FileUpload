<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/4
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>文件上传Demo</title>
  </head>
  <body>
  
  <form action="/Upload" enctype="multipart/form-data" method="post" >
    用户名：<input type="text" name="name" ><br/>
    文件名：<input type="file" name="fileName" ></br>
    <input type="submit" value="文件上传"></br>
  </form>
  </body>
</html>
