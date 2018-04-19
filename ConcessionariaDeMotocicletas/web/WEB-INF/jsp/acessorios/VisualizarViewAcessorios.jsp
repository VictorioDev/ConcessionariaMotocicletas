<%-- 
    Document   : categoria
    Created on : 07/04/2018, 13:54:18
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<t:import url="../templates/header.jsp"/>

    <h1>Acessorios: </h1>
    <table class="table table-hover">
        
        <tbody>
            <tr>
                <td>ID:</td>
                <td><t:out value="${acessorio.idAcessorio}"/></td>
            </tr>
            <tr>
                <td>Descrição:</td>
                <td><t:out value="${acessorio.descricao}"/></td>
            </tr>
            
        </tbody>
    </table>

<t:import url="../templates/footer.jsp"/>
