<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="bar-chart" title="Relatórios" aria-hidden="true"></span> Relatório de Pagamentos
</h3>

<p class="mb-0"><b>Período selecionado:</b> <t:out value="${ dataInicio }"/> até <t:out value="${ dataFinal }"/>.</p>
<p class="mb-0"><b>Total de registros:</b> ${pagamentos.size()} registros.</p>

<table class="table table-hover table-striped mt-3">
    <thead>
        <th>#</th>
        <th>Valor</th>
        <th>Valor Pago</th>
        <th>Emissão</th>
        <th>Vencimento</th>
        <th>Pagamento</th>
        <th>Tipo</th>
        <th>Venda</th>
        <th>Credor</th>
    </thead>
    <tbody>
        <t:set var="total" value="0" />
        <t:set var="totalPago" value="0" />
        <t:forEach items="${pagamentos}" var="pagamento">
            <t:set var="total" value="${ total + pagamento.valorParcela }" />
            <t:set var="totalPago" value="${ totalPago + pagamento.valorPago }" />
            <tr>
                <td><fmt:formatNumber pattern="00000000000" value="${pagamento.idFatura}" /></td>
                <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${pagamento.valorParcela}" /></td>
                <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${pagamento.valorPago}" /></td>
                <td>
                    <fmt:formatDate pattern="dd/MM/yyyy" value="${pagamento.dataEmissao}" />
                </td>
                <td>
                    <fmt:formatDate pattern="dd/MM/yyyy" value="${pagamento.dataVencimento}" />
                </td>
                <td>
                    <fmt:parseDate value="${pagamento.dataPagamento}" type="both" pattern="yyyy-MM-dd HH:mm:ss" var="parsed"/>
                    <fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${parsed}" />
                </td>
                <td>
                    <t:out value="${pagamento.tipoPagamento}"/>
                </td>
                <td>
                    Nº <t:out value="${pagamento.venda.idVenda}"/> (<t:out value="${pagamento.venda.motocicleta.modelo.marca.nome} ${pagamento.venda.motocicleta.modelo.nome}"/>)
                </td>
                <td>
                    <t:out value="${pagamento.venda.cliente.nome}"/> (#${pagamento.venda.cliente.idCliente})
                </td>
            </tr>
        </t:forEach>
    </tbody>
    <tfoot class="bold">
        <td>-</td>
        <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${total}" /></td>
        <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${totalPago}" /></td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
    </tfoot>
</table>

<button class="btn btn-sm btn-primary mb-2" onclick="javascript:window.print();">
    <span class="oi" data-glyph="print" title="Imprimir" aria-hidden="true"></span> Imprimir relatório
</button>

<t:import url="../templates/footer.jsp"/>