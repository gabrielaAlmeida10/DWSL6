package atividade04;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/removerProdutoDoCliente")
public class RemoveProdutoFromCliente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clienteIdStr = request.getParameter("clienteId");
        String produtoIdStr = request.getParameter("produtoId");
        int clienteId = Integer.parseInt(clienteIdStr);
        int produtoId = Integer.parseInt(produtoIdStr);

        ArrayList<Cliente> clientes = (ArrayList<Cliente>) getServletContext().getAttribute("clientes");
        Cliente cliente = null;

        // Encontrar o cliente pelo ID
        for (Cliente c : clientes) {
            if (c.getId() == clienteId) {
                cliente = c;
                break;
            }
        }

        if (cliente != null) {
            cliente.removerProduto(produtoId); // Remover o produto do cliente
            getServletContext().setAttribute("clientes", clientes); // Atualizar a lista de clientes
            response.sendRedirect("listarProdutosComprados?clienteId=" + clienteId); // Redirecionar para a lista atualizada
        } else {
            request.setAttribute("mensagem", "Cliente ou produto não encontrado.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("listCliente.jsp");
            dispatcher.forward(request, response);
        }
    }
}
