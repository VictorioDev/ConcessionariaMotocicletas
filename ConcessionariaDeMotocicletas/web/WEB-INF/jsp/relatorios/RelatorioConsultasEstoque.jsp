<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="bar-chart" title="Relatórios" aria-hidden="true"></span> Relatório de Consulta de Estoque
</h3>

<p class="mb-0"><b>Total de registros:</b> ${estoques.size()} registros.</p>

<table class="table table-hover table-striped mt-3">
    <thead>
        <th>#</th>
        <th>Marca/Modelo</th>
        <th>Ano</th>
        <th>Cor</th>
        <th>Combustível</th>
        <th>Valor de Venda</th>
    </thead>
    <tbody>
        <t:forEach items="${estoques}" var="estoque">
            <tr>
                <td>${ estoque.idMotocicleta }</td>
                <td>${ estoque.modelo.marca.nome } ${ estoque.modelo.nome }</td>
                <td>${ estoque.ano }</td>
                <td>${ estoque.cor }</td>
                <td>${ estoque.tipoCombustivel }</td>
                <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${ estoque.valorVenda }" /></td>
            </tr>
        </t:forEach>
    </tbody>
</table>

<button class="btn btn-sm btn-primary mb-2" onclick="javascript:window.print();">
    <span class="oi" data-glyph="print" title="Imprimir" aria-hidden="true"></span> Imprimir relatório
</button>

<t:import url="../templates/footer.jsp"/>