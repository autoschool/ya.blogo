<#-- @ftlvariable name="model" type="org.yablogo.practice.view.ViewData" -->
<#macro layout title="Ya.Blogo">
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <#include "../partials/meta.ftl">
    <title>${title}</title>
    <#include "../partials/styles.ftl">
    <#include "../partials/scripts.ftl">
</head>
<body>
<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/post/all">Ya.blogo</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/post/all">All posts<span class="sr-only">(current)</span></a></li>
                <#if model.authUser?? >
                <li><a href="/post/new">Create post</a></li>
                </#if>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">About<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">About blog</a></li>
                        <li><a href="#">How it works?</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Authors</a></li>
                        <li><a href="#">Technologies</a></li>
                        <li class="divider"></li>
                    </ul>
                </li>
                <li><a href="/user/all">All Blogers</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <#if model.authUser?? >
                    <li><a href="/user/${model.authUser.id}">${model.authUser.login}</a></li>
                    <li><a href="/auth/signout">Sign out</a></li>
                <#else>
                    <li><a href="/auth/register">Registration</a></li>
                    <li><a href="/auth/signin">Sign in</a></li>
                </#if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<!-- Add your site or application content here -->
<div class="container">
    <#nested >
</div>

</body>
</html>
</#macro>