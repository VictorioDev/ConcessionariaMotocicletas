<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="folder" title="Marcas" aria-hidden="true"></span> Marcas
</h3>

<a href="<t:url value="/marcas/cadastrar"/>" class="btn btn-primary btn-sm">
    <span class="oi" data-glyph="plus" title="Acessórios" aria-hidden="true"></span> Nova marca
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

<table class="table table-hover table-striped mt-2">
    <thead>
    <th>#</th>
    <th>Nome</th>
    <th>Descrição</th>
    <th>Ações</th>
</thead>
<tbody>
    <t:forEach items="${marcas}" var="marca">
        <tr>
            <td><t:out value="${marca.idMarca}"/></td>
            <td><t:out value="${marca.nome}"/></td>
            <td><t:out value="${marca.descricao}"/></td>
            <td>
                <a href="<t:url value="/marcas/visualizar/${marca.idMarca}"/>" class="btn btn-sm btn-primary">
                    <span class="oi" data-glyph="eye" title="Visualizar" aria-hidden="true"></span> Visualizar
                </a>
                <a href="<t:url value="/marcas/alterar/${marca.idMarca}"/>" class="btn btn-sm btn-secondary">
                    <span class="oi" data-glyph="pencil" title="Editar" aria-hidden="true"></span> Editar
                </a>
                <a href="<t:url value="/marcas/remover/${marca.idMarca}"/>" class="btn btn-sm btn-red">
                    <span class="oi" data-glyph="x" title="Remover" aria-hidden="true"></span> Remover
                </a></td>
        </tr>
    </t:forEach>
</tbody>
</table>

<p><b>Total:</b> ${marcas.size()} registros.</p>

<t:import url="../templates/footer.jsp"/>