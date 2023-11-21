<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Cooperado - iFarm</title>
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

    <div class="container mt-5">
        <div class="title-container">
            <h1 class="text-center mb-4">Cadastro de Produto no Pedido: ${requestScope.idPedido}</h1>
        </div>

        <form action="/Ifarm/produtos_pedidos" method="post">
            <!-- Adicione os campos do formulário -->
            <div class="mb-3">
                <label for="idPedido" class="form-label">ID do Pedido:</label>
                <input type="text" readonly="readonly" value="${requestScope.idPedido}" class="form-control" id="idPedido" name="idPedido">
            </div>

            <div class="mb-3">
                <label for="idProduto" class="form-label">ID do Produto:</label>
                <input type="text" class="form-control" id="idProduto" name="idProduto" required>
            </div>

            <div class="mb-3">
                <label for="quantidade" class="form-label">Quantidade:</label>
                <input type="text" class="form-control" id="quantidade" name="quantidade" required>
            </div>

            <div class="mb-3">
                <label for="valorTotal" class="form-label">Valor Total:</label>
                <input type="number" class="form-control" id="valorTotal" name="valorTotal" step="0.01" required>
            </div>

            <!-- Botão de envio -->
            <div class="mb-3">
            	<button type="submit" class="btn btn-primary">Salvar Produto no Pedido</button>
            </div>
        </form>
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
