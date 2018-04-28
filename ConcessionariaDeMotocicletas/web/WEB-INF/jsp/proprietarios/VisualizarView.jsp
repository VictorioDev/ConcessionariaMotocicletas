<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Visualizar Proprietario</h3>

<a href="<t:url value="/proprietarios/alterar/${proprietario.idProprietario}" />" class="btn btn-primary btn-sm mb-3">
    Editar Proprietario
</a>
 
<!-- 
    private int idProprietario;
    private String tipo;
    private String nome;
    private String razaoSocial;
    private String rg;
    private String cpf;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;
    private Date dataNascimento;
    private String cartorio;
-->

<table class="table table-hover">
    <tr>
        <td>ID:</td>
        <td>${proprietario.idProprietario}</td>
    </tr>
    <tr>
        <td>Nome:</td>
        <td>${proprietario.nome}</td>
    </tr>
     <tr>
        <td>Tipo:</td>
        <td>${proprietario.tipo}</td>
    </tr>
    <tr>
        <td>Razão Social:</td>
        <td>${proprietario.razaoSocial}</td>
    </tr>
    <tr>
        <td>RG:</td>
        <td>${proprietario.rg}</td>
    </tr>
    <tr>
        <td>CPF:</td>
        <td>${proprietario.cpf}</td>
    </tr>
    <tr>
        <td>CNPJ:</td>
        <td>${proprietario.cnpj}</td>
    </tr>
    <tr>
        <td>Endereço:</td>
        <td>${proprietario.endereco}</td>
    </tr>
     <tr>
        <td>Telefone:</td>
        <td>${proprietario.telefone}</td>
    </tr>
     <tr>
        <td>Email:</td>
        <td>${proprietario.email}</td>
    </tr>
     <tr>
        <td>Data Nascimento:</td>
        <td>${proprietario.dataNascimento}</td>
    </tr>
    <tr>
        <td>Cartório:</td>
        <td>${proprietario.cartorio}</td>
    </tr>
</table>

<t:import url="../templates/footer.jsp"/>