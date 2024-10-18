<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="atividade04.Produto"%>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Produtos</title>
</head>
<body>
    <h1>Lista de Produtos</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Preço</th>
            <th>Ações</th>
        </tr>
        <%
            List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
            if (produtos != null) {
                for (Produto produto : produtos) {
        %>
                    <tr>
                        <td><%= produto.getId() %></td>
                        <td><%= produto.getNome() %></td>
                        <td><%= produto.getPreco() %></td>
                        <td>
                            <a href="editProduto?id=<%= produto.getId() %>">Editar</a>
                            <a href="removeProduto?id=<%= produto.getId() %>">Remover</a>
                        </td>
                    </tr>
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="4">Nenhum produto cadastrado.</td>
                </tr>
        <%
            }
        %>
    </table>
    <a href="formAddProduto.jsp">Adicionar Novo Produto</a>
    <a href="index.jsp">Voltar à página inicial</a>
    
</body>
</html>
