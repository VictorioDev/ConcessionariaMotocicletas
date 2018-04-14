<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Clientes</h3>

<a href="<t:url value="/clientes/cadastrar"/>" class="btn btn-primary">Novo Cliente</a>

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

<table class="table table-hover table-striped mt-2">
    <thead>
        <th>#</th>
        <th>Nome</th>
        <th>CPF</th>
        <th>Endereço</th>
        <th>Telefone</th>
        <th>Data de Nascimento</th>   
    </thead>
<tbody>
    <t:forEach items="${clientes}" var="cliente">
        <tr>
            <td><t:out value="${cliente.idCliente}"/></td>
            <td><t:out value="${cliente.nome}"/></td>
            <td><t:out value="${cliente.CPF}"/></td>
            <td><t:out value="${cliente.endereco}"/></td>
            <td><t:out value="${cliente.telefone}"/></td>
            <td><t:out value="${cliente.dataNascimento}"/></td>
            <td>
                <a href="<t:url value="/clientes/visualizar/${cliente.idCliente}"/>" class="btn btn-sm btn-primary mb-2">Visualizar</a>
                <a href="<t:url value="/clientes/editar/${cliente.idCliente}"/>" class="btn btn-sm btn-primary mb-2">Editar</a>
                <a href="<t:url value="/clientes/remover/${cliente.idCliente}"/>" class="btn btn-sm btn-primary mb-2">Remover</a>
            </td>
        </tr>
    </t:forEach>
</tbody>
</table>

<p><b>Total:</b> ${clientes.size()} registros.</p>

<t:import url="../templates/footer.jsp"/>