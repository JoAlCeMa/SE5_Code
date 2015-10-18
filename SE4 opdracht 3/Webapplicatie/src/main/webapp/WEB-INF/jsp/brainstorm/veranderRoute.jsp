<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welkom in de TomTomApplicatie</title>
</head>

<body>
	<h1>Route aanpassen</h1>
	<c:url var="url" value="/brainstorm/veranderRoute.html" />
	<form:form action="${url}" commandName="route">
		<%-- Spring form tags --%>
		<fieldset>
			<div>
				<label>Naam:</label>
				<form:input path="naam" value="${route.naam}"/>
			</div>
			<div>
				<label>Breedtegraad:</label>
				<form:input path="breedtegraad" value="${route.breedtegraad}" />
			</div>
			<div>
				<label>Lengtegraad:</label>
				<form:input path="lengtegraad" value="${route.lengtegraad}" />
			</div>
			<div>
				<label>Type:</label>
				<form:input path="type" value="${route.type}" />
			</div>
			<div>
				<input name="submit" type="submit" value="change" />
			</div>
		</fieldset>
	</form:form>
</body>
</html>