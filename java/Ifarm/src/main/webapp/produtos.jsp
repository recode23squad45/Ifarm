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
						<a href="index.jsp"><img src="imagem/ifarm.png" id="logoImg"
							alt="Logo Ifarm" class="img-fluid"></a>
					</div>
				</div>
				<div class="col">
					<h1 id="h1" class="mb-4 text-center">Cooperativa Rural Ifarm</h1>
					<p id="h1" class="mb-2 text-center">Unindo forÃ§as para um
						campo mais forte.</p>
					</p>
				</div>
			</div>
		</div>
	</header>

	<%@ include file="menu.jsp" %>

	<div class="container mt-5">
    <div class="row">
        <div class="col-md-8 mx-auto">
            <h1 class="text-center mb-4">Produtos IFarm</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <div class="card mb-4">
                <img src="imagem/Alface.jpeg" class="card-img-top product-image" alt="Produto 1">
                <div class="card-body">
                    <h5 class="card-title">Produção de Alface crespa.</h5>
                    <p class="card-text"></p>
                    <a href="#" class="btn btn-success">Confira</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card mb-4">
                <img src="imagem/cheiro verde.jpeg" class="card-img-top product-image" alt="Produto 2">
                <div class="card-body">
                    <h5 class="card-title">Produção de Salsa.</h5>
                    <p class="card-text"></p>
                    <a href="#" class="btn btn-success">Confira</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card mb-4">
                <img src="imagem/laranja.jpeg" class="card-img-top product-image" alt="Produto 3">
                <div class="card-body">
                    <h5 class="card-title">Produção de Laranja.</h5>
                    <p class="card-text"></p>
                    <a href="#" class="btn btn-success">Confira</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card mb-4">
                <img src="imagem/beterraba.png" class="card-img-top product-image" alt="Produto 4">
                <div class="card-body">
                    <h5 class="card-title">Produção de beterraba.</h5>
                    <p class="card-text"></p>
                    <a href="#" class="btn btn-success">Confira</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card mb-4">
                <img src="imagem/melancia.jpeg" class="card-img-top product-image" alt="Produto 5">
                <div class="card-body">
                    <h5 class="card-title">Produção de melancia.</h5>
                    <p class="card-text"></p>
                    <a href="#" class="btn btn-success">Confira</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card mb-4">
                <img src="imagem/cenoura.jpeg" class="card-img-top product-image" alt="Produto 6">
                <div class="card-body">
                    <h5 class="card-title">Produção de cenoura.</h5>
                    <p class="card-text"></p>
                    <a href="#" class="btn btn-success">Confira</a>
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