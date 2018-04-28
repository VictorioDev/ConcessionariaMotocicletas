<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Visualizar Proprietario</h3>

<a href="<t:url value="/motocicletas/alterar/${motocicleta.idMotocicleta}" />" class="btn btn-primary btn-sm mb-3">
    Editar Motocicleta
</a>
 
<!-- 
     private int idMotocicleta;
    private int ano;
    private String chassi;
    private String cor;
    private String tipoCombustivel;
    private double valorCompra;
    private double valorVenda;
    private String situacaoMotocicleta;
    private int renavam;
    private String placa;
    private String motor;
    private Date dataVistoria;
    private double valorIPVA;
    private String situacaoIPVA;
    private Proprietario proprietario;
    private Modelo modelo;
-->

<table class="table table-hover">
    <tr>
        <td>ID:</td>
        <td>${motocicleta.idMotocicleta}</td>
    </tr>
    <tr>
        <td>Ano:</td>
        <td>${motocicleta.ano}</td>
    </tr>
     <tr>
        <td>Chassi:</td>
        <td>${motocicleta.chassi}</td>
    </tr>
    <tr>
        <td>Cor:</td>
        <td>${motocicleta.cor}</td>
    </tr>
    <tr>
        <td>Tipo do combustível:</td>
        <td>${motocicleta.tipoCombustivel}</td>
    </tr>
    <tr>
        <td>Valor Compra:</td>
        <td>${motocicleta.valorCompra}</td>
    </tr>
    <tr>
        <td>Valor Venda:</td>
        <td>${motocicleta.valorVenda}</td>
    </tr>
    <tr>
        <td>Situação Motocicleta:</td>
        <td>${motocicleta.situacaoMotocicleta}</td>
    </tr>
     <tr>
        <td>Renavam:</td>
        <td>${motocicleta.renavam}</td>
    </tr>
     <tr>
        <td>Placa:</td>
        <td>${motocicleta.placa}</td>
    </tr>
     <tr>
        <td>Motor:</td>
        <td>${motocicleta.motor}</td>
    </tr>
    <tr>
        <td>Data Vistoria:</td>
        <td>${motocicleta.dataVistoria}</td>
    </tr>
     <tr>
        <td>Valor IPVA:</td>
        <td>${motocicleta.valorIPVA}</td>
    </tr>
    <tr>
        <td>Situação IPVA:</td>
        <td>${motocicleta.situacaoIPVA}</td>
    </tr>
    <tr>
        <td>Proprietario:</td>
        <td>${motocicleta.proprietario.nome}</td>
    </tr>
    
    <tr>
        <td>Modelo:</td>
        <td>${motocicleta.modelo.nome}</td>
    </tr>
    
</table>

<t:import url="../templates/footer.jsp"/>