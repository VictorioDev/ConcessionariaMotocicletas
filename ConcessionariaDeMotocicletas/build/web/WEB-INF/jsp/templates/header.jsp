<%@page import="br.ads.concessionaria.util.Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="<t:url value="/resources/jquery-3.3.1.min.js"/>" type="text/javascript"></script>
        <script src="<t:url value="/resources/popper.min.js"/>" type="text/javascript"></script>
        <script src="<t:url value="/resources/sweetalert.min.js"/>" type="text/javascript"></script>
        <script src="<t:url value="/resources/bootstrap.min.js"/>" type="text/javascript"></script>
        <script src="<t:url value="/resources/main.js"/>" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="<t:url value="/resources/bootstrap.min.css" />" />
        <link rel="stylesheet" type="text/css" href="<t:url value="/resources/sweetalert.css" />" />
        <link rel="stylesheet" type="text/css" href="<t:url value="/resources/open-iconic/font/css/open-iconic.css" />" />
        <link rel="stylesheet" type="text/css" href="<t:url value="/resources/style.css" />" />
        <title>Sistema de Concessionária</title>
    </head>
    <body>
        <div class="sidebar">
            <div class="sidebar-inner">
                <div class="title">
                    <img src="<t:url value="/resources/logo.png"/>" name="Sistema de Concessionária" alt="Sistema de Concessionária"/>
                </div>                
                <ul class="sidebar-menu">
   
                    <li class="<%= Utils.activeMenu("painel", request.getRequestURL().toString()) %>">
                        <a href="<t:url value="/painel/" />">
                            <span class="oi" data-glyph="home" title="Painel" aria-hidden="true"></span>Painel
                        </a>
                    </li>
                    <li class="<%= Utils.activeMenu("acessorios", request.getRequestURL().toString()) %>">
                        <a href="<t:url value="/acessorios/" />">
                            <span class="oi" data-glyph="badge" title="Acessórios" aria-hidden="true"></span>Acessórios
                        </a>
                    </li>
                    <li class="<%= Utils.activeMenu("categorias", request.getRequestURL().toString()) %>">
                        <a href="<t:url value="/categorias/" />">
                            <span class="oi" data-glyph="tags" title="Categorias" aria-hidden="true"></span>Categorias
                        </a>
                    </li>
                    <li class="<%= Utils.activeMenu("clientes", request.getRequestURL().toString()) %>">
                        <a href="<t:url value="/clientes/" />">
                            <span class="oi" data-glyph="people" title="Clientes" aria-hidden="true"></span>Clientes
                        </a>
                    </li>
                    <li class="<%= Utils.activeMenu("faturas", request.getRequestURL().toString()) %>">
                        <a href="<t:url value="/faturas/" />">
                            <span class="oi" data-glyph="credit-card" title="Faturas" aria-hidden="true"></span>Faturas
                        </a>
                    </li>
                    <li class="<%= Utils.activeMenu("relatorios", request.getRequestURL().toString()) %>">
                        <a href="<t:url value="/relatorios/" />">
                            <span class="oi" data-glyph="bar-chart" title="Relatórios" aria-hidden="true"></span>Relatórios
                        </a>
                    </li>
                    <li class="<%= Utils.activeMenu("marcas", request.getRequestURL().toString()) %>">
                        <a href="<t:url value="/marcas/" />">
                            <span class="oi" data-glyph="folder" title="Marcas" aria-hidden="true"></span>Marcas
                        </a>
                    </li>
                    <li class="<%= Utils.activeMenu("modelos", request.getRequestURL().toString()) %>">
                        <a href="<t:url value="/modelos/" />">
                            <span class="oi" data-glyph="file" title="Modelos" aria-hidden="true"></span>Modelos
                        </a>
                    </li>
                    <li class="<%= Utils.activeMenu("motocicletas", request.getRequestURL().toString()) %>">
                        <a href="<t:url value="/motocicletas/" />">
                            <span class="oi" data-glyph="wrench" title="Motocicletas" aria-hidden="true"></span>Motocicletas
                        </a>
                    </li>
                    
                   
                    
                    <li class="<%= Utils.activeMenu("proprietarios", request.getRequestURL().toString()) %>">
                        <a href="<t:url value="/proprietarios/" />">
                            <span class="oi" data-glyph="key" title="Proprietários" aria-hidden="true"></span>Proprietários
                        </a>
                    </li>
                    <li class="<%= Utils.activeMenu("usuarios", request.getRequestURL().toString()) %>">
                        <a href="<t:url value="/usuarios/" />">
                            <span class="oi" data-glyph="person" title="Usuários" aria-hidden="true"></span>Usuários
                        </a>
                    </li>
                    <li class="<%= Utils.activeMenu("vendas", request.getRequestURL().toString()) %>">
                        <a href="<t:url value="/vendas/" />">
                            <span class="oi" data-glyph="cart" title="Vendas" aria-hidden="true"></span>Vendas
                        </a>
                    </li>
                </ul>
            </div><!-- sidebar-inner -->
        </div><!-- sidebar -->
        
        <div class="page-container">
            <div class="header">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-10 text-right">
                            <p class="mb-0"><b>${usuarioSession.nome}</b></p>
                            <p class="mb-0"><small>${usuarioSession.email}</small></p>
                        </div>
                        <div class="col-md-2 text-right">
                            <a href="<t:url value="/logout/" />" class="btn btn-secondary">
                                Logout <span class="oi" data-glyph="account-login" title="Logout" aria-hidden="true"></span>
                            </a>
                        </div><!-- col-md-6 -->
                    </div><!-- row -->
                </div>
            </div>
            
            <div class="page-body">
           