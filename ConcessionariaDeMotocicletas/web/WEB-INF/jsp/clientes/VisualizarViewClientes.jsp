<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="people" title="Clientes" aria-hidden="true"></span> Visualizar Cliente
</h3>

<a href="<t:url value="/clientes/editar/${cliente.idCliente}" />" class="btn btn-primary btn-sm mb-3">
    <span class="oi" data-glyph="pencil" title="Editar" aria-hidden="true"></span> Editar cliente
</a>

<table class="table table-hover">
    <tr>
        <td class="bold">Tipo:</td>
        <td>${cliente.tipo}</td>
    </tr>
    
    <tr>
        <td class="bold">Nome:</td>
        <td>${cliente.nome}</td>
    </tr>
    
    <tr>
        <td class="bold">Razão Social:</td>
        <td>${cliente.razaoSocial}</td>
    </tr>
    
    <tr>
        <td class="bold">CPF:</td>
        <td>${cliente.CPF}</td>
    </tr>
    
    <tr>
        <td class="bold">CNPJ:</td>
        <td>${cliente.CNPJ}</td>
    </tr>
    
    <tr>
        <td class="bold">Endereço:</td>
        <td>${cliente.endereco}</td>
    </tr>
    
    <tr>
        <td class="bold">Telefone:</td>
        <td>${cliente.telefone}</td>
    </tr>
    
    <tr>
        <td class="bold">E-mail:</td>
        <td>${cliente.email}</td>
    </tr>
    
    <tr>
        <td class="bold">Data de Nascimento:</td>
        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${cliente.dataNascimento}" /></td>
    </tr>
    
     <tr>
        <td class="bold">Data de Cadastro:</td>
        <td>${cliente.dataCadastro}</td>
    </tr>
    
     <tr>
        <td class="bold">Status:</td>
        <td>${cliente.status}</td>
    </tr>
</table>

<t:import url="../templates/footer.jsp"/>