<#-- @ftlvariable name="model" type="org.yablogo.practice.view.ViewData" -->
<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: posts">
<div class="row">
    <div class="col-md-12">
        <form class="form" role="form" action="/auth/signin" method="post">
            <div class="page-header">
                <div class="form-group">
                    <input type="text" class="form-control" id="login" name="login"
                           placeholder="Login">
                </div>
            </div>
            <div class="page-header">
                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password"
                           placeholder="Password">
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-danger pull-right">Login</button>
                </div>
            </div>
        </form>
    </div>
</div>
</@layout.layout>