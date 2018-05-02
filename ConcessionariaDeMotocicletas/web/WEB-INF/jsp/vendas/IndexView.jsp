<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Vendas</h3>
<a href="<t:url value="/vendas/cadastrar" />" class="btn btn-primary"><span class="oi" data-glyph="plus" title="Acessórios" aria-hidden="true"></span> Nova venda</a>

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

<table class="table table-hover mt-2">
    <thead>
        <th>#</th>
        <th>Status</th>
        <th>Motocicleta</th>
        <th>Cliente</th>
        <th>Valor</th>
        <th>Vendedor</th>
        <th>Ações</th>
    </thead>
    <tbody>
        <t:forEach items="${vendas}" var="venda">
            <tr>
                <td>Nº <t:out value="${venda.idVenda}" /></td>
                <td>
                    <t:set var="badge" value="${ venda.status.equals('Concluída') ? 'badge-success' : 'badge-danger' }"/>
                    <span class="badge ${badge}">
                        <t:out value="${venda.status}" />
                    </span>
                </td>
                <td>
                    <small>
                        <a href="<t:url value="/motocicletas/visualizar/${venda.motocicleta.idMotocicleta}"/>">
                            <t:out value="${venda.motocicleta.modelo.marca.nome} ${venda.motocicleta.modelo.nome}"/>
                        </a>
                    </small>
                </td>
                <td>
                    <small>
                        <a href="<t:url value="/clientes/visualizar/${venda.cliente.idCliente}"/>">
                            <t:out value="${venda.cliente.nome}" />
                        </a>
                    </small>
                </td>
                <td>
                    <fmt:formatNumber type="currency" maxFractionDigits="2" value="${venda.valor}" />
                    <small>(<t:out value="${venda.quantidadeParcelas}" />x de <fmt:formatNumber type="currency" maxFractionDigits="2" value="${venda.valor / venda.quantidadeParcelas }" />)</small>
                </td>
                <td>
                    <small>
                        <a href="<t:url value="/usuarios/visualizar/${venda.usuario.idUsuario}"/>">
                            <t:out value="${venda.usuario.nome}" />
                        </a>
                    </small>
                </td>
                <td>
                    <a href="<t:url value="/vendas/visualizar/${venda.idVenda}" />" class="btn btn-sm btn-primary">
                        <span class="oi" data-glyph="eye" title="Visualizar" aria-hidden="true"></span> Visualizar
                    </a>
                    <t:if test="${ venda.status.equals('Concluída') }">
                        <a href="<t:url value="/vendas/cancelar/${venda.idVenda}"/>" class="btn btn-sm btn-red">
                            <span class="oi" data-glyph="x" title="Cancelar" aria-hidden="true"></span> Cancelar
                        </a>
                    </t:if>
                </td>
            </tr>
        </t:forEach>
    </tbody>
</table>

<p><b>Total:</b> ${vendas.size()} registros.</p>

<t:import url="../templates/footer.jsp"/>