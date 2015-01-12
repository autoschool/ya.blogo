<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: post">
<div class="row">
    <div class="col-md-12">
        <div class="page-header">
            <br>
            <h2>All Users</h2>
        </div>
        <#list model as user>
            <div class="panel panel-default">
                <div class="panel-body">
                    ${user.login}
                    ${user.email}
                    <br/>
                </div>
            </div>
        </#list>
    </div>
</div>
</@layout.layout>
