<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h1>Editar Cliente</h1>

<form:form action="/ConcessionariaDeMotocicletas/clientes/editar" method="POST" modelAttribute="cliente">
    
    <form:input type="hidden" path="idCliente" />
    
    <div class="form-group row">
        <label for="tipo" class="col-sm-2 col-form-label">Tipo</label>
        <div class="col-sm-10">
            <select class="form-control" id="tipo" name="tipo">
                <option value="Pessoa Física">Pessoa Física</option>
                <option value="Pessoa Jurídica">Pessoa Jurídica</option>
            </select>
        </div>
    </div>
    
    <div class="form-group row">
        <form:label path="nome" class="col-sm-2 col-form-label">Nome</form:label>
        <div class="col-sm-10">
            <form:input path="nome" class="form-control ${nome}" placeholder="Digite o nome..."/>
            <div class="invalid-feedback">Preencha o nome</div>
        </div>
    </div>
    
   <div class="form-group row">
        <form:label path="razaoSocial" class="col-sm-2 col-form-label">Razão Social</form:label>
        <div class="col-sm-10">
            <form:input path="razaoSocial" class="form-control ${razaoSocial}" placeholder="Digite a razão social..."/>
            <div class="invalid-feedback">Preencha a razao social</div>
        </div>
    </div>
    
        
    <div class="form-group row">
        <form:label path="CPF" class="col-sm-2 col-form-label">CPF</form:label>
        <div class="col-sm-10">
            <form:input path="CPF" class="form-control" placeholder="Digite o CPF..."/>
        </div>
    </div>
        
    <div class="form-group row">
        <form:label path="CNPJ" class="col-sm-2 col-form-label">CNPJ</form:label>
        <div class="col-sm-10">
            <form:input path="CNPJ" class="form-control" placeholder="Digite o CNPJ..."/>
        </div>
    </div>
    
    <div class="form-group row">
        <form:label path="endereco" class="col-sm-2 col-form-label">Endereço</form:label>
        <div class="col-sm-10">
            <form:input path="endereco" class="form-control ${endereco}" placeholder="Digite o endereço..."/>
            <div class="invalid-feedback">Preencha o endereço</div>
        </div>
    </div>
        
    <div class="form-group row">
        <form:label path="telefone" class="col-sm-2 col-form-label">Telefone</form:label>
        <div class="col-sm-10">
            <form:input path="telefone" class="form-control ${telefone}" placeholder="Digite o telefone..."/>
            <div class="invalid-feedback">Preencha o telefone</div>
        </div>
    </div>

    <div class="form-group row">
        <form:label path="email" class="col-sm-2 col-form-label">E-mail</form:label>
        <div class="col-sm-10">
            <form:input path="email" class="form-control ${email}" placeholder="Digite o e-mail..."/>
            <div class="invalid-feedback">Preencha o email</div>
        </div>
    </div>
        
    <div class="form-group row">
        <form:label path="RG" class="col-sm-2 col-form-label">RG</form:label>
        <div class="col-sm-10">
            <form:input path="RG" class="form-control" placeholder="Digite o RG..."/>
        </div>
    </div>
       
        
    <div class="form-group row">
        <form:label path="dataNascimento" class="col-sm-2 col-form-label">Data de Nascimento</form:label>
        <div class="col-sm-10">
            <form:input path="dataNascimento" class="form-control" type="date"/>
        </div>
    </div> 

    
    <button type="submit" class="btn btn-primary">Salvar</button>
</form:form>

<t:import url="../templates/footer.jsp"/>