<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="folder" title="Marcas" aria-hidden="true"></span> Visualizar Marca
</h3>

<a href="<t:url value="/marcas/editar/${marca.idMarca}" />" class="btn btn-primary btn-sm mb-3">
    <span class="oi" data-glyph="pencil" title="Editar" aria-hidden="true"></span> Editar marca
</a>

<table class="table table-hover">
    <tr>
        <td class="bold">ID:</td>
        <td>${marca.idMarca}</td>
    </tr>
    <tr>
        <td class="bold">Nome:</td>
        <td>${marca.nome}</td>
    </tr>
    <tr>
        <td class="bold">Descrição:</td>
        <td>${marca.descricao}</td>
    </tr>
</table>

<t:import url="../templates/footer.jsp"/>