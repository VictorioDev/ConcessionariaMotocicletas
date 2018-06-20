<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="wrench" title="Motocicletas" aria-hidden="true"></span> Visualizar Motocicleta
</h3>

<a href="<t:url value="/motocicletas/editar/${motocicleta.idMotocicleta}" />" class="btn btn-primary btn-sm mb-3">
    <span class="oi" data-glyph="pencil" title="Editar" aria-hidden="true"></span> Editar motocicleta
</a>
 
<table class="table table-hover">
    <tr>
        <td class="bold">ID:</td>
        <td>${motocicleta.idMotocicleta}</td>
    </tr>
    <tr>
        <td class="bold">Ano:</td>
        <td>${motocicleta.ano}</td>
    </tr>
     <tr>
        <td class="bold">Chassi:</td>
        <td>${motocicleta.chassi}</td>
    </tr>
    <tr>
        <td class="bold">Cor:</td>
        <td>${motocicleta.cor}</td>
    </tr>
    <tr>
        <td class="bold">Tipo do combustível:</td>
        <td>${motocicleta.tipoCombustivel}</td>
    </tr>
    <tr>
        <td class="bold">Valor de Compra:</td>
        <td>
            <fmt:formatNumber type="currency" maxFractionDigits="2" value="${motocicleta.valorCompra}" />
        </td>
    </tr>
    <tr>
        <td class="bold">Valor de Venda:</td>
        <td>
            <fmt:formatNumber type="currency" maxFractionDigits="2" value="${motocicleta.valorVenda}" />
        </td>
    </tr>
    <tr>
        <td class="bold">Situação Motocicleta:</td>
        <td>${motocicleta.situacaoMotocicleta}</td>
    </tr>
    <t:if test="${ motocicleta.proprietario.nome != null }">
    <tr>
        <td class="bold">Renavam:</td>
        <td>${motocicleta.renavam}</td>
    </tr>
    <tr>
        <td class="bold">Placa:</td>
        <td>${motocicleta.placa}</td>
    </tr>
    <tr>
        <td class="bold">Valor IPVA:</td>
        <td>${motocicleta.valorIPVA}</td>
    </tr>
    <tr>
        <td class="bold">Situação IPVA:</td>
        <td>${motocicleta.situacaoIPVA}</td>
    </tr>
    <tr>
        <td class="bold">Proprietario:</td>
        <td>
            <a href="<t:url value="/proprietarios/visualizar/${motocicleta.proprietario.idProprietario}"/>" data-toggle="tooltip" title="Visualizar Proprietário">
                ${motocicleta.proprietario.nome}
            </a>
        </td>
    </tr>
    </t:if>
    <tr>
        <td class="bold">Motor:</td>
        <td>${motocicleta.motor}</td>
    </tr>

    <tr>
        <td class="bold">Modelo:</td>
        <td>
            <a href="<t:url value="/modelos/visualizar/${motocicleta.modelo.idModelo}/"/>" data-toggle="tooltip" title="Visualizar Modelo">
                ${motocicleta.modelo.nome}    
            </a>
        </td>
    </tr>
</table>

<t:import url="../templates/footer.jsp"/>