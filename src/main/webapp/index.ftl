<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: posts">
    <h2>Recent posts:</h2>
    <#--<#list model.getPosts() as post>-->
        <#--<div class="panel panel-default">-->
            <#--<div class="panel-body">-->
                <#--<p>${post.getBody()}</p>-->
                <#--<a href="/post/${post.id}">${post.title}</a> at ${post.updatedAt}-->
                <#--<form class="navbar-form navbar-right" method="POST" action="/post/delete/${post.id}">-->
                    <#--<button type="submit" class="btn btn-danger pull-right">Delete</button>-->
                <#--</form>-->
                <#--<form class="navbar-form navbar-right" method="GET" action="/post/edit/${post.id}">-->
                    <#--<button type="submit" class="btn btn-default ">Edit</button>-->
                <#--</form>-->
                <#--<br/>-->
            <#--</div>-->
        <#--</div>-->
    <#--</#list>-->
</@layout.layout>