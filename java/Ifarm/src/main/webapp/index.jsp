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
                    <p id="h1" class="mb-2 text-center">Unindo forças para um campo mais forte.</p>
                </div>
            </div>
        </div>
    </header>

    <%@ include file="menu.jsp" %>

    <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="imagem/fundo4.jpeg" id="imgSlide" class="d-block w-100 img-fluid" alt="Imagem Rural">
                <div class="carousel-caption position-absolute top-0 start-50 translate-middle-x">
                    <a href="sobrenos.jsp" style="text-decoration: none; color: inherit;">
                        <h2 id="h2" class="mb-3 desktop-font" style="text-shadow: 2px -2px 4px rgba(1, 1, 1, 1);">Venha conhecer a Ifarm.</h2>
                    </a>

                </div>
            </div>
            <div class="carousel-item">
                <img src="imagem/fundo3.jpeg" id="imgSlide" class="d-block w-100 img-fluid" alt="Outra Imagem">
                <div class="carousel-caption position-absolute top-0 start-50 translate-middle-x">
                    <a href="produtos.jsp" style="text-decoration: none; color: inherit;">
                        <h2 id="h2" class="mb-3 desktop-font" style="margin-top: -130px; text-shadow: 2px -2px 4px rgba(1, 1, 1, 1);">Produção Ifarm!
                        </h2>
                    </a>
                    <p id="p" style="text-shadow: 2px 2px 5px rgba(1, 1, 1, 1); color: rgb(255, 255, 255);">Venha conferir nossos produtos </p>
                </div>
            </div>
        </div>






        <a class="carousel-control-prev" href="#carouselExample" role="button" data-bs-slide="prev">
            <span class="carousel-control-prev-icon custom-icon" aria-hidden="true"></span>
        </a>
        <a class="carousel-control-next" href="#carouselExample" role="button" data-bs-slide="next">
            <span class="carousel-control-next-icon custom-icon" aria-hidden="true"></span>
        </a>
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