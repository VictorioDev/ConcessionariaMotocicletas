<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="key" title="Proprietários" aria-hidden="true"></span> Visualizar Proprietário
</h3>

<a href="<t:url value="/proprietarios/alterar/${proprietario.idProprietario}" />" class="btn btn-primary btn-sm mb-3">
    <span class="oi" data-glyph="pencil" title="Editar" aria-hidden="true"></span> Editar proprietário
</a>

<table class="table table-hover">
    <tr>
        <td class="bold">ID:</td>
        <td>${proprietario.idProprietario}</td>
    </tr>
    <tr>
        <td class="bold">Nome:</td>
        <td>${proprietario.nome}</td>
    </tr>
     <tr>
        <td class="bold">Tipo:</td>
        <td>${proprietario.tipo}</td>
    </tr>
    <tr>
        <td class="bold">Razão Social:</td>
        <td>${proprietario.razaoSocial}</td>
    </tr>
    <tr>
        <td class="bold">RG:</td>
        <td>${proprietario.rg}</td>
    </tr>
    <tr>
        <td class="bold">CPF:</td>
        <td>${proprietario.cpf}</td>
    </tr>
    <tr>
        <td class="bold">CNPJ:</td>
        <td>${proprietario.cnpj}</td>
    </tr>
    <tr>
        <td class="bold">Endereço:</td>
        <td>${proprietario.endereco}</td>
    </tr>
     <tr>
        <td class="bold">Telefone:</td>
        <td>${proprietario.telefone}</td>
    </tr>
     <tr>
        <td class="bold">E-mail:</td>
        <td>${proprietario.email}</td>
    </tr>
     <tr>
        <td class="bold">Data de Nascimento:</td>
        <td>
            <fmt:formatDate pattern="dd/MM/yyyy" value="${proprietario.dataNascimento}" />
        </td>
    </tr>
    <tr>
        <td class="bold">Cartório:</td>
        <td>${proprietario.cartorio}</td>
    </tr>
</table>

<t:import url="../templates/footer.jsp"/>