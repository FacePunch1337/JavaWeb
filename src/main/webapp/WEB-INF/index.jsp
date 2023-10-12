<%@ page contentType="text/html;charset=UTF-8" %>
<%

    String context = request.getContextPath();
%>

<html>
<head>
    <title>JSP</title>
    <img src="<%=context%>/img/javaLogo.png" style="float:left" height="50px">
</head>
<body>
<h1>Java web</h1>
<p>
    Создаем проект с архетипом webapp.
    Перегенерируем индексный файл (index.jsp).<br>
    Настраиваем конфигурацию запуска. Для этого нужен локальный
    сервер: Tomcat, Glassfish, JBoss, WildFly, TomEE.<br>
    Большинство этих серверов устанавливаются простой распаковкой из
    архива.<br>
</p>
<%
    String str = "Hello" ;

    str += " World" ;

    int x = 10 ;
%>
<p>str = <%= str %>, x + 10 = <%= x + 10 %></p>
<ul>
    <% for( int i = 1; i <= 10; ++i ) { %>
    <li>item No <%= i %></li>
    <% } %>
</ul>
<jsp:include page="fragment.jsp">
    <jsp:param name="str" value="<%=str%>"/>
</jsp:include>

</body>
</html>