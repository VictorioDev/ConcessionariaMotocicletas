<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="templates/header.jsp"/>

<h3>Bem-vindo, ${usuarioSession.nome}!</h3>
<p>Aqui você consegue ter uma visão geral de como está o andamento da concessionária.</p>

<div class="row mb-4">
    <div class="col-sm-4">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Motocicletas</h5>
                <p class="card-text">Existem ${qtdMotocicletas} motocicleta(s) cadastradas.</p>
                <a href="<t:url value="/motocicletas"/>" class="btn btn-primary">Visualizar motocicletas</a>
            </div><!-- card-body -->
        </div><!-- card -->
    </div><!-- col-sm-4 -->
    
    <div class="col-sm-4">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Proprietários</h5>
                <p class="card-text">Existem ${qtdProprietarios} proprietário(s) cadastrados.</p>
                <a href="<t:url value="/proprietarios"/>" class="btn btn-primary">Visualizar proprietários</a>
            </div><!-- card-body -->
        </div><!-- card -->
    </div><!-- col-sm-4 -->
    
    <div class="col-sm-4">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Usuários</h5>
                <p class="card-text">Existem ${qtdUsuarios} usuário(s) cadastrados.</p>
                <a href="<t:url value="/usuarios"/>" class="btn btn-primary">Visualizar usuários</a>
            </div><!-- card-body -->
        </div><!-- card -->
    </div><!-- col-sm-4 -->
</div><!-- row -->

<div class="row mt-4">
    <div class="col-sm-4">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Clientes</h5>
                <p class="card-text">Existem ${qtdClientes} cliente(s) cadastrados.</p>
                <a href="<t:url value="/clientes"/>" class="btn btn-primary">Visualizar clientes</a>
            </div><!-- card-body -->
        </div><!-- card -->
    </div><!-- col-sm-4 -->
    
    <div class="col-sm-4">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Vendas</h5>
                <p class="card-text">Existem ${qtdVendas} venda(s) realizadas.</p>
                <a href="<t:url value="/vendas"/>" class="btn btn-primary">Visualizar vendas</a>
            </div><!-- card-body -->
        </div><!-- card -->
    </div><!-- col-sm-4 -->
    
    <div class="col-sm-4">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Faturas</h5>
                <p class="card-text">Existem ${qtdFaturas} fatura(s) geradas.</p>
                <a href="<t:url value="/faturas"/>" class="btn btn-primary">Visualizar faturas</a>
            </div><!-- card-body -->
        </div><!-- card -->
    </div><!-- col-sm-4 -->
</div><!-- row -->

<t:import url="templates/footer.jsp"/>