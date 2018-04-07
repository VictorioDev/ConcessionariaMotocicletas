<%-- 
    Document   : categoria
    Created on : 07/04/2018, 13:54:18
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<t:import url="../templates/header.jsp"/>

    <h1>Categorias: </h1>
    <table class="table table-hover">
        
        <thead>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Ações</th>
        </thead>
        <tbody>
            <t:forEach items="${categorias}" var="categ">
                <tr>
                    <td><t:out value="${categ.idCategoria}"/></td>
                    <td><t:out value="${categ.nome}"/></td>
                    <td><t:out value="${categ.descricao}"/></td>
                    <td>
                        <a href="<t:url value="categorias/visualizar/${categ.idCategoria}"/>"S class="btn btn-sm btn-primary">Visualizar</a>
                        <a href="<t:url value="categorias/editar/${categ.idCategoria}"/>"S class="btn btn-sm btn-primary">Editar</a>
                        <a href="<t:url value="categorias/remover/${categ.idCategoria}"/>"S class="btn btn-sm btn-primary">Remover</a>
                    </td>
                </tr>
            </t:forEach>
        </tbody>
    </table>
    <p><b>Total:</b> ${categorias.size()} registros.</p>
    
    

<t:import url="../templates/footer.jsp"/>
