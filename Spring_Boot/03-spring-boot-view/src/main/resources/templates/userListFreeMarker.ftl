<html>
<head>
<title>展示用户数据</title>
<meta charset="utf-8"></meta>
</head>
<body>
    <table border="1" align="center" width="50%">
        <tr>
            <th>name</th>
        </tr>
        <#list list as user>
        <tr>
            <td>${user.name}</td>
        </tr>
        </#list>
    </table>
</body>
</html>
