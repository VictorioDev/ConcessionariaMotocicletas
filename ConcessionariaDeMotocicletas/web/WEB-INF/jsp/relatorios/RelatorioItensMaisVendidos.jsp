<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="bar-chart" title="Relatórios" aria-hidden="true"></span> Relatório de Itens Mais Vendidos
</h3>

<table class="table table-hover table-striped mt-3">
    <thead>
        <th>Marca</th>
        <th>Modelo</th>
        <th>Quantidade</th>
        <th>R$ das vendas</th>
    </thead>
    <tbody>
        <t:set var="total" value="0" />
        <t:forEach items="${itens}" var="item">
            <t:set var="total" value="${ total + item.total }"/>
            <tr>
                <td>${item.nomeMarca}</td>
                <td>${item.nomeModelo}</td>
                <td>${item.contador} vendido(s)</td>
                <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${ item.total }" /></td>
            </tr>
        </t:forEach>
    </tbody>
    <tfoot class="bold">
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${ total }" /></td>
    </tfoot>
</table>

<button class="btn btn-sm btn-primary mb-2" onclick="javascript:window.print();">
    <span class="oi" data-glyph="print" title="Imprimir" aria-hidden="true"></span> Imprimir relatório
</button>

<t:import url="../templates/footer.jsp"/>