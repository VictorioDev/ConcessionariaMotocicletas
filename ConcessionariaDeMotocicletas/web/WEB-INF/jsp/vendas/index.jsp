<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Vendas</h3>

<a href="#" class="btn btn-primary">Nova venda</a>

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

<table class="table table-responsive table-hover table-striped mt-2">
    <thead>
        <th>#</th>
        <th>Cliente</th>
        <th>Motocicleta</th>
        <th>Data</th>
        <th>Valor</th>
        <th>Ações</th>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>LUCIANO DE ABREU CARVALHO JUNIOR</td>
            <td>HONDA CB150 PRETA</td>
            <td>28/03/2018</td>
            <td>R$29.000,00</td>
            <td>
                <a href="#" class="btn btn-sm btn-secondary">Visualizar</a>
                <a href="#" class="btn btn-sm btn-secondary">Editar</a>
                <a href="#" class="btn btn-sm btn-secondary">Remover</a>
            </td>
        </tr>
        <tr>
            <td>2</td>
            <td>VICTORIO APARECIDO ZANSAVIO</td>
            <td>HORNET 1500CC PRETA</td>
            <td>22/03/2018</td>
            <td>R$75.500,00</td>
            <td>
                <a href="#" class="btn btn-sm btn-secondary">Visualizar</a>
                <a href="#" class="btn btn-sm btn-secondary">Editar</a>
                <a href="#" class="btn btn-sm btn-secondary">Remover</a>
            </td>
        </tr>
    </tbody>
</table>

<p>Listando 1 de 1 registros.</p>

<t:import url="../templates/footer.jsp"/>