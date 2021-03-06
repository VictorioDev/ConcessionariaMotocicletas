<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="credit-card" title="Faturas" aria-hidden="true"></span> Visualizar Fatura
</h3>

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
    <t:if test="${ fatura.status.equals('Paga') }">
        <tr>
            <td class="bold">Data do Pagamento:</td>
            <td>
                <fmt:parseDate value="${ fatura.dataPagamento }" type="both" pattern="yyyy-MM-dd HH:mm:ss" var="parsed"/>
                <fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${parsed}" />
            </td>                
        </tr>
        <tr>
            <td class="bold">Tipo do Pagamento:</td>
            <td><t:out value="${ fatura.tipoPagamento }"/></td>                
        </tr>
        <tr>
            <td class="bold">Valor Pago:</td>
            <td>
                <fmt:formatNumber type="currency" maxFractionDigits="2" value="${fatura.valorPago}" />
            </td>                
        </tr>
        <tr>
            <td class="bold">Baixa realizada por:</td>
            <td>
                <a href="<t:url value="/usuarios/visualizar/${ fatura.usuarioBaixa.idUsuario }" />" data-toggle="tooltip" title="Visualizar Usuário">
                    <t:out value="${ fatura.usuarioBaixa.nome }"/>
                </a>
            </td>                
        </tr>
    </t:if>
    <tr>
        <td class="bold">Venda:</td>
        <td>
            <a href="<t:url value="/vendas/visualizar/${fatura.venda.idVenda}"/>" data-toggle="tooltip" title="Visualizar Venda">
                Nº <t:out value="${fatura.venda.idVenda}"/> (<t:out value="${fatura.venda.motocicleta.modelo.marca.nome} ${fatura.venda.motocicleta.modelo.nome}"/>)
            </a>
        </td>
    </tr>
    <tr>
        <td class="bold">Credor:</td>
        <td>
            <a href="<t:url value="/clientes/visualizar/${fatura.venda.cliente.idCliente}"/>" data-toggle="tooltip" title="Visualizar Cliente">
                <t:out value="${fatura.venda.cliente.nome}"/>
            </a>
        </td>
    </tr>
</table>

<t:import url="../templates/footer.jsp"/>