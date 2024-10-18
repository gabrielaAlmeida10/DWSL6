<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="atividade04.Cliente" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Cliente</title>
</head>
<body>
    <h1>Editar Cliente</h1>
    <%
        Cliente cliente = (Cliente) request.getAttribute("cliente");
        if (cliente == null) {
    %>
        <p>Cliente não encontrado.</p>
    <%
        } else {
    %>
        <form action="updateCliente" method="post">
            <input type="hidden" name="id" value="<%= cliente.getId() %>">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" value="<%= cliente.getNome() %>" required>
            <input type="submit" value="Atualizar Cliente">
        </form>
    <%
        }
    %>
    <a href="listCliente">Voltar à lista de clientes</a>
</body>
</html>
