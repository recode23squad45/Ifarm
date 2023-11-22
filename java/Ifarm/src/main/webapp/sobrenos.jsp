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
                    <h1 id="h1" class="mb-4 text-center">
                        Cooperativa Rural Ifarm
                    </h1>
                    <p id="h1" class="mb-2 text-center">Unindo forças para um campo mais forte.</p>
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
                <h1 class="text-center mb-4">Sobre a Cooperativa iFarm</h1>
                <p>Bem-vindo a Cooperativa iFarm, onde a colaboração e o crescimento sustentavel são os pilares que impulsionam nossa comunidade agrícola...</p>
                <p><p>Nossa missão é simples, mas impactante: fomentar o desenvolvimento agrícola de maneira integrada e consciente, impulsionando o sucesso de nossos agricultores e enriquecendo nossa comunidade...</p>
<p>Acreditamos na força da união e na partilha de conhecimento. Na Cooperativa iFarm, valorizamos a ética, o respeito ao meio ambiente e a busca incessante por métodos agrícolas sustentáveis...</p>
<p>Ao fazer parte da iFarm, você não está apenas se tornando membro de uma cooperativa; está se tornando parte de uma família que prospera junto...</p>
<p>Convidamos você a se juntar a nós nesta jornada de crescimento, aprendizado e realização. Seja você um agricultor experiente, um entusiasta da agricultura sustentável ou alguém que valoriza produtos locais de qualidade, a iFarm é o lugar
    onde você pertence...</p>
<p>Obrigado por visitar a Cooperativa iFarm e fazer parte do nosso movimento de transformação agrícola.</p>
</p>
                <p class="text-center">Equipe iFarm</p>
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