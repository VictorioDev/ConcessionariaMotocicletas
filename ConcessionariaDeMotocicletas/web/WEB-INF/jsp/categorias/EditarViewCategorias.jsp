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
 
<h3>Alterar Categoria</h3>
<form:form action="/ConcessionariaDeMotocicletas/categorias/editar" method="POST" modelAttribute="categoria" acceptCharset="UTF-8">
    <div class="form-group row">
        <div class="col-2">
            <form:label path="nome" cssClass="scol-sm-2 col-form-label">Nome</form:label>
        </div>

        <div class="col-10">
            <form:input path="nome" cssClass="form-control" placeholder="Digite o nome da categoria..."/>
        </div>
    </div>

    <div class="form-group row">
        <div class="col-2">
            <form:label path="descricao" cssClass="scol-sm-2 col-form-label">Descrição</form:label>
        </div>

        <div class="col-10">
            <form:input path="descricao" cssClass="form-control" placeholder="Digite a descrição da categoria..."/>
        </div>
    </div>
    
    <div class="form-group row">
        <div class="col-10">
            <form:input type="hidden" path="idCategoria" cssClass="form-control" placeholder="Digite a descrição da categoria..."/>
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