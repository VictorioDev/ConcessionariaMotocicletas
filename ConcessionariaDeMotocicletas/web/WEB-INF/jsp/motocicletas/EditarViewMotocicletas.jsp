<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="wrench" title="Motocicletas" aria-hidden="true"></span> Editar Motocicleta
</h3>

<form:form method="POST" modelAttribute="motocicleta" acceptCharset="UTF-8" id="form">
    <div class="form-group row">
        <div class="col-1 bold">Tipo:</div>
        <div class="col-11">
            <label class="mb-0"><input id="nova" type="radio" name="tipo" value="nova"  disabled <t:if test="${motocicleta.proprietario.idProprietario == null}">checked</t:if>> Motocicleta nova</label>
            <label class="mb-0"><input id="usada" type="radio" name="tipo" value="usada" disabled <t:if test="${motocicleta.proprietario.idProprietario != null}">checked</t:if>> Motocicleta usada</label>
            </div><!-- col-9 -->
        </div><!-- row -->

        <hr>

        <div id="options-group">
            <div class="row">
                <div class="col-md-6">

                    <div class="form-group row">
                        <div class="col-4">
                            <label class="scol-sm-2 col-form-label bold">Modelo/Marca: <span class="required">*</span></label>
                        </div>

                        <div class="col-8">
                            <select class="form-control" name="idModelo">
                            <t:forEach items="${modelos}" var="modelo">    
                                <option value="${modelo.idModelo}" label="${modelo.nome} (${modelo.marca.nome})"/>
                            </t:forEach>
                        </select> 
                    </div>
                </div><!-- form-group -->

                <div class="form-group row">
                    <div class="col-4">
                        <form:label path="motor" cssClass="scol-sm-2 col-form-label bold">Motor: <span class="required">*</span></form:label>
                        </div>

                        <div class="col-8">
                        <form:input path="motor" cssClass="form-control ${motor}" placeholder="Digite o modelo motor..."/>
                        <div class="invalid-feedback">Preencha o motor</div>
                    </div>
                </div><!-- form-group -->

                <div class="form-group row">
                    <div class="col-4">
                        <form:label path="ano" cssClass="scol-sm-2 col-form-label bold">Ano: <span class="required">*</span></form:label>
                        </div>

                        <div class="col-8">
                        <form:input path="ano" cssClass="form-control ${chassi}" placeholder="Digite o ano..."/>
                        <div class="invalid-feedback">Preencha o ano</div>
                    </div>
                </div><!-- form-group -->

                <div class="form-group row">
                    <div class="col-4">
                        <form:label path="chassi" cssClass="scol-sm-2 col-form-label bold">Chassi: <span class="required">*</span></form:label>
                        </div>

                        <div class="col-8">
                        <form:input path="chassi" cssClass="form-control ${chassi}" placeholder="Digite o chassi..."/>
                        <div class="invalid-feedback">Preencha o chassi</div>
                    </div>
                </div><!-- form-group -->

                <div class="form-group row">
                    <div class="col-4">
                        <form:label path="cor" cssClass="scol-sm-2 col-form-label bold">Cor: <span class="required">*</span></form:label>
                        </div>

                        <div class="col-8">
                        <form:input path="cor" cssClass="form-control ${cor}" placeholder="Digite a cor..."/>
                        <div class="invalid-feedback">Preencha a cor</div>
                    </div>
                </div><!-- form-group -->      

                <div class="form-group row mb-0">
                    <div class="col-4">
                        <form:label path="tipoCombustivel" cssClass="scol-sm-2 col-form-label bold">Combustível: <span class="required">*</span></form:label>
                        </div>

                        <div class="col-8">
                        <form:select class="form-control" path="tipoCombustivel">
                            <form:option value="Álcool" label="Álcool"/>
                            <form:option value="Gasolina" label="Gasolina"/>
                        </form:select>
                    </div>
                </div><!-- form-group -->  
            </div>
            <div class="col-md-6">
                <div class="form-group row">
                    <div class="col-4">
                        <form:label path="valorCompra" cssClass="scol-sm-2 col-form-label bold">Valor de Compra: <span class="required">*</span></form:label>
                        </div>

                        <div class="col-8">
                        <form:input path="valorCompra" cssClass="form-control ${valorCompra}" placeholder="Digite o valor de compra..."/>
                        <div class="invalid-feedback">Preencha o valor da compra</div>
                    </div>
                </div><!-- form-group -->

                <div class="form-group row">
                    <div class="col-4">
                        <form:label path="valorVenda" cssClass="scol-sm-2 col-form-label bold">Valor de Venda: <span class="required">*</span></form:label>
                        </div>

                        <div class="col-8">
                        <form:input path="valorVenda" cssClass="form-control ${valorVenda}" placeholder="Digite o valor da venda..."/>
                        <div class="invalid-feedback">Preencha o valor da venda</div>
                    </div>
                </div><!-- form-group -->             

                <div class="form-group row">
                    <div class="col-4">
                        <label class="scol-sm-2 col-form-label bold">Categorias:</label>
                    </div>

                    <div class="col-8">
                        <t:forEach items="${categorias}" var="categoria">
                            <t:set var="usado"  scope="page" value="${false}"/>
                            <t:forEach  items="${categoriasUsadas}" var="categoriaUsada">
                                 <t:if test="${categoria.idCategoria == categoriaUsada.idCategoria }">
                                    <t:set var="usado" scope = "page" value="${true}"/>
                                </t:if>
                            </t:forEach>
                            <t:if test="${usado}">
                                <label class="w-100 mb-0"><input type="checkbox" name="categorias[]" checked value="${categoria.idCategoria}"> ${categoria.nome}</label>
                            </t:if>
                             <t:if test="${!usado}">
                                <label class="w-100 mb-0"><input type="checkbox" name="categorias[]" value="${categoria.idCategoria}"> ${categoria.nome}</label>
                            </t:if>
                        </t:forEach>
                    </div>
                </div><!-- form-group -->

                <div class="form-group row mb-0">
                    <div class="col-4">
                        <label class="scol-sm-2 col-form-label bold">Acessórios:</label>
                    </div>

                    <div class="col-8">
                        <t:forEach items="${acessorios}" var="acessorio">
                            <t:set var="usado"  scope="page" value="${false}"/>
                            <t:forEach  items="${acessoriosUsados}" var="acessorioUsado">
                                <t:if test="${acessorio.idAcessorio == acessorioUsado.idAcessorio}">
                                    <t:set var="usado" scope = "page" value="${true}"/>
                                </t:if>
                               
                            </t:forEach>
                            <t:if test="${usado}">
                                <label class="w-100 mb-0"><input type="checkbox" name="acessorios[]" checked value="${acessorio.idAcessorio}"> ${acessorio.descricao}</label>
                            </t:if>
                            <t:if test="${!usado}">
                                <label class="w-100 mb-0"><input type="checkbox" name="acessorios[]"  value="${acessorio.idAcessorio}"> ${acessorio.descricao}</label>
                            </t:if>
                        </t:forEach>
                    </div>
                </div><!-- form-group -->
            </div>            
        </div>

        <div id="options-usage" style="<t:if test="${motocicleta.proprietario.idProprietario == null}">display:none;</t:if>">
                <hr>
                <div class="row">
                    <div class="col-md-6">

                        <div class="form-group row">
                            <div class="col-4">
                            <form:label path="renavam" cssClass="scol-sm-2 col-form-label bold">Renavam:</form:label>
                            </div>

                            <div class="col-8">
                            <form:input path="renavam" type="number" cssClass="form-control ${renavam}" placeholder="Digite o renavam..."/>
                            <div class="invalid-feedback">Preencha o renavam</div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-4">
                            <form:label path="placa" cssClass="scol-sm-2 col-form-label bold">Placa: <span class="required">*</span></form:label>
                            </div>

                            <div class="col-8">
                            <form:input path="placa" cssClass="form-control ${placa}" placeholder="Digite a placa..."/>
                            <div class="invalid-feedback">Preencha a placa</div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-4">
                            <form:label path="valorIPVA" cssClass="scol-sm-2 col-form-label bold">Valor do IPVA: <span class="required">*</span></form:label>
                            </div>
                            <div class="col-8">
                            <form:input path="valorIPVA" cssClass="form-control ${valorIPVA}" placeholder="Digite o valor do IPVA..."/>
                            <div class="invalid-feedback">Preencha o valor do IPVA</div>
                        </div>
                    </div>
                </div><!-- col-md-6 -->
                <div class="col-md-6">
                    <div class="form-group row">
                        <div class="col-4">
                            <form:label path="situacaoIPVA" cssClass="scol-sm-2 col-form-label bold">Situação IPVA: <span class="required">*</span></form:label>
                            </div>

                            <div class="col-8">
                            <form:select path="situacaoIPVA" cssClass="form-control">
                                <form:option value="Em dia"/>
                                <form:option value="Atrasado"/>
                            </form:select>
                        </div>
                    </div>
                    <form:input type="hidden" path="situacaoMotocicleta"/>
                    <div class="form-group row">
                        <div class="col-4">
                            <label class="scol-sm-2 col-form-label bold">Proprietario: <span class="required">*</span></label>
                        </div>
                      
                        <div class="col-8">
                            <select class="form-control" name="idProprietario">
                                <t:forEach items="${proprietarios}" var="proprietario">
                                    <t:if test="${proprietario.idProprietario == motocicleta.proprietario.idProprietario}">
                                        <option selected value="${proprietario.idProprietario}" label="${proprietario.nome}"/>
                                    </t:if>
                                    <t:if test="${proprietario.idProprietario != motocicleta.proprietario.idProprietario}">
                                        <option value="${proprietario.idProprietario}" label="${proprietario.nome}"/>
                                    </t:if>
                                </t:forEach>
                            </select> 
                        </div>
                        
                    </div><!-- form-group -->
                </div><!-- col-md-6 -->
            </div><!-- row -->

        </div><!-- options-usage -->
        <form:input path="idMotocicleta" type="hidden" value="${motocicleta.idMotocicleta}"/>
        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Salvar</button>
            </div>
        </div>
        
    </div>
</form:form>
<script type="text/javascript">
    $(document).ready(function () {
        
        
        if($('#nova').is(':checked')) {
            $('#form').attr('action', '/ConcessionariaDeMotocicletas/motocicletas/editarNova');
        }
        
        if($('#usada').is(':checked')) { 
            $('#form').attr('action', '/ConcessionariaDeMotocicletas/motocicletas/editarUsada');
        }   
    });
</script>
<t:import url="../templates/footer.jsp"/>