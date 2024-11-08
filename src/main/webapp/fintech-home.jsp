<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp" %>
<html lang="pt-br">

<body>
    <div class="container mt-5">
        <h1>Bem-vindo ao seu Painel de Finanças</h1>

        <div class="card mb-4">
            <div class="card-header">
                <h4>Informações do Usuário</h4>
            </div>
            <div class="card-body">
                <p><strong>Nome de Usuário:</strong> ${username} </p>
                <p><strong>Email:</strong> ${email}</p>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">
                <h4>Saldo Total</h4>
            </div>
            <div class="card-body">
                <h2>
                    <span class="${balance >= 0 ? 'text-success' : 'text-danger'}">
                        R$ ${balance != null ? balance : '0,00'}
                    </span>
                </h2>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">
                <h4>Entradas</h4>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">
                <h4>Saídas</h4>
            </div>
        </div>

        <div class="mt-4">
            <a href="createTransaction.jsp" class="btn btn-primary">Criar Transação</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
