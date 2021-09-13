<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html >
<head>
    <title>Add new author</title>
</head>

<body>

<form:form modelAttribute="product" method="post">
    ID: <form:input path ="id"/>
    <br/>
    NAME: <form:input path="name"/>
    <br/>
    PRICE: <form:input path ="price"/>
    <br/>
    <input type="submit" value="save"/>
</form:form>

</body>
</html>
