<%-- 
    Document   : categoria
    Created on : 07/04/2018, 13:54:18
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3>Categorias</h3>

<a href="<t:url value="/acessorios/cadastrar"/>" class="btn btn-primary">Novo Acessório</a>
<form method="GET">
    <div class="container-fluid mt-2">
        <div class="row">
            <div class="col-md-5">
                <div class="row">
                    <input type="text" id="search" name="search" class="form-control col-md-10" placeholder="Digite a sua busca...">
                    <button type="submit" class="btn btn-sm btn-secondary col-md-2">Buscar</button>
                </div>
            </div>
        </div>
    </div>
</form>

<table class="table table-hover mt-2">
    <thead>
        <th>#</th>
        <th>Descrição</th>
        <th>Ações</th>
    </thead>
    <tbody>
        <t:forEach items="${acessorios}" var="acess">
            <tr>
                <td><t:out value="${acess.idAcessorio}"/></td>
                <td><t:out value="${acess.descricao}"/></td>
                <td>
                    <a href="<t:url value="/acessorios/visualizar/${acess.idAcessorio}"/>"S class="btn btn-sm btn-primary">Visualizar</a>
                    <a href="<t:url value="/acessorios/editar/${acess.idAcessorio}"/>"S class="btn btn-sm btn-primary">Editar</a>
                    <a href="<t:url value="/acessorios/remover/${acess.idAcessorio}"/>"S class="btn btn-sm btn-primary">Remover</a>
                </td>
            </tr>
        </t:forEach>
    </tbody>
</table>
<p><b>Total:</b> ${acessorios.size()} registros.</p>

<t:import url="../templates/footer.jsp"/>
