<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="css/simple.css" rel="stylesheet" type="text/css" />
    <title>Deltagerliste</title>
</head>
<body>
    <p>Innlogget som: <c:out value="${mobil} / ${fornavn} ${etternavn}" /></p>
    <h2>Deltagerliste</h2>
    <table>
    	<tr>
        	<th>Kjønn</th>
        	<th align="left">Navn</th>
       		<th align="left">Mobil</th>
    	</tr>
    	<c:forEach var="deltager" items="${deltagerList}">
   			 <tr class="${deltager.mobil == deltagerMobil ? 'highlight' : ''}">
        		<td align="center">${deltager.kjonn == 'mann' ? '&#9794;' : '&#9792;'}</td>
        		<td>${deltager.fornavn} ${deltager.etternavn}</td>
        		<td>${deltager.mobil}</td>
    		</tr>
		</c:forEach>
	</table>
    <br>
    <form action="logout" method="post">
       <button type="submit">Logg ut</button> 
    </form>
</body>
</html>
