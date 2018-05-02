<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>
 
<h3 class="title">
    <span class="oi" data-glyph="wrench" title="Motocicletas" aria-hidden="true"></span> Editar Motocicleta
</h3>

<form:form  method="POST" modelAttribute="motocicleta" acceptCharset="UTF-8">
    <div class="form-group row">
        <div class="col-2">
            <form:label path="ano" cssClass="scol-sm-2 col-form-label bold">Ano:</form:label>
        </div>

        <div class="col-10">
            <form:input path="ano" type="number" cssClass="form-control ${ano}" placeholder="Digite o ano..."/>
            <div class="invalid-feedback">Preencha o ano</div>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="chassi" cssClass="scol-sm-2 col-form-label bold">Chassi:</form:label>
        </div>

        <div class="col-10">
            <form:input path="chassi" cssClass="form-control ${chassi}" placeholder="Digite o chassi..."/>
            <div class="invalid-feedback">Preencha o chassi</div>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="cor" cssClass="scol-sm-2 col-form-label bold">Cor:</form:label>
        </div>

        <div class="col-10">
            <form:input path="cor" cssClass="form-control ${cor}" placeholder="Digite a cor..."/>
            <div class="invalid-feedback">Preencha a cor</div> 
        </div>
    </div>
    
    <div class="form-group row">
        <div class="col-2">
            <form:label path="tipoCombustivel" cssClass="scol-sm-2 col-form-label bold">Tipo de Combustível:</form:label>
        </div>

        <div class="col-10">
            <form:input path="tipoCombustivel" cssClass="form-control ${tipoCombustivel}" placeholder="Digite o tipo do combustível..."/>
            <div class="invalid-feedback">Preencha o tipo do combustível</div>
        </div>
    </div>

    <div class="form-group row">
        <div class="col-2">
            <form:label path="valorCompra" cssClass="scol-sm-2 col-form-label bold">Valor de Compra:</form:label>
        </div>

        <div class="col-10">
            <form:input path="valorCompra" cssClass="form-control ${valorCompra}" placeholder="Digite o valor de compra..."/>
            <div class="invalid-feedback">Preencha o valor da compra</div>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="valorVenda" cssClass="scol-sm-2 col-form-label bold">Valor de Venda:</form:label>
        </div>

        <div class="col-10">
            <form:input path="valorVenda" cssClass="form-control ${valorVenda}" placeholder="Digite o valor da venda..."/>
            <div class="invalid-feedback">Preencha o valor da venda</div>
        </div>
    </div>

    <div class="form-group row">
        <div class="col-12">
            <form:input path="situacaoMotocicleta"  type="hidden" cssClass="form-control" value="Disponível"/>
        </div>
    </div>
    
    <div class="form-group row">
        <div class="col-2">
            <form:label path="renavam" cssClass="scol-sm-2 col-form-label bold">Renavam:</form:label>
        </div>

        <div class="col-10">
            <form:input path="renavam" type="number" cssClass="form-control ${renavam}" placeholder="Digite o renavam..."/>
            <div class="invalid-feedback">Preencha o renavam</div>
        </div>
    </div>
        
   <div class="form-group row">
        <div class="col-2">
            <form:label path="placa" cssClass="scol-sm-2 col-form-label bold">Placa:</form:label>
        </div>

        <div class="col-10">
            <form:input path="placa" cssClass="form-control ${placa}" placeholder="Digite a placa..."/>
            <div class="invalid-feedback">Preencha a placa</div>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="motor" cssClass="scol-sm-2 col-form-label bold">Motor:</form:label>
        </div>

        <div class="col-10">
            <form:input path="motor" cssClass="form-control ${motor}" placeholder="Digite o modelo motor..."/>
            <div class="invalid-feedback">Preencha o motor</div>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="dataVistoria" cssClass="scol-sm-2 col-form-label bold">Data da Vistoria:</form:label>
        </div>

        <div class="col-10">
            <form:input path="dataVistoria" type="date" cssClass="form-control" placeholder="Digite a data da vistoria..."/>
        </div>
    </div>
    
    <div class="form-group row">
        <div class="col-2">
            <form:label path="valorIPVA" cssClass="scol-sm-2 col-form-label bold">Valor do IPVA:</form:label>
        </div>

        <div class="col-10">
            <form:input path="valorIPVA" cssClass="form-control ${valorIPVA}" placeholder="Digite o valor do IPVA..."/>
            <div class="invalid-feedback">Preencha o valor do IPVA</div>
        </div>
    </div>
        
    <div class="form-group row">
        <div class="col-2">
            <form:label path="situacaoIPVA" cssClass="scol-sm-2 col-form-label bold">Situação IPVA:</form:label>
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
            <label class="scol-sm-2 col-form-label bold" for="idProprietario">Proprietario:</label>
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
            <label class="scol-sm-2 col-form-label bold" for="idModelo">Modelo:</label>
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
    
    <div class="form-row">
        <div class="col-12">
            <form:input path="idMotocicleta" type="hidden"/>
        </div>
    </div>
    
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Salvar</button>
         </div>
    </div>
</form:form>

<t:import url="../templates/footer.jsp"/>