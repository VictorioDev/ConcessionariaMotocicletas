<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>
 
<h3 class="title">
    <span class="oi" data-glyph="folder" title="Marcas" aria-hidden="true"></span> Cadastrar Marca
</h3>

<form:form method="POST" modelAttribute="marca" acceptCharset="UTF-8">
        
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
            <form:label path="descricao" cssClass="scol-sm-2 col-form-label bold">Descrição:</form:label>
            </div>

            <div class="col-10">
                <form:input path="descricao" cssClass="form-control ${descricao}" placeholder="Digite a descrição..."/>
                <div class="invalid-feedback">Preencha a descrição</div>
        </div>
    </div>
        
        
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Cadastrar</button>
         </div>
    </div>
 
</form:form>

<t:import url="../templates/footer.jsp"/>