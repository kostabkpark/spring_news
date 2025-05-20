<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
    <h2>Hello World</h2>
    <hr>
    현재 날짜와 시간은 <%=java.time.LocalDateTime.now()%> 입니다.
    <p>메시지 : ${msg}</p>
</body>
</html>
