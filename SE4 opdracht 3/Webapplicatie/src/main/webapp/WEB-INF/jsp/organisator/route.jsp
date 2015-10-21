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
        <c:url var="home" value="/organisator/home.html" />
        <c:url var="verwijder" value="/organisator/verwijderRoute.html" >
        	<c:param name="id" value="${route.id}" />
        </c:url>
        <a href='<c:out value="${home}"/>'>Home</a>
        <br>
        <a href='<c:out value="${verwijder}" />'> Verwijder</a>
        <br/>
        <c:url var="controlOk" value="/organisator/controlOk.html" >
        	<c:param name="id" value="${route.id}" />
        </c:url>
	    <a href='<c:out value="${controlOk}" />'> Controle OK</a>
    </body>
</html>