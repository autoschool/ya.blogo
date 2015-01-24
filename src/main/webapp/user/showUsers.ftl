<#-- @ftlvariable name="model" type="org.yablogo.practice.view.ViewData" -->
<#import "/layouts/main.ftl" as layout />
<@layout.layout title="Blog: post">
<div class="row">
    <div class="col-md-12">
        <div class="page-header">
            <h2>All Blogers</h2>
        </div>
        <#list model.users as user>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <div class="caption">
                            <#if user.avatar==''>
                                <img src="http://cs405728.vk.me/v405728533/8c87/KCsjPeQIM-Q.jpg" alt="Аватар" height="300" />
                            <#else>
                                <img src="${user.avatar}" alt="Аватар" height="300"  />
                            </#if>
                            <h3>${user.login}</h3>
                            <p>Blog created at: ${user.createdAt}</p>
                            <p>
                                <a href="/user/${user.id}/allposts" class="btn btn-primary" role="button">Read ${user.login} blog</a>
                                <#if model.authUser ??>
                                <#if model.authUser.id==user.id>
                                <a href="/user/editprofile" class="btn btn-default" role="button">Edit profile</a>
                                </#if>
                                </#if>
                            </p>
                        </div>
                    </div>
                </div>
        </#list>
    </div>
</div>
</@layout.layout>