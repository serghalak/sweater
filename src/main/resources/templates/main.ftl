<#import "parts/common.ftl" as c>

<@c.page>
<div>Enter new message</div>
    <form method="post">
        <input type="text" name="text" placeholder="enter your message" />
        <input type="text" name="tag" placeholder="tag" />
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Send</button>
    </form>
    <form method="get">
        <input type="text" name="filter" placeholder="filter for search" />
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Apply filter</button>
    </form>


<div>List of messages</div>
    <#list messages as message>
    <b>${message.id}</b>
    <span>${message.text}</span>
    <i>${message.tag}</i>
    <br />
    </#list>


</@c.page>