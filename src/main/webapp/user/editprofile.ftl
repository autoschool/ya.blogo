<#-- @ftlvariable name="model" type="org.yablogo.practice.view.ViewData" -->
<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: posts">
<div class="row">
    <div class="col-md-12">
        <div class="alert alert-info" role="alert">
            <a href="#" class="alert-link">${model.authUser.login}, edit your profile settings!</a>
        </div>
        <form class="form" role="form" action="/user/editprofile" method="post">
            <div class="page-header">
                <#if model.authUser.email==''>
                <div class="form-group">
                    <input type="email" class="form-control" id="email" name="email"
                           placeholder="Email">
                </div>
                <#else>
                    <div class="form-group">
                        <input type="email" class="form-control" id="email" name="email"
                               placeholder="${model.authUser.email}">
                    </div>
                </#if>
            </div>
            <div class="page-header">
                <#if model.authUser.avatar==''>
                Enter link of your avatar image:(Example - http://example.com/avatar.jpg)
                <div class="form-group">
                    <input type="text" class="form-control" id="avatar" name="avatar"
                           placeholder="Image-link">
                </div>
                <#else>
                    Enter link to your avatar image:(Example - http://cs405728.vk.me/v405728533/8c87/KCsjPeQIM-Q.jpg)
                    <br>
                    <img src="${model.authUser.avatar}" alt="Аватар" width="100" />
                    <div class="form-group">
                        <input type="text" class="form-control" id="avatar" name="avatar"
                               placeholder="${model.authUser.avatar}">
                    </div>
                </#if>
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