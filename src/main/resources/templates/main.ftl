<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>

<div>Enter new message</div>
    <form method="post">
        <input type="text" name="text" placeholder="enter your message" />
        <input type="text" name="tag" placeholder="tag" />
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Send</button>
    </form>
    <form method="get">
        <input type="text" name="filter" value="${filter}" placeholder="filter for search" />

        <button type="submit">Apply filter</button>
    </form>


<div>List of messages</div>
    <#list messages as message>
        <b>${message.id}</b>
        <span>${message.text}</span>
        <i>${message.tag}</i>
         <strong>${message.userName}</strong>
        <br />
    <#else>
        No messages
    </#list>
</@c.page>