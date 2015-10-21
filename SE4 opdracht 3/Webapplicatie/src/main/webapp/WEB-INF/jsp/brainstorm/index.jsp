<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Brainstormapplicatie</title>
    </head>
    
    <body>
        <h1>Welkom in de TomTom kaarten lijst</h1>
           
            <h1>Lijst van routes</h1>
        <ul>
            <c:forEach items="${routes}" var="route">
                <c:url var="routeUrl" value="/brainstorm/route.html">
                    <c:param name="id" value="${route.id}" />
                    <c:param name="rolid" value="${rol.id}" />
                </c:url>
                <li>
                    <a href='<c:out value="${routeUrl}"/>'>
                        <c:out value="${route.naam}" />
                    </a>
                </li>
            </c:forEach>
        </ul>
        <c:url var="nieuweRouteUrl" value="/brainstorm/nieuweRoute.html" />
        <a href='<c:out value="${nieuweRouteUrl}"/>'>Route Toevoegen</a>
         <c:url var="logoutUrl" value="/logout" />
	    <form class="form-inline" action="${logoutUrl}" method="post">
	      <input type="submit" value="Log out" />
	      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    </form> 
    </body>
</html>
