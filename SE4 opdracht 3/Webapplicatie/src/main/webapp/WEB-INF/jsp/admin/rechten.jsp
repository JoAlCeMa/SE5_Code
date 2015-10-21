<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de TomTomApplicatie</title>
    </head>
    
    <body>
    <h1>Rechten toekennen aan de gebruiker</h1>
    <c:url var="url" value="/admin/rechten.html" />
  <form:form action="${url}" commandName="rights">   <%-- Spring form tags --%>
            <fieldset>
                <div>
                    <label>Voornaam:</label><form:input path="type"/>
                    <font color="red"><form:errors path="type" /></font>
                </div>
                 <div><input name="submit" type="submit" value="save"/></div>
            </fieldset>
        </form:form>
    </body>