<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="file" title="Modelos" aria-hidden="true"></span> Visualizar Modelo
</h3>

<a href="<t:url value="/modelos/editar/${modelo.idModelo}" />" class="btn btn-primary btn-sm mb-3">
    <span class="oi" data-glyph="pencil" title="Editar" aria-hidden="true"></span> Editar modelo
</a>

<table class="table table-hover">
    <tr>
        <td class="bold">ID:</td>
        <td>${modelo.idModelo}</td>
    </tr>
    <tr>
        <td class="bold">Nome:</td>
        <td>${modelo.nome}</td>
    </tr>
    <tr>
        <td class="bold">Descrição:</td>
        <td>${modelo.descricao}</td>
    </tr>
    <tr>
        <td class="bold">Marca:</td>
        <td>${modelo.marca.nome}</td>
    </tr>
</table>

<t:import url="../templates/footer.jsp"/>