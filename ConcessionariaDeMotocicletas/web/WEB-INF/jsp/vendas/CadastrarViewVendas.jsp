<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="cart" title="Vendas" aria-hidden="true"></span> Cadastrar Venda
</h3>

<form:form method="POST" modelAttribute="venda">
    
    <div class="form-group row">
        <label class="col-sm-2 col-form-label bold">Motocicleta:</label>
        <div class="col-sm-10">
            <select class="form-control" name="idMotocicleta">
                <option value="0">Selecionar...</option>
                <t:forEach items="${motocicletas}" var="motocicleta">
                    <t:set var="value" value="(${ motocicleta.idMotocicleta }) - ${ motocicleta.modelo.marca.nome} ${ motocicleta.modelo.nome } (${motocicleta.ano}, ${motocicleta.cor})"/>
                    <option value="${motocicleta.idMotocicleta}">
                        ${value} - <fmt:formatNumber type="currency" maxFractionDigits="2" value="${motocicleta.valorVenda}" />
                    </option>
                </t:forEach>
            </select>
        </div>
    </div>
    
    <div class="form-group row">
        <label class="col-sm-2 col-form-label bold">Valor:</label>
        <div class="col-sm-10">
            <label><input type="checkbox" name="personalizarValor"> Personalizar valor de venda</label>
            <form:input type="text" path="valor" class="form-control" disabled="true"/>
            
        </div>
    </div>
        
    <div class="form-group row">
        <label class="col-sm-2 col-form-label bold">Cliente:</label>
        <div class="col-sm-10">
            <select class="form-control" name="idCliente">
                <option value="0">Selecionar...</option>
                <t:forEach items="${clientes}" var="cliente">          
                    <option value="${cliente.idCliente}" label="${cliente.nome}"/>
                </t:forEach>
            </select>
            
            <small class="form-text text-muted">
                Caso o cliente não esteja cadastrado, você precisará <a href="<t:url value="/clientes/cadastrar" />">cadastrá-lo</a> primeiramente.
            </small>
        </div>
    </div>
    
    <div class="form-group row">
        <form:label path="quantidadeParcelas" class="col-sm-2 col-form-label bold">Quantidade de Parcelas:</form:label>
        <div class="col-sm-10">
            <form:input type="number" path="quantidadeParcelas" class="form-control ${quantidadeParcelas}"/>
            <div class="invalid-feedback">Preencha a quantidade de parcelas</div>
        </div>
    </div>
    
    <div class="form-group row">
        <form:label path="diaPreferencial" class="col-sm-2 col-form-label bold">Dia preferencial para pagamento:</form:label>
        <div class="col-sm-10">
            <form:input type="number" path="diaPreferencial" class="form-control ${diaPreferencial}"/>
            <div class="invalid-feedback">Preencha o dia preferencial</div>
        </div>
    </div>
    
    <button type="submit" class="btn btn-primary">Cadastrar</button>
</form:form>
    
<script type="text/javascript">
    $('select[name="idMotocicleta"]').on('change', function() {
        
        if( this.value === 0 ) {
            $('input[name="valor"]').val(0);
            return;
        }
        
        var input = $('select[name="idMotocicleta"] option:selected').text().trim();
        var valor = input.split('R$');
        
        $('input[name="valor"]').val( valor[1].trim() );
    });
    
    $('input[name="personalizarValor"]').on('change', function() {
        if( $(this).is(':checked') ) {
            $('input[name="valor"]').attr('disabled', false );
        } else {
            $('input[name="valor"]').attr('disabled', true );
        }
    });
</script>

<t:import url="../templates/footer.jsp"/>