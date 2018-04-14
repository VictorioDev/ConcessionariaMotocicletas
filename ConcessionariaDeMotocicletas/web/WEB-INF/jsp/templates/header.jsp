<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<t:url value="/resources/bootstrap.min.css" />" />
        <link rel="stylesheet" type="text/css" href="<t:url value="/resources/open-iconic/font/css/open-iconic.css" />" />
        <link rel="stylesheet" type="text/css" href="<t:url value="/resources/style.css" />" />
        <title>Sistema de Concessionária</title>
    </head>
    <body>
        <div class="sidebar">
            <div class="sidebar-inner">
                <div class="title">Sistema de Concessionária de Motocicletas</div>
                <ul class="sidebar-menu">
                    <li class="selected">
                        <a href="<t:url value="/painel/" />">
                            <span class="oi" data-glyph="home" title="Painel" aria-hidden="true"></span>Painel
                        </a>
                    </li>
                    <li>
                        <a href="<t:url value="/acessorios/" />">
                            <span class="oi" data-glyph="badge" title="Acessórios" aria-hidden="true"></span>Acessórios
                        </a>
                    </li>
                    <li>
                        <a href="<t:url value="/categorias/" />">
                            <span class="oi" data-glyph="tags" title="Categorias" aria-hidden="true"></span>Categorias
                        </a>
                    </li>
                    <li>
                        <a href="<t:url value="/clientes/" />">
                            <span class="oi" data-glyph="people" title="Clientes" aria-hidden="true"></span>Clientes
                        </a>
                    </li>
                    <li>
                        <a href="<t:url value="/faturas/" />">
                            <span class="oi" data-glyph="credit-card" title="Faturas" aria-hidden="true"></span>Faturas
                        </a>
                    </li>
                    <li>
                        <a href="<t:url value="/relatorios/" />">
                            <span class="oi" data-glyph="bar-chart" title="Relatórios" aria-hidden="true"></span>Relatórios
                        </a>
                    </li>
                    <li>
                        <a href="<t:url value="/marcas/" />">
                            <span class="oi" data-glyph="folder" title="Marcas" aria-hidden="true"></span>Marcas
                        </a>
                    </li>
                    <li>
                        <a href="<t:url value="/modelos/" />">
                            <span class="oi" data-glyph="file" title="Modelos" aria-hidden="true"></span>Modelos
                        </a>
                    </li>
                    <li>
                        <a href="<t:url value="/motocicletas/" />">
                            <span class="oi" data-glyph="wrench" title="Motocicletas" aria-hidden="true"></span>Motocicletas
                        </a>
                    </li>
                    <li>
                        <a href="<t:url value="/proprietarios/" />">
                            <span class="oi" data-glyph="key" title="Proprietários" aria-hidden="true"></span>Proprietários
                        </a>
                    </li>
                    <li>
                        <a href="<t:url value="/usuarios/" />">
                            <span class="oi" data-glyph="person" title="Usuários" aria-hidden="true"></span>Usuários
                        </a>
                    </li>
                    <li>
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