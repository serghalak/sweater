<#macro page>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8"/>
    <title>Sweater </title>


</head>
<body>
    <div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Sign Out" />
        </form>
    </div>
    <#nested>
</body>
</html>
</#macro>