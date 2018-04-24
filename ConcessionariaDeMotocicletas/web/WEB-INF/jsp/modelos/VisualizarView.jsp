<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Visualizar Modelo</h3>

<a href="<t:url value="/modelos/alterar/${modelo.idModelo}" />" class="btn btn-primary btn-sm mb-3">
    Editar modelo
</a>

<table class="table table-hover">
    <tr>
        <td>ID:</td>
        <td>${modelo.idModelo}</td>
    </tr>
    <tr>
        <td>Nome:</td>
        <td>${modelo.nome}</td>
    </tr>
    <tr>
        <td>Descrição:</td>
        <td>${modelo.descricao}</td>
    </tr>
    <tr>
        <td>Marca:</td>
        <td>${modelo.marca.nome}</td>
    </tr>
</table>

<t:import url="../templates/footer.jsp"/>