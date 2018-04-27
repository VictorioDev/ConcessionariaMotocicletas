<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Visualizar Clientes</h3>

<a href="<t:url value="/clientes/editar/${cliente.idCliente}" />" class="btn btn-primary btn-sm mb-3">
    Editar Cliente
</a>

<table class="table table-hover">
    <tr>
        <td>Tipo:</td>
        <td>${cliente.tipo}</td>
    </tr>
    
    <tr>
        <td>Nome:</td>
        <td>${cliente.nome}</td>
    </tr>
    
    <tr>
        <td>Razão Social:</td>
        <td>${cliente.razaoSocial}</td>
    </tr>
    
    <tr>
        <td>CPF:</td>
        <td>${cliente.CPF}</td>
    </tr>
    
    <tr>
        <td>CNPJ:</td>
        <td>${cliente.CNPJ}</td>
    </tr>
    
    <tr>
        <td>Endereço:</td>
        <td>${cliente.endereco}</td>
    </tr>
    
    <tr>
        <td>Telefone:</td>
        <td>${cliente.telefone}</td>
    </tr>
    
    <tr>
        <td>E-mail:</td>
        <td>${cliente.email}</td>
    </tr>
    
    <tr>
        <td>DataNascimento:</td>
        <td>${cliente.dataNascimento}</td>
    </tr>
    
     <tr>
        <td>DataCadastro:</td>
        <td>${cliente.dataCadastro}</td>
    </tr>
    
     <tr>
        <td>Status:</td>
        <td>${cliente.status}</td>
    </tr>
</table>

<t:import url="../templates/footer.jsp"/>