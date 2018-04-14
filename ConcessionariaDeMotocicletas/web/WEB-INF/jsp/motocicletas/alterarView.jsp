<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>
 
<h3>Cadastrar Motoicleta</h3>

<!-- 
     private int idMotocicleta;
    private int ano;
    private String chassi;
    private String cor;
    private String tipoCombustivel;
    private double valorCompra;
    private double valorVenda;
    private String situacaoMotocicleta;
    private int renavam;
    private String placa;
    private String motor;
    private Date dataVistoria;
    private double valorIPVA;
    private String situacaoIPVA;
    private Proprietario proprietario;
    private Modelo modelo;
-->
<form:form method="POST" modelAttribute="motocicleta" acceptCharset="UTF-8">
    <div class="form-group row">
        <div class="col-2">
            <form:label path="ano" cssClass="scol-sm-2 col-form-label">Ano</form:label>
        </div>

        <div class="col-10">
            <form:input path="ano" type="number" cssClass="form-control" placeholder="Digite o ano..."/>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="chassi" cssClass="scol-sm-2 col-form-label">Chassi</form:label>
        </div>

        <div class="col-10">
            <form:input path="chassi" cssClass="form-control" placeholder="Digite o chassi..."/>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="cor" cssClass="scol-sm-2 col-form-label">Cor</form:label>
        </div>

        <div class="col-10">
            <form:input path="cor" cssClass="form-control" placeholder="Digite a cor..."/>
        </div>
    </div>
    
    <div class="form-group row">
        <div class="col-2">
            <form:label path="tipoCombustivel" cssClass="scol-sm-2 col-form-label">Tipo de combustível</form:label>
        </div>

        <div class="col-10">
            <form:input path="tipoCombustivel" cssClass="form-control" placeholder="Digite o tipo do combustível..."/>
        </div>
    </div>

    <div class="form-group row">
        <div class="col-2">
            <form:label path="valorCompra" cssClass="scol-sm-2 col-form-label">Valor Compra</form:label>
        </div>

        <div class="col-10">
            <form:input path="valorCompra" cssClass="form-control" placeholder="Digite o valor de compra..."/>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="valorVenda" cssClass="scol-sm-2 col-form-label">Valor Venda</form:label>
        </div>

        <div class="col-10">
            <form:input path="valorVenda" cssClass="form-control" placeholder="Digite o valor da venda..."/>
        </div>
    </div>

    <div class="form-group row">
        <div class="col-12">
            <form:input path="situacaoMotocicleta"  type="hidden" cssClass="form-control" value="Disponível"/>
        </div>
    </div>
    
    <div class="form-group row">
        <div class="col-2">
            <form:label path="renavam" cssClass="scol-sm-2 col-form-label">Renavam</form:label>
        </div>

        <div class="col-10">
            <form:input path="renavam" type="number" cssClass="form-control" placeholder="Digite o renavam..."/>
        </div>
    </div>
        
   <div class="form-group row">
        <div class="col-2">
            <form:label path="placa" cssClass="scol-sm-2 col-form-label">Placa</form:label>
        </div>

        <div class="col-10">
            <form:input path="placa" cssClass="form-control" placeholder="Digite a placa..."/>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="motor" cssClass="scol-sm-2 col-form-label">Motor</form:label>
        </div>

        <div class="col-10">
            <form:input path="motor" cssClass="form-control" placeholder="Digite o modelo motor..."/>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="dataVistoria" cssClass="scol-sm-2 col-form-label">Data da Vistoria</form:label>
        </div>

        <div class="col-10">
            <form:input path="dataVistoria" type="date" cssClass="form-control" placeholder="Digite a data da vistoria..."/>
        </div>
    </div>
    
    <div class="form-group row">
        <div class="col-2">
            <form:label path="valorIPVA" cssClass="scol-sm-2 col-form-label">Valor do IPVA</form:label>
        </div>

        <div class="col-10">
            <form:input path="valorIPVA" cssClass="form-control" placeholder="Digite o valor do IPVA..."/>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="situacaoIPVA" cssClass="scol-sm-2 col-form-label">Situação IPVA</form:label>
        </div>

        <div class="col-10">
            <form:select path="situacaoIPVA" cssClass="form-control">
                <form:option value="Em dia"/>
                <form:option value="Atrasado"/>
            </form:select>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <label class="scol-sm-2 col-form-label" for="idProprietario">Proprietario</label>
        </div>

        <div class="col-10">
            <select class="form-control" name="idProprietario">
                <t:forEach items="${proprietarios}" var="proprietario">
                    <t:if test="${proprietario.idProprietario == motocicleta.proprietario.idProprietario}">
                        <option value="${proprietario.idProprietario}" label="${proprietario.nome}" selected="true"/>
                    </t:if>
                    <t:if test="${proprietario.idProprietario != motocicleta.proprietario.idProprietario}">
                        <option value="${proprietario.idProprietario}" label="${proprietario.nome}" />
                    </t:if>                </t:forEach>
            </select> 
        </div>
    </div>
         
    <div class="form-group row">
        <div class="col-2">
            <label class="scol-sm-2 col-form-label" for="idModelo">Modelo</label>
        </div>

        <div class="col-10">
            <select class="form-control" name="idModelo">
                <t:forEach items="${modelos}" var="modelo">
                    <t:if test="${modelo.idModelo == motocicleta.modelo.idModelo}">
                        <option value="${modelo.idModelo}" label="${modelo.nome}" selected="true"/>
                    </t:if>
                    <t:if test="${modelo.idModelo != motocicleta.modelo.idModelo}">
                        <option value="${modelo.idModelo}" label="${modelo.nome}" />
                    </t:if>                
                </t:forEach>
            </select> 
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Cadastrar</button>
         </div>
    </div>
</form:form>





<p>Listando 1 de 1 registros.</p>

<t:import url="../templates/footer.jsp"/>