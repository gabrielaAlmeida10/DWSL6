<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Adicionar Produto</title>
</head>
<body>
    <h1>Adicionar Produto</h1>
    <form action="addProduto" method="post">
        <label for="nome">Nome:</label>
        <input type="text" name="nome" required>
        <br>
        <label for="preco">Preço:</label>
        <input type="number" step="0.01" name="preco" required>
        <br>
        <input type="submit" value="Adicionar Produto">
    </form>
    <a href="listProduto.jsp">Voltar à lista de produtos</a>
    <a href="index.jsp">Voltar à página inicial</a>
</body>
</html>
