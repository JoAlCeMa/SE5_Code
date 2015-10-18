<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de TomTomApplicatie</title>
    </head>
    
    <body>
        <h1>Details van Gebruiker</h1>
        <b>Id:</b>
        <c:out value="${persoon.id}" /><br/>
        <b>Voornaam:</b>
        <c:out value="${persoon.voornaam}" /><br/>
        <b>Familienaam:</b>
        <c:out value="${persoon.familienaam}" /><br/>
        <b>E-mailadres:</b>
        <c:out value="${persoon.emailadres}" /><br/>
        <b>Paswoord:</b>
        <c:out value="${persoon.paswoord}" /><br/>
        <br/>
        <c:url var="community" value="/admin/grantCommunity.html" />
        <c:url var="admin" value="/admin/grantAdmin.html" />
        <c:url var="gebruiker" value="/admin/grantGebruiker.html" />
        <c:url var="field" value="/admin/grantField.html" />
        <c:url var="rights" value="/admin/rechten.html">
        </c:url>
        <a href='<c:out value="${rights}"/>'> Rechten </a>
        <br/>
        <a href='<c:out value="${admin}"/>'> Admin rechten </a>
        <br>
        <a href='<c:out value="${gebruiker}"/>'> Gebruikers rechten </a>
        <br>
        <a href='<c:out value="${field}"/>'> Field rechten </a>
        <br>
        <c:url var="home" value="/admin/home.html" />
        <a href='<c:out value="${home}"/>'>Admin Home</a>
    </body>
</html>
