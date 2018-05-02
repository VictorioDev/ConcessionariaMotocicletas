<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Cadastrar Usuário</h3>

<form:form method="POST" modelAttribute="usuario">
    <div class="form-group row">
        <form:label path="nome" class="col-sm-2 col-form-label">Nome</form:label>
        <div class="col-sm-10">
            <form:input path="nome" class="form-control ${nome}" placeholder="Digite o nome..."/>
            <div class="invalid-feedback">Preencha o nome</div>
        </div>
    </div>
    
    <div class="form-group row">
        <form:label path="login" class="col-sm-2 col-form-label">Login</form:label>
        <div class="col-sm-10">
            <form:input path="login" class="form-control ${login}" placeholder="Digite o login..."/>
            <div class="invalid-feedback">Preencha o login</div>
        </div>
    </div>
        
    <div class="form-group row">
        <form:label path="senha" class="col-sm-2 col-form-label">Senha</form:label>
        <div class="col-sm-10">
            <form:input path="senha" type="password" class="form-control ${senha}" placeholder="Digite a senha..."/>
            <div class="invalid-feedback">Preencha a senha</div>
        </div>
    </div>
        
    <div class="form-group row">
        <form:label path="cpf" class="col-sm-2 col-form-label">CPF</form:label>
        <div class="col-sm-10">
            <form:input path="cpf" class="form-control ${cpf}" placeholder="Digite o CPF..."/>
            <div class="invalid-feedback">Preencha o cpf</div>
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
        <label for="tipo" class="col-sm-2 col-form-label">Tipo</label>
        <div class="col-sm-10">
            <select class="form-control" id="tipo" name="tipo">
                <option value="Gerente">Gerente</option>
                <option value="Vendedor">Vendedor</option>
            </select>
        </div>
    </div>
    
    <button type="submit" class="btn btn-primary">Cadastrar</button>
</form:form>

<t:import url="../templates/footer.jsp"/>