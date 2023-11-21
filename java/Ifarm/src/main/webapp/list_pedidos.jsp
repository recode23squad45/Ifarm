<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listagem de Pedidos - iFarm</title>
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
        <h1 class="text-center mb-4">Listagem de Pedidos</h1>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Data de Entrega</th>
                    <th>Tipo de Pedido</th>
                    <th>Status</th>
                    <th>Valor Total</th>
                    <th>CNPJ do Cliente</th>
                    <th>Lista de Produtos</th>
                    <th colspan="2">Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="pedido" items="${pedidos}">
                    <tr>
                        <td>${pedido.idPedido}</td>
                        <td>${pedido.dtEntrega}</td>
                        <td>${pedido.tipoPedido}</td>
                        <td>${pedido.status}</td>
                        <td>${pedido.valorTotal}</td>
                        <td>${pedido.cnpjCliente}</td>
                        <td>
                            <ul>
                                <c:forEach var="produto" items="${pedido.listaProdutos}">
                                    <li>${produto.nomeProduto}</li>
                                </c:forEach>
                            </ul>
                        </td>
                        <td>
                        	<a class="btn btn-info" href="/Ifarm/produtos_pedidos?idPedido=${pedido.idPedido}" role="button">+ Produto</a>
                        </td>
                        <td>
                        	<form action="/Ifarm/pedidos?delete=${pedido.idPedido}" method="post">
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
