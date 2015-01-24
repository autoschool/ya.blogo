<#-- @ftlvariable name="model" type="org.yablogo.practice.view.ViewData" -->
<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: post">
<div class="row">
    <div class="col-md-12">
        <div class="jumbotron">
            <#if model.authUser??>
                <h1>${model.authUser.login}, welcome to Ya.Blogo!</h1>
                <p>Edit your profile, comment other posts.</p>
                <p>
                    <a class="btn btn-primary btn-lg" href="/user/editprofile" role="button">Edit Profile</a>
                    <a class="btn btn-primary btn-lg" href="/user/all" role="button">All blogers</a>
                </p>
            <#else>
                <h1>Welcome to Ya.Blogo!</h1>
                <p>Create your own blog, follow other blogs.</p>
                <p>
                   <a class="btn btn-primary btn-lg" href="/auth/register" role="button">Register</a>
                   <a class="btn btn-primary btn-lg" href="/user/all" role="button">All blogers</a>
                </p>
            </#if>
        </div>
        <#list model.posts as post>
        <div class="panel panel-default">
            <div class="panel-body">
                <a href="/post/${post.id}">${post.title}</a> at ${post.updatedAt}
                <#if model.authUser??>
                <#if post.id == model.authUser.id>
                <form class="navbar-form navbar-right" method="POST" action="/post/delete/${post.id}">
                    <button type="submit" class="btn btn-danger pull-right">Delete</button>
                </form>
                <form class="navbar-form navbar-right" method="GET" action="/post/edit/${post.id}">
                    <button type="submit" class="btn btn-default ">Edit</button>
                </form>
                </#if>
                </#if>
                <br/>
            </div>
        </div>
        </#list>
    </div>
</div>
</@layout.layout>
