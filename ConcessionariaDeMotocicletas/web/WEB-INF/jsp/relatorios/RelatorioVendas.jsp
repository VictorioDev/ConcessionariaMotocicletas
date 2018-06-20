<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="bar-chart" title="Relatórios" aria-hidden="true"></span> Relatório de Vendas
</h3>

<p class="mb-0"><b>Período selecionado:</b> <t:out value="${ dataInicio }"/> até <t:out value="${ dataFinal }"/>.</p>
<p class="mb-0"><b>Total de registros:</b> ${vendas.size()} registros.</p>

<table class="table table-hover table-striped mt-3">
    <thead>
        <th>#</th>
        <th>Data da Venda</th>
        <th>Motocicleta</th>
        <th>Cliente</th>
        <th>Valor</th>
        <th>Parcelas</th>
        <th>Dia Preferencial</th>
        <th>Vendedor</th>
        <th>Status</th>
    </thead>
    <tbody>
        <t:forEach items="${vendas}" var="venda">
            <tr>
                <td>${venda.idVenda}</td>
                <td>
                    <fmt:parseDate value="${venda.dataVenda}" type="both" pattern="yyyy-MM-dd HH:mm:ss" var="parsed"/>
                    <fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${parsed}" />
                </td>
                <td>${venda.motocicleta.modelo.marca.nome} ${venda.motocicleta.modelo.nome}</td>
                <td>${venda.cliente.nome}</td>
                <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${venda.valor}" /></td>
                <td>
                    ${venda.quantidadeParcelas}x de <fmt:formatNumber type="currency" maxFractionDigits="2" value="${venda.valor / venda.quantidadeParcelas }" />
                </td>
                <td>Dia ${venda.diaPreferencial}</td>
                <td>${venda.usuario.nome}</td>
                <td>${venda.status}</td>
            </tr>
        </t:forEach>
    </tbody>
</table>

<button class="btn btn-sm btn-primary mb-2" onclick="javascript:window.print();">
    <span class="oi" data-glyph="print" title="Imprimir" aria-hidden="true"></span> Imprimir relatório
</button>

<t:import url="../templates/footer.jsp"/>