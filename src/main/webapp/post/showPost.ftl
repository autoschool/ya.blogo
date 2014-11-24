<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: post">

<div class="row">
    <div class="col-md-12">
        <div class="page-header">
            <h2>${model.title}</h2>
        </div>
        <div class="post-body">
        ${model.body}
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
            <#list model.comments as comment>

                <li class="list-group-item">${comment.message}</li>

            </#list>
        </ul>


    </div>

</div>


<form class="form" role="form" action="/post/${model.id}/comment" method="post">
    <div class="form-group">
        <textarea class="form-control" rows="3" name="message"></textarea>
    </div>
    <div class="row">
        <div class="col-md-12">
            <button type="submit" class="btn btn-default pull-right">Add Comment</button>
        </div>
    </div>
</form>





</@layout.layout>
