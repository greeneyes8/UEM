<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>

<html>
<head>
<title>Benvenuto in Uniexam</title>
<link href="${pageContext.request.contextPath}/res/css/login.css" media="all" rel="stylesheet" type="text/css">
</head>

<body>

<%-- <tiles:insertAttribute name="pro" /> --%>

<form id="login" action="${pageContext.request.contextPath}/login" method="post">
    <h1>Uniexam</h1>
    <fieldset id="inputs">
        <input id="email" name="email" type="text" placeholder="Email" autofocus required>   
        <input id="password" name="password" type="password" placeholder="Password" required>
    </fieldset>
    <fieldset id="actions">
        <input type="submit" id="submit" value="Log in">
<!--         <a href="">Forgot your password?</a> -->
    </fieldset>
</form>

</body>
</html>
