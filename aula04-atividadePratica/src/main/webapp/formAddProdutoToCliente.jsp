<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="atividade04.Cliente"%>
<%@ page import="atividade04.Produto"%>

<!DOCTYPE html>
<html>
<head>
    <title>Adicionar Produto ao Cliente</title>
</head>
<body>
    <h1>Associar Produto a Cliente</h1>
    
    <form action="addProdutoToCliente" method="post">
        <label for="clienteId">Escolha o Cliente:</label>
        <select name="clienteId" required>
            <%
                List<Cliente> clientes = (List<Cliente>) application.getAttribute("clientes");
                if (clientes != null) {
                    for (Cliente cliente : clientes) {
            %>
                        <option value="<%= cliente.getId() %>"><%= cliente.getNome() %></option>
            <%
                    }
                } else {
            %>
                    <option value="">Nenhum cliente cadastrado</option>
            <%
                }
            %>
        </select>
        
        <label for="produtoId">Escolha o Produto:</label>
        <select name="produtoId" required>
            <%
                List<Produto> produtos = (List<Produto>) application.getAttribute("produtos");
                if (produtos != null) {
                    for (Produto produto : produtos) {
            %>
                        <option value="<%= produto.getId() %>"><%= produto.getNome() %> - R$<%= produto.getPreco() %></option>
            <%
                    }
                } else {
            %>
                    <option value="">Nenhum produto cadastrado</option>
            <%
                }
            %>
        </select>
        
        <input type="submit" value="Associar Produto">
    </form>
</body>
</html>
