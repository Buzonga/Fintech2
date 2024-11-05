<!DOCTYPE html>
<html lang="pt-br">
<%@ include file="header.jsp" %>

<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4 display-4">Fintech</h1>
        <h4 class="display-6 text-center">Deseja controlar suas despesas? Registre-se</h2>

        <form action="#" method="post" id="registerForm">
            <div class="mb-3">
                <label for="nome" class="form-label">Nome:</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">E-mail:</label>
                <input type="email" id="email" name="email" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="senha" class="form-label">Senha:</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="confirmar senha" class="form-label">Senha:</label>
                <input type="password" id="password" name="cPassword" class="form-control" required>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </div>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
