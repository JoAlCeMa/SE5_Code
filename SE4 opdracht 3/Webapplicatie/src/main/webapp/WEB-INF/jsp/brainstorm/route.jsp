<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de TomTomwebapplicatie</title>
    </head>
    
    <body>
        <h1>Details van route</h1>
        <b>Id:</b><span><c:out value="${route.id}"/></span><br/>
        <b>Naam:</b><span><c:out value="${route.naam}"/></span><br/>
        <b>Breedtegraad:</b><span><c:out value="${route.breedtegraad}"/></span><br/>
        <b>Lengtegraad:</b><span><c:out value="${route.lengtegraad}"/></span><br/>
        <b>Type:</b><span><c:out value="${route.type}"/></span><br/>
        <b>Afstand:</b><span><c:out value="${route.afstand}" /></span><br/>
        <br/>
        <c:url var="home" value="/brainstorm/index.html" />
        <a href='<c:out value="${home}"/>'>Home</a>
        <br/>
        <c:url var="route" value="/brainstorm/veranderRoute.html">
        	<c:param name="id" value="${route.id}" />
        </c:url>
        <a href='<c:out value="${route}"/>'>Verander Route</a>
    </body>
</html>