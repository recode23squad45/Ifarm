<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>iFarm - Cooperativa Rural</title>
    <!-- Incluindo Bootstrap CSS -->
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
                    <h1 id="h1" class="mb-4 text-center">Cooperativa Rural Ifarm</h1>
                    <p id="h1" class="mb-2 text-center">Unindo forças para um campo mais forte.</p>
                </div>
            </div>
        </div>
    </header>

    <%@ include file="menu.jsp" %>

    <div class="container mt-5">
        <div class="row">
            <div class="col-md-8 mx-auto">
                <h1 class="text-center mb-4">Eventos IFarm</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="card mb-4">
                    <img src="imagem/force.jpg" class="card-img-top product-image" alt="Evento 1">
                    <div class="card-body">
                     <h5 class="card-title">Live A Força do Agro</h5>
                        <p class="card-text"> Evento Online: A palestra aborda a capacidade do solo para plantio, destacando fatores como textura, estrutura e composição química, visando otimizar o ambiente para o cultivo de plantas de forma sustentável e produtiva. </p>
                        <a href="#" class="btn btn-success">Saiba mais</a>
                        </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4">
                    <img src="imagem/Agrocampo.jpg" class="card-img-top product-image" alt="Evento 2">
                    <div class="card-body">
                        <h5 class="card-title">Mentores do Agro</h5>
                        <p class="card-text">A palestra dos mentores do agronegócio aborda temas cruciais, combinando estratégias de plantio eficazes com as últimas tendências em comunicação digital. Os participantes serão guiados para integrar práticas agronômicas avançadas.</p>
                        <a href="#" class="btn btn-success">Saiba mais</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4">
                    <img src="imagem/agrodigital.png" class="card-img-top product-image" alt="Evento 3">
                    <div class="card-body">
                        <h5 class="card-title">Palestra Agro Digital</h5>
                        <p class="card-text">A palestra oferece insights sobre estratégias inovadoras, destacando a eficiência no plantio e a relevância da comunicação digital para fortalecer o agronegócio em cenários desafiadores. O foco é na identificação de oportunidades...</p>
                        <a href="#" class="btn btn-success">Saiba mais</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer class="bg-dark text-white text-center py-2 ">
        <p>&copy; 2023 Cooperativa Rural Ifarm</p>
    </footer>
    <!-- Adicionar o script do Bootstrap no final do body para habilitar funcionalidades -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
