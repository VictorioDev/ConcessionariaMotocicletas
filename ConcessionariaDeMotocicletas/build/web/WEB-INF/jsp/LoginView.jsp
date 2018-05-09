<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<t:url value="/resources/bootstrap.min.css" />" />
        <link rel="stylesheet" type="text/css" href="<t:url value="/resources/open-iconic/font/css/open-iconic.css" />" />
        <link rel="stylesheet" type="text/css" href="<t:url value="/resources/style.css" />" />
        <title>Sistema de Concessionária</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4 offset-4 text-center mt-4 pt-4">
                    <h4>Login:</h4>
                    <p>Informe seu e-mail e sua senha para acessar o painel.</p>
                    
                    <form class="form-login" method="POST" accept-charset="utf-8">
                        <div>
                            <input type="text" name="login" class="form-control ${login}" placeholder="Digite aqui o usuário...">
                            <div class="invalid-feedback">O login está incorreto.</div>
                        </div>
                        <div class="mt-2 mb-2">
                            <input type="password" name="senha" class="form-control ${senha}" placeholder="Digite aqui a senha...">
                            <div class="invalid-feedback">A senha está incorreta.</div>
                        </div>
                        <p><button type="submit" class="btn btn-primary">Acessar <i class="fa fa-sign-in" aria-hidden="true"></i></button></p>
                    </form>
                </div>                
            </div>
        </div>

    </body>
</html>