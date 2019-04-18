<#import "parts/common.ftl" as c>

<@c.page>

<form action="/user" method="post">
    <div><label> User Name : <input type="text" name="username" value="${user.username}"/> </label></div>
    <input type="hidden" name="id" value="${user.id}"/>
    <p>Choose roles:</p>
        <#list roles as role>
            <div>
               <label>
                   <input type="checkbox"  name="${role}"
                        ${user.roles?seq_contains(role)?string("checked","")} />${role}
               </label>

            </div>
        <#else >
            Not exist user!!!
        </#list>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div><input type="submit" value="edit user"/></div>
</form>

</@c.page>