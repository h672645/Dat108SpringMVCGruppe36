<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link href="css/simple.css" rel="stylesheet" type="text/css" />
	<script src="js/deltagerDataValidering.js" defer></script>
	<title>Paamelding</title>
</head>

<body>
	<h2>Paamelding</h2>
	<p style="color: red;"><c:out value="${redirectMessage}"/></p>
	<form:form action="lagreDeltager" method="post" modelAttribute="deltager" onSubmit="return validateFornavn() && validateEtternavn() && validateMobil() && validatePasswordMatch() && validateKjonn();">
		<fieldset>
			<form:label path="fornavn">Fornavn:</form:label>
			<form:input path="fornavn" id="fornavn" oninput="validateFornavn()"/>
			<div id="fornavnError" style="color: red;"></div>

			<form:label path="etternavn">Etternavn:</form:label>
			<form:input path="etternavn" id="etternavn" oninput="validateEtternavn()"/>
			<div id="etternavnError" style="color: red;"></div>

			<form:label path="mobil" type="number">Mobil:</form:label>
			<form:input path="mobil" id="mobil" oninput="validateMobil()"/>
			<div id="mobilError" style="color: red;"></div>
			
			<form:label path="passord">Passord</form:label>
			<input type="password" name="passord" id="passord" value="" oninput="validatePasswordMatch()"/>
			<label>Passord repetert</label>
			<input type="password" name="passordRepetert" id="passordRepetert" value="" oninput="validatePasswordMatch()"/>
			<div id="passwordError" style="color: red;"></div>
			
			<form:label path="kjonn">Kjonn</form:label>
			<input type="radio" name="kjonn" value="mann"/>mann
			<input type="radio" name="kjonn" value="kvinne"/>kvinne
			<div id="kjonnError" style="color: red;"></div>
			<br>
			<button type="submit">Meld meg paa</button>
		</fieldset>
	</form:form>
</body>
</html>
