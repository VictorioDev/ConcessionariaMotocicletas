<%-- 
    Document   : categoria
    Created on : 07/04/2018, 13:54:18
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Categorias</h3>

<a href="<t:url value="/categorias/cadastrar"/>" class="btn btn-primary">Nova Categoria</a>

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

<table class="table table-hover">
    <thead>
    <th>#</th>
    <th>Nome</th>
    <th>Descrição</th>
    <th>Ações</th>
</thead>
<tbody>
    <t:forEach items="${categorias}" var="categ">
        <tr>
            <td><t:out value="${categ.idCategoria}"/></td>
            <td><t:out value="${categ.nome}"/></td>
            <td><t:out value="${categ.descricao}"/></td>
            <td>
                <a href="<t:url value="categorias/visualizar/${categ.idCategoria}"/>"S class="btn btn-sm btn-primary">Visualizar</a>
                <a href="<t:url value="categorias/editar/${categ.idCategoria}"/>"S class="btn btn-sm btn-primary">Editar</a>
                <a href="<t:url value="categorias/remover/${categ.idCategoria}"/>"S class="btn btn-sm btn-primary">Remover</a>
            </td>
        </tr>
    </t:forEach>
</tbody>
</table>
<p><b>Total:</b> ${categorias.size()} registros.</p>



<t:import url="../templates/footer.jsp"/>
