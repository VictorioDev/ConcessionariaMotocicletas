<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Marcas</h3>

<a href="<t:url value="/marcas/cadastrar"/>" class="btn btn-primary">Nova Marca</a>

<form method="GET">
    <div class="container-fluid mt-2">
        <div class="row">
            <div class="col-md-5">
                <div class="row">
                    <input type="text" id="search" name="search" class="form-control col-md-10" placeholder="Digite a sua busca...">
                    <button type="submit" class="btn btn-sm btn-secondary col-md-2">Buscar</button>
                </div>
            </div>
        </div>
    </div>
</form>

<table class="table table-hover table-striped mt-2">
    <thead>
    <th>#</th>
    <th>Nome</th>
    <th>Descricao</th>
</thead>
<tbody>
    <t:forEach items="${marcas}" var="marca">
        <tr>
            <td><t:out value="${marca.idMarca}"/></td>
            <td><t:out value="${marca.nome}"/></td>
            <td><t:out value="${marca.descricao}"/></td>
            <td><a href="#" class="btn btn-sm btn-primary mb-2">Visualizar</a>
                <a href="marcas/alterar/${marca.idMarca}" class="btn btn-sm btn-primary mb-2">Editar</a>
                <a href="marcas/remover/${marca.idMarca}" class="btn btn-sm btn-primary mb-2">Remover</a></td>
        </tr>
    </t:forEach>
</tbody>
</table>

<p>Listando 1 de 1 registros.</p>

<t:import url="../templates/footer.jsp"/>