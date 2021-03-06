<#-- @ftlvariable name="model" type="org.yablogo.practice.view.ViewData" -->
<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: post">

<div class="row">
    <div class="col-md-12">
        <div class="page-header">
            <h2>${model.post.title}</h2>
        </div>
        <div class="post-body">
        ${model.post.body}
        </div>
    </div>
</div>

<br>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Comments</h3>
    </div>
    <div class="panel-body">
        <ul class="list-group">
            <#list model.post.comments as comment>

                <li class="list-group-item">${comment.message}</li>

            </#list>
        </ul>


    </div>

</div>

<#if model.authUser?? >
<form class="form" role="form" action="/post/${model.post.id}/comment" method="post">
    <div class="form-group">
        <textarea class="form-control" rows="3" name="message"></textarea>
    </div>
    <div class="row">
        <div class="col-md-12">
            <button type="submit" class="btn btn-default pull-right">Add Comment</button>
        </div>
    </div>
</form>
<#else >
    <div>
        Only registered users are allowed to leave their comments.<br>
        <a href="/auth/register">Register now</a>
    </div>
</#if>





</@layout.layout>
