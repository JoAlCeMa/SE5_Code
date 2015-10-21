<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de TomTomwebapplicatie</title>
    </head>
    
    <body>
        <h1>Details van route</h1>
        <b>Id:</b>
        <c:out value="${route.id}" /><br/>
        <b>Naam:</b>
        <c:out value="${route.naam}" /><br/>
        <b>Breedtegraad:</b>
        <c:out value="${route.breedtegraad}" /><br/>
        <b>Lengtegraad:</b>
        <c:out value="${route.lengtegraad}" /><br/>
        <b>Type:</b>
        <c:out value="${route.type}" /><br/>
        <br/>
        <c:url var="home" value="/brainstorm/index.html" />

        <a href='<c:out value="${home}"/>'>Home</a>
    </body>
</html>