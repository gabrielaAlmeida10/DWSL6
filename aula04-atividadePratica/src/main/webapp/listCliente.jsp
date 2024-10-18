<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Clientes</title>
</head>
<body>
    <h1>Lista de Clientes</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Ações</th> 
        </tr>
        <%
            List<Map<String, Object>> clientes = (List<Map<String, Object>>) request.getAttribute("clientes");
            if (clientes != null) {
                for (Map<String, Object> cliente : clientes) {
        %>
                    <tr>
				    <td><%= cliente.get("id") %></td>
				    <td><%= cliente.get("nome") %></td>
				    <td>
				        <a href="editCliente?id=<%= cliente.get("id") %>">Editar</a>
				        <form action="removeCliente" method="post" style="display:inline;">
				            <input type="hidden" name="id" value="<%= cliente.get("id") %>"/>
				            <input type="submit" value="Remover" onclick="return confirm('Tem certeza que deseja remover?');"/>
				        </form>
				    </td>
				</tr>
                    
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="3">Nenhum cliente cadastrado.</td>
                </tr>
        <%
            }
        %>
    </table>
    <a href="formAddCliente.html">Adicionar Novo Cliente</a>
    <a href="index.jsp">Voltar à página inicial</a>
</body>
</html>
