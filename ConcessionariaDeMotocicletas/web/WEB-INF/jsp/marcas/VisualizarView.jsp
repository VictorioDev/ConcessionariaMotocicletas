<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Visualizar Marca</h3>

<a href="<t:url value="/marcas/alterar/${marca.idMarca}" />" class="btn btn-primary btn-sm mb-3">
    Editar marca
</a>

<table class="table table-hover">
    <tr>
        <td>ID:</td>
        <td>${marca.idMarca}</td>
    </tr>
    <tr>
        <td>Nome:</td>
        <td>${marca.nome}</td>
    </tr>
    <tr>
        <td>Descrição:</td>
        <td>${marca.descricao}</td>
    </tr>
</table>

<t:import url="../templates/footer.jsp"/>