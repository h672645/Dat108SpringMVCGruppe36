<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="css/simple.css" rel="stylesheet" type="text/css" />
    <title>Logg inn</title>
</head>
<body>
    <h2>Logg inn</h2>
    <p style="color:red;"><c:out value="${redirectMessage}"/></p>
    <form method="post">
        <fieldset>
            <label for="mobil">Mobil:</label> 
            <input type="text" name="mobil" />
            <label for="passord">Passord:</label> 
            <input type="password" name="passord" />
            <br><br>
            <button type="submit">Logg inn</button>
        </fieldset>
    </form>
</body>
</html>
