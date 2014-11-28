<#macro layout title="Ya.Blogo">
<html>
<head>
    <script src="/public/jquery/js/jquery.min.js" type="text/javascript"></script>
    <link href="/public/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script src="/public/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    <link href="/public/app/css/main.css" type="text/css" rel="stylesheet"/>

    <title>${title}</title>
</head>
<body>
<header>
    <nav class="navbar navbar-menu navbar-fixed-top" role="navigation">
        <div class="container">
            <ul class="nav navbar-nav">
                <li><a href="/post/all">Ya.Blogo</a></li>
            </ul>
            <form class="navbar-form navbar-left" method="GET" action="/post/new">
                <button type="submit" class="btn btn-default">Create Post</button>
            </form>

            <form class="navbar-form navbar-right" role="auth">
                <button type="button" class="btn btn-default navbar-btn disabled">Sign Up</button>
                <button type="button" class="btn btn-default navbar-btn disabled">Sign In</button>
            </form>
        </div>
    </nav>
</header>
<br>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <#include "../partials/login_sidebar.ftl">
            </div>
            <div class="col-md-9">
                <#nested />
            </div>
        </div>
    </div>
</div>
<footer>
</footer>
</body>
</#macro>