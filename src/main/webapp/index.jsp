<%--
  Created by IntelliJ IDEA.
  User: Starboy
  Date: 2022/11/12
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/TuitionFeePay/user/queryUser" name="denglu" method="post">
    账号：<input type="text" name="user_num"/><br/>
    密码：<input type="text" name="password"/>
    <button name="tijiao" type="submit">提交</button>
  </form>
  </body>

</html>
