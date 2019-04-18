<#import "parts/common.ftl" as c>

<@c.page>
    <div>List All users</div>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <#list users as user>
            <tr>
                <td><span>${user.username}</td>
                <td>
                    <#list user.roles as role>
                        ${role}<#sep>,
                    </#list>
                </td>
                <td><a href="/user/${user.id}">Edit</td>
            </tr>
        </#list>
    </tbody>

</table>
</@c.page>