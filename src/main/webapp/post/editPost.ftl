<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: posts">
<div class="row">
    <div class="col-md-12">
        <form class="form" role="form" action="/post/${model.id}" method="post">
            <div class="page-header">
                <div class="form-group">
                    <input type="text" class="form-control" id="changeTitle" name="changeTitle"
                           placeholder="Post Title" value="${model.title}">
                </div>
            </div>
            <div class="form-group">
                <textarea class="form-control" rows="10" name="changeBody">${model.body}</textarea>

            </div>
            <div class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-danger pull-right">Save</button>
                </div>
            </div>
        </form>
    </div>
</div>
</@layout.layout>