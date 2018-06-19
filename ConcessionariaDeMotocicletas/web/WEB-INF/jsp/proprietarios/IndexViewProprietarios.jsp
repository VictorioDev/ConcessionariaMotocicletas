<%@page import="br.ads.concessionaria.util.Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="key" title="Proprietários" aria-hidden="true"></span> Proprietários
</h3>

<a href="<t:url value="/proprietarios/cadastrar"/>" class="btn btn-primary btn-sm">
    <span class="oi" data-glyph="plus" aria-hidden="true"></span> Novo proprietário
</a>

<form method="GET">
    <div class="container-fluid mt-2">
        <t:if test="${hasMsg}">
            <div class="alert alert-danger">${msg}</div>
        </t:if>
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
        <th>Nome</th>
        <th>Tipo</th>
        <th>Razão Social</th>
        <th>Endereço</th>
        <th>Telefone</th>
        <th>Email</th>
        <th>Cartório</th>
        <th>Ações</th>
    </thead>
    <tbody>
        <t:forEach items="${proprietarios}" var="proprietario">
            <tr>
                <td><t:out value="${proprietario.idProprietario}"/></td>
                <td><t:out value="${proprietario.nome}"/></td>
                <td><t:out value="${proprietario.tipo}"/></td>
                <td><t:out value="${proprietario.razaoSocial}"/></td>
                <td><t:out value="${proprietario.endereco}"/></td>
                <td><t:out value="${proprietario.telefone}"/></td>
                <td><t:out value="${proprietario.email}"/></td>
                <td><t:out value="${proprietario.cartorio}"/></td>
                <td>
                    <a href="<t:url value="/proprietarios/visualizar/${proprietario.idProprietario}"/>" class="btn btn-sm btn-primary">
                        <span class="oi" data-glyph="eye" title="Visualizar" aria-hidden="true"></span> Visualizar
                    </a>
                    <a href="<t:url value="/proprietarios/editar/${proprietario.idProprietario}"/>" class="btn btn-sm btn-secondary">
                        <span class="oi" data-glyph="pencil" title="Editar" aria-hidden="true"></span> Editar
                    </a>
                    <a href="<t:url value="/proprietarios/remover/${proprietario.idProprietario}"/>" class="btn btn-sm btn-red">
                        <span class="oi" data-glyph="x" title="Remover" aria-hidden="true"></span> Remover
                    </a>
                </td>
            </tr>
        </t:forEach>
    </tbody>
</table>

<p><b>Total:</b> ${proprietarios.size()} registros.</p>

<t:import url="../templates/footer.jsp"/>