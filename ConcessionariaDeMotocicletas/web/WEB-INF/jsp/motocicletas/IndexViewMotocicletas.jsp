<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <th>Ano</th>
        <th>Cor</th>
        <th>Tipo de Combustível</th>
        <th>Valor de Venda</th>
        <th>Situação Motocicleta</th>
        <th>Proprietário</th>
        <th>Modelo</th>
        <th>Ações</th>
    </thead>
    <tbody>
        <t:forEach items="${motocicletas}" var="motocicleta">
            <tr>
                <td><t:out value="${motocicleta.idMotocicleta}"/></td>
                <td><t:out value="${motocicleta.ano}"/></td>
                <td><t:out value="${motocicleta.cor}"/></td>
                <td><t:out value="${motocicleta.tipoCombustivel}"/></td>
                <td><t:out value="${motocicleta.valorVenda}"/></td>
                <td><t:out value="${motocicleta.situacaoMotocicleta}"/></td>
                <td><t:out value="${motocicleta.proprietario.nome}"/></td>
                <td><t:out value="${motocicleta.modelo.nome}"/></td>
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