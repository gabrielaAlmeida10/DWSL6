<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="atividade04.Produto"%>

<!DOCTYPE html>
<html>
<head>
    <title>Produtos Comprados</title>
</head>
<body>
    <h1>Produtos Comprados por <%= request.getAttribute("clienteNome") %></h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Preço</th>
            <th>Ação</th>
        </tr>
        <%
            List<Produto> produtosComprados = (List<Produto>) request.getAttribute("produtosComprados");
            if (produtosComprados != null && !produtosComprados.isEmpty()) {
                for (Produto produto : produtosComprados) {
        %>
                    <tr>
                        <td><%= produto.getId() %></td>
                        <td><%= produto.getNome() %></td>
                        <td>R$<%= produto.getPreco() %></td>
                        <td><a href="removerProdutoDoCliente?clienteId=<%= request.getAttribute("clienteId") %>&produtoId=<%= produto.getId() %>">Remover</a></td>
                    </tr>
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="4">Nenhum produto associado.</td>
                </tr>
        <%
            }
        %>
    </table>
        <a href="index.jsp">Voltar à página inicial</a>
    
</body>
</html>
