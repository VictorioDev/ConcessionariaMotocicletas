<%-- 
    Document   : AlterarViewCategorias
    Created on : 13/04/2018, 22:44:34
    Author     : Vitor Manoel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<t:import url="../templates/header.jsp"/>
 
<h3 class="title">
    <span class="oi" data-glyph="badge" title="Acessórios" aria-hidden="true"></span> Alterar Acessório
</h3>

<form:form action="/ConcessionariaDeMotocicletas/acessorios/editar" method="POST" modelAttribute="acessorio" acceptCharset="UTF-8">
    <div class="form-group row">
        <div class="col-2 bold">
            <form:label path="descricao" cssClass="scol-sm-2 col-form-label">Descrição:</form:label>
        </div>

        <div class="col-10">
            <form:input path="descricao" cssClass="form-control ${descricao}" placeholder="Digite a descrição do acessorio..."/>
            <div class="invalid-feedback">Preencha a descrição.</div>
        </div>
    </div>
    
    <div class="form-group row">
        <div class="col-10">
            <form:input type="hidden" path="idAcessorio" cssClass="form-control" placeholder="Digite a descrição do acessório..."/>
        </div>
    </div>
         
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Salvar</button>
         </div>
    </div>
 
</form:form>

<t:import url="../templates/footer.jsp"/>
