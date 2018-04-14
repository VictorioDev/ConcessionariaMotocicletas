<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Visualizar Usuário</h3>

<a href="<t:url value="/usuarios/editar/${usuario.idUsuario}" />" class="btn btn-primary btn-sm mb-3">
    Editar usuário
</a>

<table class="table table-hover">
    <tr>
        <td>Nome:</td>
        <td>${usuario.nome}</td>
    </tr>
    <tr>
        <td>Login:</td>
        <td>${usuario.login}</td>
    </tr>
    <tr>
        <td>CPF:</td>
        <td>${usuario.cpf}</td>
    </tr>
    <tr>
        <td>Endereço:</td>
        <td>${usuario.endereco}</td>
    </tr>
    <tr>
        <td>Telefone:</td>
        <td>${usuario.telefone}</td>
    </tr>
    <tr>
        <td>E-mail:</td>
        <td>${usuario.email}</td>
    </tr>
    <tr>
        <td>Tipo:</td>
        <td>${usuario.tipo}</td>
    </tr>
</table>

<t:import url="../templates/footer.jsp"/>