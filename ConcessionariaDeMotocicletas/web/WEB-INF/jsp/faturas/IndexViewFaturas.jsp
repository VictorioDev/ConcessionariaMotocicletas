<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="credit-card" title="Faturas" aria-hidden="true"></span> Faturas
</h3>

<form method="GET">
    <div class="container-fluid mt-2">
        <div class="row">
            <div class="col-md-5">
                <div class="row">
                    <input type="text" id="search" name="search" class="form-control col-md-10" placeholder="Digite a sua busca...">
                    <button type="submit" class="btn btn-sm btn-secondary col-md-2">
                        <span class="oi" data-glyph="magnifying-glass"></span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</form>

<table class="table table-hover mt-2">
    <thead>
        <th>#</th>
        <th>Valor</th>
        <th>Nº</th>
        <th>Emissão</th>
        <th>Vencimento</th>
        <th>Venda</th>
        <th>Credor</th>
        <th>Status</th>
        <th>Ações</th>
    </thead>
    <tbody>
        <t:forEach items="${faturas}" var="fatura">
            <tr>
                <td>
                    <fmt:formatNumber pattern="00000000000" value="${fatura.idFatura}" />
                </td>
                <td>
                    <fmt:formatNumber type="currency" maxFractionDigits="2" value="${fatura.valorParcela}" />
                </td>
                <td><t:out value="${fatura.numeroParcela}" />º</td>
                <td>
                    <fmt:formatDate pattern="dd/MM/yyyy" value="${fatura.dataEmissao}" />
                </td>
                <td>
                    <fmt:formatDate pattern="dd/MM/yyyy" value="${fatura.dataVencimento}" />
                </td>
                <td>
                    <small>
                        <a href="<t:url value="/vendas/visualizar/${fatura.venda.idVenda}"/>" data-toggle="tooltip" title="Visualizar Venda">
                            Nº <t:out value="${fatura.venda.idVenda}"/> (<t:out value="${fatura.venda.motocicleta.modelo.marca.nome} ${fatura.venda.motocicleta.modelo.nome}"/>)
                        </a>
                    </small>
                </td>
                <td>
                    <small>
                        <a href="<t:url value="/clientes/visualizar/${fatura.venda.cliente.idCliente}"/>" data-toggle="tooltip" title="Visualizar Cliente">
                            <t:out value="${fatura.venda.cliente.nome}"/>
                        </a>
                    </small>
                </td>
                <td>
                    <t:choose>
                        <t:when test="${ fatura.status.equals('Paga') }">
                            
                            <!-- Filtros -->
                            <fmt:parseDate value="${ fatura.dataPagamento }" type="both" pattern="yyyy-MM-dd HH:mm:ss" var="parsed"/>
                            <fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${parsed}" var="data" />                            
                            <fmt:formatNumber type="currency" maxFractionDigits="2" value="${fatura.valorPago}" var="valor" />
                            
                            <span class="badge badge-success" data-toggle="tooltip" title="Realizado por ${fatura.usuarioBaixa.nome} no valor de ${valor} em ${data}.">
                                <t:out value="${fatura.status}" />
                            </span>
                        </t:when>
                        <t:otherwise>                            
                            <jsp:useBean id="now" class="java.util.Date"/>            
                            
                            <t:set var="atrasada" value="${ fatura.dataVencimento lt now }"/>
                            <t:choose>
                                <t:when test="${ atrasada }">
                                    <span class="badge badge-danger">${ fatura.status } (Atrasada)</span>
                                </t:when>
                                <t:otherwise>
                                    <span class="badge badge-info">
                                        <t:out value="${fatura.status}" />
                                    </span>
                                </t:otherwise>
                            </t:choose>
                        </t:otherwise>
                    </t:choose>
                </td>
                <td>
                    <a href="<t:url value="/faturas/visualizar/${fatura.idFatura}" />" class="btn btn-sm btn-primary">
                        <span class="oi" data-glyph="eye" title="Visualizar" aria-hidden="true"></span> Visualizar
                    </a>
                    
                    <t:if test="${ fatura.status.equals('Não paga') }">
                        <a href="<t:url value="/faturas/baixar/${fatura.idFatura}" />" class="btn btn-sm btn-secondary">
                            <span class="oi" data-glyph="arrow-thick-bottom" title="Baixar" aria-hidden="true"></span> Baixar
                        </a>
                    </t:if>
                </td>
            </tr>
        </t:forEach>
    </tbody>
</table>

<p><b>Total:</b> ${faturas.size()} registros.</p>

<t:import url="../templates/footer.jsp"/>