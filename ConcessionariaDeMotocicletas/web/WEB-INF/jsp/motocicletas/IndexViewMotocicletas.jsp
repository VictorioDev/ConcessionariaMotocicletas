<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="wrench" title="Motocicletas" aria-hidden="true"></span> Motocicletas
</h3>

<a href="<t:url value="/motocicletas/cadastrar"/>" class="btn btn-primary btn-sm">
    <span class="oi" data-glyph="plus" aria-hidden="true"></span> Nova motocicleta
</a>

<form method="GET">
    <div class="container-fluid mt-2">
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

<table class="table table-hover mt-2">
    <thead>
        <th>#</th>
        <th>Modelo</th>
        <th>Ano</th>
        <th>Cor</th>
        <th>Combustível</th>
        <th>Valor de Venda</th>
        <th>Proprietário</th>
        <th>Situação</th>
        <th>Ações</th>
    </thead>
    <tbody>
        <t:forEach items="${motocicletas}" var="motocicleta">
            <tr>
                <td><t:out value="${motocicleta.idMotocicleta}"/></td>
                <td>
                    <a href="<t:url value="/modelos/visualizar/${motocicleta.modelo.idModelo}"/>" data-toggle="tooltip" title="Visualizar Modelo">
                        <t:out value="${motocicleta.modelo.nome}"/>
                    </a>
                </td>
                <td><t:out value="${motocicleta.ano}"/></td>
                <td><t:out value="${motocicleta.cor}"/></td>
                <td><t:out value="${motocicleta.tipoCombustivel}"/></td>
                <td>
                    <fmt:formatNumber type="currency" maxFractionDigits="2" value="${motocicleta.valorVenda}" />
                </td>
                <td>
                    <a href="<t:url value="/proprietarios/visualizar/${motocicleta.proprietario.idProprietario}"/>" data-toggle="tooltip" title="Visualizar Proprietário">
                        <t:out value="${motocicleta.proprietario.nome}"/>
                    </a>
                </td>
                <td>
                    <t:set var="badge" value="${ motocicleta.situacaoMotocicleta.equals('Disponível') ? 'badge-success' : 'badge-danger' }"/>
                    <span class="badge ${badge}">
                        <t:out value="${motocicleta.situacaoMotocicleta}" />
                    </span>
                </td>
                <td>
                    <a href="<t:url value="/motocicletas/visualizar/${motocicleta.idMotocicleta}"/>" class="btn btn-sm btn-primary">
                        <span class="oi" data-glyph="eye" title="Visualizar" aria-hidden="true"></span> Visualizar
                    </a>
                    
                    <a href="<t:url value="/motocicletas/editar/${motocicleta.idMotocicleta}"/>" class="btn btn-sm btn-secondary">
                        <span class="oi" data-glyph="pencil" title="Editar" aria-hidden="true"></span> Editar
                    </a>
                    
                    <a href="<t:url value="/motocicletas/remover/${motocicleta.idMotocicleta}"/>" class="btn btn-sm btn-red">
                        <span class="oi" data-glyph="x" title="Remover" aria-hidden="true"></span> Remover
                    </a>
                </td>
            </tr>
        </t:forEach>
    </tbody>
</table>

<p><b>Total:</b> ${motocicletas.size()} registros.</p>

<t:import url="../templates/footer.jsp"/>