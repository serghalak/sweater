<#import "parts/common.ftl" as c>

<@c.page>
<#--<div th:if="${param.error}">-->
    <#--Invalid username and password.-->
<#--</div>-->
<#--<div th:if="${param.logout}">-->
    <#--You have been logged out.-->
<#--</div>-->
    Login page
<form  method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div><input type="submit" value="Sign In"/></div>
</form>
    <a href="/registration">Add new user</a>
</@c.page>