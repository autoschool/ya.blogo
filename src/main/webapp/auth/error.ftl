<#-- @ftlvariable name="model" type="org.yablogo.practice.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<@layout.layout title="Login error">

<div class="row">
    <div class="col-md-offset-4 col-md-4">
        <div class="alert alert-danger" role="alert">
            Wrong user name or password. Please, <a class="alert-link" href="/auth/signin" >try again</a>.
        </div>
    </div>
</div>

</@layout.layout>