<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="atividade04.Produto" %>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Produto</title>
</head>
<body>
    <h1>Editar Produto</h1>
    <%
        Produto produto = (Produto) request.getAttribute("produto");
        if (produto == null) {
    %>
        <p>Produto não encontrado.</p>
    <%
        } else {
    %>
        <form action="updateProduto" method="post">
            <input type="hidden" name="id" value="<%= produto.getId() %>">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" value="<%= produto.getNome() %>" required>
            <br>
            <label for="preco">Preço:</label>
            <input type="number" step="0.01" name="preco" value="<%= produto.getPreco() %>" required>
            <br>
            <input type="submit" value="Atualizar Produto">
        </form>
    <%
        }
    %>
    <a href="listProduto.jsp">Voltar à lista de produtos</a>
</body>
</html>
