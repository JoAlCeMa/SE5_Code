<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welkom in de TomTomApplicatie</title>
</head>

<body>
	<h1>Route toevoegen</h1>
	<c:url var="url" value="/brainstorm/nieuweRoute.html" />
	<form:form action="${url}" commandName="deroute">
		<%-- Spring form tags --%>
		<fieldset>
			<div>
				<label>Naam:</label>
				<form:input path="naam" />
				<font color="red"><form:errors path="naam" /></font>
			</div>
			<div>
				<label>Breedtegraad:</label>
				<form:input path="breedtegraad" />
				<font color="red"><form:errors path="breedtegraad" /></font>
			</div>
			<div>
				<label>Lengtegraad:</label>
				<form:input path="lengtegraad" />
				<font color="red"><form:errors path="lengtegraad" /></font>
			</div>
			<div>
				<label>Type:</label>
				<form:input path="type" />
				<font color="red"><form:errors path="type" /></font>
			</div>
			<div>
				<label>Afstand:</label>
				<form:input path="afstand" />
				<font color="red"><form:errors path="afstand" /></font>
			</div>
			<div>
				<input name="submit" type="submit" value="save" />
			</div>
		</fieldset>
	</form:form>
</body>
</html>