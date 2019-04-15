<#import "parts/common.ftl" as c>

<@c.page>
<div >Add new user</div>


<form action="/registration" method="post">
        <div><label>User Name: <input type="text" name="username"     placeholder="User name"/></label></div>
        <div><label>Password:<input type="password" name="password" placeholder="Password"/></label></div>
        <input type="hidden" name="_csrf" value="${_scrf.token}"/>
        <div><input type="submit" value="Sign In" /></div>
</form>
</@c.page>