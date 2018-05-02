<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>
 
<h3 class="title">
    <span class="oi" data-glyph="key" title="Proprietários" aria-hidden="true"></span> Cadastrar Proprietário
</h3>

<form:form method="POST" modelAttribute="proprietario" acceptCharset="UTF-8">
    <div class="form-group row">
        <div class="col-2">
            <form:label path="tipo" cssClass="scol-sm-2 col-form-label bold">Tipo:</form:label>
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
            <form:label path="nome" cssClass="scol-sm-2 col-form-label bold">Nome:</form:label>
            </div>

        <div class="col-10">
            <form:input path="nome" cssClass="form-control ${nome}" placeholder="Digite o nome..."/>
            <div class="invalid-feedback">Preencha o nome</div>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="razaoSocial" cssClass="scol-sm-2 col-form-label bold">Razão Social:</form:label>
        </div>

        <div class="col-10">
            <form:input path="razaoSocial" cssClass="form-control ${razaoSocial}" placeholder="Digite a razão social..."/>
            <div class="invalid-feedback">Preencha a razão social</div>
        </div>
    </div>

    <div class="form-group row">
        <div class="col-2">
            <form:label path="rg" cssClass="scol-sm-2 col-form-label bold">RG:</form:label>
        </div>

        <div class="col-10">
            <form:input path="rg" cssClass="form-control" placeholder="Digite o RG..."/>
        </div>
    </div>
            
    <div class="form-group row">
        <div class="col-2">
            <form:label path="cpf" cssClass="scol-sm-2 col-form-label bold">CPF:</form:label>
        </div>

        <div class="col-10">
            <form:input path="cpf" cssClass="form-control" placeholder="Digite o CPF..."/>
        </div>
    </div>
     
    <div class="form-group row">
        <div class="col-2">
            <form:label path="endereco" cssClass="scol-sm-2 col-form-label bold">Endereço:</form:label>
        </div>

        <div class="col-10">
            <form:input path="endereco" cssClass="form-control ${endereco}" placeholder="Digite o endereço..."/>
            <div class="invalid-feedback">Preencha o endereco</div>
        </div>
    </div>
    
    <div class="form-group row">
        <div class="col-2">
            <form:label path="telefone" cssClass="scol-sm-2 col-form-label bold">Telefone:</form:label>
        </div>

        <div class="col-10">
            <form:input path="telefone" cssClass="form-control ${telefone}" placeholder="Digite o telefone..."/>
            <div class="invalid-feedback">Preencha o telefone</div>
        </div>
    </div>
        
     <div class="form-group row">
        <div class="col-2">
            <form:label path="dataNascimento" cssClass="scol-sm-2 col-form-label bold">Data Nascimento:</form:label>
        </div>

        <div class="col-10">
            <form:input path="dataNascimento" type="date" cssClass="form-control" placeholder="Digite a data de nascimento..."/>
        </div>
    </div>    
    
           
     <div class="form-group row">
        <div class="col-2">
            <form:label path="cartorio" cssClass="scol-sm-2 col-form-label bold">Cartório:</form:label>
        </div>

        <div class="col-10">
            <form:input path="cartorio" type="text" cssClass="form-control ${cartorio}" placeholder="Digite o cartório..."/>
            <div class="invalid-feedback">Preencha o cartório</div>
        </div>
    </div>   
        
           
     <div class="form-group row">
        <div class="col-2">
            <form:label path="cnpj" cssClass="scol-sm-2 col-form-label bold">CNPJ:</form:label>
        </div>

        <div class="col-10">
            <form:input path="cnpj" type="text" cssClass="form-control" placeholder="Digite o cnpj..."/>
        </div>
    </div>      
       
    <div class="form-group row">
        <div class="col-2">
            <form:label path="email" cssClass="scol-sm-2 col-form-label bold">Email:</form:label>
        </div>

        <div class="col-10">
            <form:input path="email" type="text" cssClass="form-control ${email}" placeholder="Digite o email..."/>
            <div class="invalid-feedback">Preencha o e-mail</div>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Cadastrar</button>
         </div>
    </div>
</form:form>

<t:import url="../templates/footer.jsp"/>