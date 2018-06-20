<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<t:import url="../templates/header.jsp"/>

<h3 class="title">
    <span class="oi" data-glyph="bar-chart" title="Relatórios" aria-hidden="true"></span> Relatórios
</h3>

<form method="POST">
    <div class="row">
        <div class="col-md-2">
            <label class="bold">Tipo de relatório:</label>
        </div><!-- col-md-6 -->
        <div class="col-md-10">
            <label class="mb-0 w-100"><input type="radio" name="tipo" value="vendas" checked> Relatório de vendas</label>
            <label class="mb-0 w-100"><input type="radio" name="tipo" value="pagamentos"> Relatório de pagamentos</label>
            <label class="mb-0 w-100"><input type="radio" name="tipo" value="itens-mais-vendidos"> Relatório de itens mais vendidos</label>
            <label class="mb-0 w-100"><input type="radio" name="tipo" value="estoque"> Relatório de consulta de estoque</label>
            <label class="mb-0 w-100"><input type="radio" name="tipo" value="logs"> Relatório de logs</label>
        </div><!-- col-md-6 -->
    </div>

    <div class="row mt-3">
        <div class="col-md-2">
            <label class="bold">Filtro:</label>
        </div>
        <div class="col-md-10">
            <input type="date" name="dataInicio" class="form-control w-50">
            <input type="date" name="dataFinal" class="form-control w-50">
            <small class="form-text text-muted mb-2">Deixe em branco para filtrar desde o início ou até o fim.</small>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <button class="btn btn-primary">Visualizar</button>
        </div>
    </div>
</form>

<t:import url="../templates/footer.jsp"/>