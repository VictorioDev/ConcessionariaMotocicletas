<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="bar-chart" title="Relatórios" aria-hidden="true"></span> Relatório de Logs
</h3>

<table class="table table-hover table-striped mt-3">
    <thead>
        <th>Usuário</th>
        <th>Ação</th>
        <th>Data</th>
    </thead>
    <tbody>
        <t:forEach items="${logs}" var="log">
            <tr>
                <td>${ log.usuario.nome } (#${log.usuario.idUsuario})</td>
                <td>${ log.acao }</td>
                <td>
                    <fmt:parseDate value="${ log.data }" type="both" pattern="yyyy-MM-dd HH:mm:ss" var="parsed"/>
                    <fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${parsed}" />
                </td>
            </tr>
        </t:forEach>
    </tbody>
</table>

<button class="btn btn-sm btn-primary mb-2" onclick="javascript:window.print();">
    <span class="oi" data-glyph="print" title="Imprimir" aria-hidden="true"></span> Imprimir relatório
</button>

<t:import url="../templates/footer.jsp"/>