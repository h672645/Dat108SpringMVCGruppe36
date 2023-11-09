<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="css/simple.css" rel="stylesheet" type="text/css" />
    <title>Påmeldingsbekreftelse</title>
</head>
<body>
	<p> Innlogget som: <c:out value="${mobil} / ${fornavn} ${etternavn}" /></p>
	<br><br>
    <h2>Påmeldingsbekreftelse</h2>
    <p>Påmeldingen er mottatt for</p>
    <p>
        &nbsp;&nbsp;&nbsp;${deltager.fornavn}<br />
        &nbsp;&nbsp;&nbsp;${deltager.etternavn}<br />
        &nbsp;&nbsp;&nbsp;${deltager.mobil}<br /> 
        &nbsp;&nbsp;&nbsp;${deltager.kjonn}<br />
    </p>
    <a href="deltagerliste">Gå til deltagerlisten</a>
</body>
</html>
