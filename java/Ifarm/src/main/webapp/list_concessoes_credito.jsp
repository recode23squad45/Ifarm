<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Concessões de Crédito - iFarm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <header class="py-4">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-auto">
                    <div class="rounded-image">
                        <a href="index.jsp"><img src="imagem/ifarm.png" id="logoImg" alt="Logo Ifarm" class="img-fluid"></a>
                    </div>
                </div>
                <div class="col">
                    <h1 id="h1" class="mb-4 text-center">
                        Cooperativa Rural Ifarm
                    </h1>
                    <p id="h1" class="mb-2 text-center">Unindo forças para um campo mais forte.</p>
                </div>
            </div>
        </div>
    </header>

    <%@ include file="menu.jsp" %>

    <div class="mb-4"></div>

    <div class="container mt-5">
        <h1 class="text-center mb-4">Lista de Concessões de Crédito</h1>
        
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID Concessão</th>
                    <th>Cooperado</th>
                    <th>Empresa Parceira</th>
                    <th>Valor</th>
                    <th>Data de Concessão</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="concessao" items="${requestScope.concessoesCredito}">
                    <tr>
                        <td>${concessao.idConcessao}</td>
                        <td>${concessao.cooperado.nomeCooperado}</td>
                        <td>${concessao.empresaParceira.nomeEmpresa}</td>
                        <td>${concessao.valor}</td>
                        <td>${concessao.dtConcessao}</td>
                        <td>
			                <form action="/Ifarm/concessao_credito?delete=${concessao.idConcessao}" method="post">
		                        <button type="submit" class="btn btn-danger">Excluir</button>
		                    </form>
			            </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <footer class="bg-dark text-white text-center py-2">
        <p>&copy; 2023 Cooperativa Rural Ifarm</p>
    </footer>

    <!-- Adicionar o script do Bootstrap no final do body para habilitar funcionalidades -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
