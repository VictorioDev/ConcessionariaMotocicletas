<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="credit-card" title="Faturas" aria-hidden="true"></span> Baixar Fatura
</h3>

<form method="POST" action="">    
    <div class="form-group row">
        <div class="col-2 bold">Nº da Fatura:</div>
        <div class="col-10"><fmt:formatNumber pattern="00000000000" value="${fatura.idFatura}" /></div>
    </div>
    
    <div class="form-group row">
        <div class="col-2 bold">Nº da Parcela:</div>
        <div class="col-10"><t:out value="${fatura.numeroParcela}" /></div>
    </div>
    
    <div class="form-group row">
        <div class="col-2 bold">Emissão:</div>
        <div class="col-10"><fmt:formatDate pattern="dd/MM/yyyy" value="${fatura.dataEmissao}" /></div>
    </div>
    
    <div class="form-group row">
        <div class="col-2 bold">Vencimento:</div>
        <div class="col-10"><fmt:formatDate pattern="dd/MM/yyyy" value="${fatura.dataVencimento}" /></div>
    </div>
    
    <div class="form-group row">
        <div class="col-2 bold">Valor da Fatura:</div>
        <div class="col-10"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${fatura.valorParcela}" /></div>
    </div>
    
    <div class="form-group row">
        <div class="col-2 bold">Venda:</div>
        <div class="col-10">
            <a href="<t:url value="/vendas/visualizar/${fatura.venda.idVenda}"/>" data-toggle="tooltip" title="Visualizar Venda">
                Nº <t:out value="${fatura.venda.idVenda}"/> (<t:out value="${fatura.venda.motocicleta.modelo.marca.nome} ${fatura.venda.motocicleta.modelo.nome}"/>)
            </a>
        </div>
    </div>
            
    <div class="form-group row">
        <div class="col-2 bold">Credor:</div>
        <div class="col-10">
            <a href="<t:url value="/clientes/visualizar/${fatura.venda.cliente.idCliente}"/>" data-toggle="tooltip" title="Visualizar Cliente">
                <t:out value="${fatura.venda.cliente.nome}"/>
            </a>
        </div>
    </div>
            
    <div class="form-group row">
        <div class="col-2 bold"><label for="pagamento" class="col-form-label">Pagamento:</label></div>
        <div class="col-10">
            <select name="tipoPagamento" class="form-control">
                <option value="Dinheiro">Dinheiro</option>
                <option value="Cartão">Cartão</option>
                <option value="Cheque">Cheque</option>
            </select>
        </div>
    </div>

    <div class="form-group row">
        <div class="col-2 bold"><label for="juros" class="col-form-label">Juros:</label></div>
        <div class="col-10">
            <input type="number" class="form-control" name="juros" placeholder="Preencha os juros, caso tenha...">
        </div>
    </div>
    
    <div class="form-group row">
        <div class="col-2 bold">Total a pagar:</div>
        <div class="col-10">
            <span id="valorPagar">
                <fmt:formatNumber type="currency" maxFractionDigits="2" value="${fatura.valorParcela}" />
            </span>
        </div>
    </div>
            
    <input type="hidden" name="idFatura" value="${fatura.idFatura}">
    
    <button class="btn btn-primary">
        <span class="oi" data-glyph="arrow-thick-bottom" title="Baixar" aria-hidden="true"></span> Baixar fatura
    </button>
</form>

<t:import url="../templates/footer.jsp"/>