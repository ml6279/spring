<%@page language="java" pageEncoding="utf-8" %>
<%@page import="org.springframework.web.context.WebApplicationContext" %>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@page import="springbatis.entity.NewsUser" %>
<%@page import="springbatis.service.UserService" %>
<html>
<body>
<%
    WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
    UserService service = ctx.getBean("UserService", UserService.class);
    NewsUser user = service.getUser("张三", "1111");
    System.out.println(user);
    service.batchAddUser();
%>
<h2>HelloWorld</h2>
</body>
</html>



