<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h4>Visualizar Fatura:</h4>

<table class="table table-hover">
    <tr>
        <td class="bold">Nº da Fatura:</td>
        <td>
            <fmt:formatNumber pattern="00000000000" value="${fatura.idFatura}" />
        </td>
    </tr>
    
    <tr>
        <td class="bold">Nº da Parcela:</td>
        <td>${fatura.numeroParcela}</td>
    </tr>
    
    <tr>
        <td class="bold">Data de Emissão:</td>
        <td>
            <fmt:formatDate pattern="dd/MM/yyyy" value="${fatura.dataEmissao}" />
        </td>
    </tr>
    
    <tr>
        <td class="bold">Data de Vencimento:</td>
        <td>
            <fmt:formatDate pattern="dd/MM/yyyy" value="${fatura.dataVencimento}" />
        </td>
    </tr>
    <tr>
        <td class="bold">Valor:</td>
        <td>
            <fmt:formatNumber type="currency" maxFractionDigits="2" value="${fatura.valorParcela}" />
        </td>
    </tr>
    <tr>
        <td class="bold">Status:</td>
        <td>
            <t:set var="badge" value="${ fatura.status.equals('Paga') ? 'badge-success' : 'badge-info' }"/>
            <span class="badge ${badge}">
                <t:out value="${fatura.status}" />
            </span>
        </td>
    </tr>
    <tr>
        <td class="bold">Venda:</td>
        <td>
            <a href="<t:url value="/vendas/visualizar/${fatura.venda.idVenda}"/>">
                Nº <t:out value="${fatura.venda.idVenda}"/> (<t:out value="${fatura.venda.motocicleta.modelo.marca.nome} ${fatura.venda.motocicleta.modelo.nome}"/>)
            </a>
        </td>
    </tr>
    <tr>
        <td class="bold">Credor:</td>
        <td>
            <a href="<t:url value="/clientes/visualizar/${fatura.venda.cliente.idCliente}"/>">
                <t:out value="${fatura.venda.cliente.nome}"/>
            </a>
        </td>
    </tr>
</table>

<t:import url="../templates/footer.jsp"/>