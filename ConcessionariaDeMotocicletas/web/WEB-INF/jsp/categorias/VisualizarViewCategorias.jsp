<%-- 
    Document   : categoria
    Created on : 07/04/2018, 13:54:18
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="badge" title="Categoria" aria-hidden="true"></span> Visualizar Categoria
</h3>

<a href="<t:url value="/categorias/editar/${categoria.idCategoria}" />" class="btn btn-primary btn-sm mb-3">
    <span class="oi" data-glyph="pencil" title="Editar" aria-hidden="true"></span> Editar categoria
</a>

<table class="table table-hover">

    <tbody>
        <tr>
            <td class="bold">ID:</td>
            <td><t:out value="${categoria.idCategoria}"/></td>
        </tr>
        <tr>
            <td class="bold">Nome:</td>
            <td><t:out value="${categoria.nome}"/></td>
        </tr>
        <tr>
            <td class="bold">Descrição:</td>
            <td><t:out value="${categoria.descricao}"/></td>
        </tr>

    </tbody>
</table>

<t:import url="../templates/footer.jsp"/>
