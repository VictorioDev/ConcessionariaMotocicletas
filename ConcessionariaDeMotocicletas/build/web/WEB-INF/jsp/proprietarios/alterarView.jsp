<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>
 
<h3>Cadastrar Proprietário</h3>
<form:form action="/Concessionaria/proprietarios/alterar" method="POST" modelAttribute="proprietario" acceptCharset="UTF-8">
    <div class="form-group row">
        <div class="col-2">
            <form:label path="tipo" cssClass="scol-sm-2 col-form-label">Tipo</form:label>
        </div>

        <div class="col-10">
            <form:select path="tipo" cssClass="form-control" placeholder="Digite o tipo...">
                <form:option value="Pessoa Física"/>
                <form:option value="Pessoa Jurídica"/>
            </form:select>
        </div>
    </div>

    <div class="form-group row">
        <div class="col-2">
            <form:label path="nome" cssClass="scol-sm-2 col-form-label">Nome</form:label>
            </div>

            <div class="col-10">
            <form:input path="nome" cssClass="form-control" placeholder="Digite o nome..."/>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="razaoSocial" cssClass="scol-sm-2 col-form-label">Razão Social</form:label>
        </div>

        <div class="col-10">
            <form:input path="razaoSocial" cssClass="form-control" placeholder="Digite a razão social..."/>
         </div>
    </div>

    <div class="form-group row">
        <div class="col-2">
            <form:label path="rg" cssClass="scol-sm-2 col-form-label">RG</form:label>
        </div>

        <div class="col-10">
            <form:input path="rg" cssClass="form-control" placeholder="Digite o RG..."/>
        </div>
    </div>
            
    <div class="form-group row">
        <div class="col-2">
            <form:label path="cpf" cssClass="scol-sm-2 col-form-label">CPF</form:label>
        </div>

        <div class="col-10">
            <form:input path="cpf" cssClass="form-control" placeholder="Digite o CPF..."/>
        </div>
    </div>
     
    <div class="form-group row">
        <div class="col-2">
            <form:label path="endereco" cssClass="scol-sm-2 col-form-label">Endereço</form:label>
        </div>

        <div class="col-10">
            <form:input path="endereco" cssClass="form-control" placeholder="Digite o endereço..."/>
        </div>
    </div>
    
    <div class="form-group row">
        <div class="col-2">
            <form:label path="telefone" cssClass="scol-sm-2 col-form-label">Telefone</form:label>
        </div>

        <div class="col-10">
            <form:input path="telefone" cssClass="form-control" placeholder="Digite o telefone..."/>
        </div>
    </div>
        
     <div class="form-group row">
        <div class="col-2">
            <form:label path="dataNascimento" cssClass="scol-sm-2 col-form-label">Data Nascimento</form:label>
        </div>

        <div class="col-10">
            <form:input path="dataNascimento" type="date" cssClass="form-control" placeholder="Digite a data de nascimento..."/>
        </div>
    </div>    
    
           
     <div class="form-group row">
        <div class="col-2">
            <form:label path="cartorio" cssClass="scol-sm-2 col-form-label">Cartório</form:label>
        </div>

        <div class="col-10">
            <form:input path="cartorio" type="text" cssClass="form-control" placeholder="Digite o cartório..."/>
        </div>
    </div>   
        
           
     <div class="form-group row">
        <div class="col-2">
            <form:label path="cnpj" cssClass="scol-sm-2 col-form-label">CNPJ</form:label>
        </div>

        <div class="col-10">
            <form:input path="cnpj" type="text" cssClass="form-control" placeholder="Digite o cnpj..."/>
        </div>
    </div>      
       
    <div class="form-group row">
        <div class="col-2">
            <form:label path="email" cssClass="scol-sm-2 col-form-label">Email</form:label>
        </div>

        <div class="col-10">
            <form:input path="email" type="text" cssClass="form-control" placeholder="Digite o email..."/>
        </div>
        
        
        <div class="col-10">
            <form:input path="idProprietario" type="hidden" cssClass="form-control"/>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Alterar</button>
         </div>
    </div>
</form:form>





<p>Listando 1 de 1 registros.</p>

<t:import url="../templates/footer.jsp"/>