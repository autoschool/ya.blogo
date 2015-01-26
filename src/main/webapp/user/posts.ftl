<#-- @ftlvariable name="model" type="org.yablogo.practice.view.ViewData" -->
<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: post">
<div class="row">
    <div class="col-md-12">
        <div class="page-header">
            <br>
            <h2>${model.profile.login} posts</h2>
        </div>
        <#list model.posts as post>
            <#if model.profile.id==post.userId>
            <div class="panel panel-default">
                <div class="panel-body">
                    <a href="/post/${post.id}">${post.title}</a> at ${post.updatedAt}
                    <form class="navbar-form navbar-right" method="POST" action="/post/delete/${post.id}">
                        <button type="submit" class="btn btn-danger pull-right">Delete</button>
                    </form>
                    <form class="navbar-form navbar-right" method="GET" action="/post/edit/${post.id}">
                        <button type="submit" class="btn btn-default ">Edit</button>
                    </form>
                    <br/>
                </div>
            </div>
            </#if>
        </#list>
    </div>
</div>
</@layout.layout>