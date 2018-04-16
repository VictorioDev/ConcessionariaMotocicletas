<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Motocicletas</h3>

<a href="<t:url value="/motocicletas/cadastrar"/>" class="btn btn-primary">Nova Motocicleta</a>

<form method="GET">
    <div class="container-fluid mt-2">
        <div class="row">
            <div class="col-md-5">
                <div class="row">
                    <input type="text" id="search" name="search" class="form-control col-md-10" placeholder="Digite a sua busca...">
                    <button type="submit" class="btn btn-sm btn-secondary col-md-2">Buscar</button>
                </div>
            </div>
        </div>
    </div>
</form>
<!--
    private int ano;
    private String cor;
    private String tipoCombustivel;
    private double valorVenda;
    private String situacaoMotocicleta;
    private Proprietario proprietario;
    private Modelo modelo;

-->
<table class="table table-responsive table-hover mt-2">
    <thead>
        <th>#</th>
        <th>Ano</th>
        <th>Cor</th>
        <th>Tipo Combustível</th>
        <th>Valor Venda</th>
        <th>Situação Motocicleta</th>
        <th>Proprietario</th>
        <th>Modelo</th>
    </thead>
    <tbody>
        <t:forEach items="${mototicletas}" var="motocicleta">
            <tr>
                <td><t:out value="${motocicleta.idMotocicleta}"/></td>
                <td><t:out value="${motocicleta.ano}"/></td>
                <td><t:out value="${motocicleta.cor}"/></td>
                <td><t:out value="${motocicleta.tipoCombustivel}"/></td>
                <td><t:out value="${motocicleta.valorVenda}"/></td>
                <td><t:out value="${motocicleta.situacaoMotocicleta}"/></td>
                <td><t:out value="${motocicleta.proprietario.nome}"/></td>
                <td><t:out value="${motocicleta.modelo.nome}"/></td>
                <td><a href="#" class="btn btn-sm btn-primary mb-2">Visualizar</a>
                    <a href="<t:url value="/motocicletas/alterar/${motocicleta.idMotocicleta}"/>" class="btn btn-sm btn-primary mb-2">Editar</a>
                <a href="<t:url value="/motocicletas/remover/${motocicleta.idMotocicleta}"/>" class="btn btn-sm btn-primary mb-2">Remover</a></td>
            </tr>
        </t:forEach>
    </tbody>
</table>

<p>Listando 1 de 1 registros.</p>

<t:import url="../templates/footer.jsp"/>