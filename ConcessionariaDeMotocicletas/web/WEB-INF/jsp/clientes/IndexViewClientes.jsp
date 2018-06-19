<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="people" title="Clientes" aria-hidden="true"></span> Clientes
</h3>

<a href="<t:url value="/clientes/cadastrar"/>" class="btn btn-primary btn-sm">
    <span class="oi" data-glyph="plus" title="Acessórios" aria-hidden="true"></span> Novo cliente
</a>

<form method="GET">
    <div class="container-fluid mt-2">
        <div class="row">
            <div class="col-md-5">
                <div class="row">
                    <input type="text" id="search" name="search" class="form-control col-md-10" placeholder="Digite a sua busca...">
                    <button type="submit" class="btn btn-sm btn-secondary col-md-2">
                        <span class="oi" data-glyph="magnifying-glass"></span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</form>

<table class="table table-hover table-striped mt-2">
    <thead>
        <th>#</th>
        <th>Nome/Razão Social</th>
        <th>CPF/CNPJ</th>
        <th>Endereço</th>
        <th>Telefone</th>
        <th>Data de Nascimento</th>
        <th>Ações</th>
    </thead>
<tbody>
    <t:forEach items="${clientes}" var="cliente">
        <tr>
            <td><t:out value="${cliente.idCliente}"/></td>
            <td><t:out value="${cliente.nome} ${cliente.razaoSocial}"/></td>
            <td><t:out value="${cliente.CPF} ${cliente.CNPJ}"/></td>
            <td><t:out value="${cliente.endereco}"/></td>
            <td><t:out value="${cliente.telefone}"/></td>
            <td>
                <fmt:formatDate pattern="dd/MM/yyyy" value="${cliente.dataNascimento}" />
            </td>
            <td>
                <a href="<t:url value="/clientes/visualizar/${cliente.idCliente}"/>" class="btn btn-sm btn-primary">
                    <span class="oi" data-glyph="eye" title="Visualizar" aria-hidden="true"></span> Visualizar
                </a>
                <a href="<t:url value="/clientes/editar/${cliente.idCliente}"/>" class="btn btn-sm btn-secondary">
                    <span class="oi" data-glyph="pencil" title="Editar" aria-hidden="true"></span> Editar
                </a>
                <t:if test="${cliente.status.equals('Ativo')}">
                    <a href="<t:url value="/clientes/remover/${cliente.idCliente}"/>" class="btn btn-sm btn-red">
                        <span class="oi" data-glyph="x" title="Desativar" aria-hidden="true"></span> Desativar
                    </a>
                </t:if>
                <t:if test="${cliente.status.equals('Desativo')}">
                    <a href="<t:url value="/clientes/remover/${cliente.idCliente}"/>" class="btn btn-sm btn-green">
                        <span class="oi" data-glyph="x" title="Ativar" aria-hidden="true"></span> Ativar
                    </a>
                </t:if>
            </td>
        </tr>
    </t:forEach>
</tbody>
</table>

<style type="text/css">

    .btn-green {
        background-color: #30af40;
        color: #fff;
    }
</style>

<p><b>Total:</b> ${clientes.size()} registros.</p>

<t:import url="../templates/footer.jsp"/>