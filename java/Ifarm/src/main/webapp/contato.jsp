<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>iFarm - Cooperativa Rural</title>
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
                    <p id="h1" class="mb-2 text-center">Unindo forÃ§as para um campo mais forte.</p>
                    </p>
                </div>
            </div>
        </div>
    </header>

    <%@ include file="menu.jsp" %>
    
    <div class="mb-4"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-8 mx-auto">
                <h1 class="text-center mb-4">Entre em Contato</h1>
                <p>Tem alguma dÃºvida ou interesse em saber mais sobre a Cooperativa iFarm? Ficaremos felizes em ajudar! Preencha o formulÃ¡rio abaixo ou use os dados de contato para nos alcanÃ§ar:</p>

                <form>
                    <div class="form-group">
                        <label for="nome">Nome:</label>
                        <input type="text" class="form-control" id="nome" required>
                    </div>
                    <div class="form-group">
                        <label for="email">E-mail:</label>
                        <input type="email" class="form-control" id="email" required>
                    </div>
                    <div class="form-group">
                        <label for="mensagem">Mensagem:</label>
                        <textarea class="form-control" id="mensagem" rows="5" required></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>

                <p class="mt-3">VocÃª tambÃ©m pode nos contatar atravÃ©s do e-mail: <a href="mailto:contato@ifarmcoop.com">contato@ifarmcoop.com</a></p>
            </div>
        </div>
    </div>

    <footer class="bg-dark text-white text-center py-2">
        <p>&copy; 2023 Cooperativa Rural Ifarm</p>
    </footer>
    <!-- Adicionar o script do Bootstrap no final do body para habilitar funcionalidades -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>