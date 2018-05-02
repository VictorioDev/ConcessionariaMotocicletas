<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="cart" title="Vendas" aria-hidden="true"></span> Visualizar Venda
</h3>

<table class="table table-hover">
    <tr>
        <td class="bold">Código da Venda:</td>
        <td>Nº ${venda.idVenda}</td>
    </tr>
    <tr>
        <td class="bold">Vendido por:</td>
        <td>
            <a href="<t:url value="/usuarios/visualizar/${venda.usuario.idUsuario}"/>" data-toggle="tooltip" title="Visualizar Usuário">
                ${venda.usuario.nome}
            </a>
        </td>
    </tr>
    <tr>
        <td class="bold">Cliente:</td>
        <td>
            <a href="<t:url value="/clientes/visualizar/${venda.cliente.idCliente}"/>" data-toggle="tooltip" title="Visualizar Cliente">
                ${venda.cliente.nome}
            </a>
        </td>
    </tr>
    <tr>
        <td class="bold">Motocicleta:</td>
        <td>
            <a href="<t:url value="/motocicletas/visualizar/${venda.motocicleta.idMotocicleta}"/>" data-toggle="tooltip" title="Visualizar Motocicleta">
                ${venda.motocicleta.modelo.marca.nome} ${venda.motocicleta.modelo.nome}
            </a>
        </td>
    </tr>    
    <tr>
        <td class="bold">Data da Venda:</td>
        <td>
            <fmt:parseDate value="${venda.dataVenda}" type="both" pattern="yyyy-MM-dd HH:mm:ss" var="parsed"/>
            <fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${parsed}" />
        </td>
    </tr>
    <tr>
        <td class="bold">Quantidade de Parcelas:</td>
        <td>${venda.quantidadeParcelas}x</td>
    </tr>
    <tr>
        <td class="bold">Valor:</td>
        <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${venda.valor}" /></td>
    </tr>
    <tr>
        <td class="bold">Valor das parcelas:</td>
        <td>${venda.quantidadeParcelas}x de <fmt:formatNumber type="currency" maxFractionDigits="2" value="${venda.valor / venda.quantidadeParcelas }" /></td>
    </tr>
    <tr>
        <td class="bold">Dia preferencial:</td>
        <td>${venda.diaPreferencial}</td>
    </tr>
    <tr>
        <td class="bold">Status:</td>
        <td>
            <t:set var="badge" value="${ venda.status.equals('Concluída') ? 'badge-success' : 'badge-danger' }"/>
            <span class="badge ${badge}">
                <t:out value="${venda.status}" />
            </span>
        </td>
    </tr>
</table>

<t:import url="../templates/footer.jsp"/>