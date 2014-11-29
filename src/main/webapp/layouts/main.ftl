<#macro layout title="Ya.Blogo">
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${title}</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/main.css">
    <script src="js/vendor/modernizr-2.6.2.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/jquery.jqote2/0.9.8/jquery.jqote2.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/underscorejs/1.7.0/underscore-min.js"></script>
    <script type="text/javascript" scr="//cdn.jsdelivr.net/backbonejs/1.1.2/backbone-min.js"></script>
    <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" type="text/css" />
    <#--<script src="js/plugins.js"></script>-->
    <#--<script src="js/main.js"></script>-->

    <script type="text/x-jqote-template" id="channelGroupItem">

        </script>
    <script type="text/x-jqote-template" id="channelItem">

        </script>
    <script type="text/x-jqote-template" id="pgorgrameItem">

        </script>
</head>
<body>
<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<!-- Add your site or application content here -->
<div class="container">
        <#nested >
</div>


</body>
</html>
</#macro>