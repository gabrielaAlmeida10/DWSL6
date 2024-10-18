package atividade04;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/addProdutoToCliente")
public class AddProdutoToCliente extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clienteIdStr = request.getParameter("clienteId");
        String produtoIdStr = request.getParameter("produtoId");

        // Verificar se os parâmetros foram fornecidos
        if (clienteIdStr == null || produtoIdStr == null) {
            request.setAttribute("mensagem", "Cliente ou produto não selecionado.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("formAddProdutoToCliente.jsp");
            dispatcher.forward(request, response);
            return;
        }

        int clienteId;
        int produtoId;
        try {
            clienteId = Integer.parseInt(clienteIdStr);
            produtoId = Integer.parseInt(produtoIdStr);
        } catch (NumberFormatException e) {
            request.setAttribute("mensagem", "ID inválido.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("formAddProdutoToCliente.jsp");
            dispatcher.forward(request, response);
            return;
        }

        ArrayList<Cliente> clientes = (ArrayList<Cliente>) getServletContext().getAttribute("clientes");
        ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");

        Cliente cliente = null;
        Produto produto = null;

        // Procurar cliente e produto pelo ID
        for (Cliente c : clientes) {
            if (c.getId() == clienteId) {
                cliente = c;
                break;
            }
        }

        for (Produto p : produtos) {
            if (p.getId() == produtoId) {
                produto = p;
                break;
            }
        }

        if (cliente != null && produto != null) {
            cliente.adicionarProduto(produto);
            getServletContext().setAttribute("clientes", clientes);
            response.sendRedirect("listProdutosComprados?clienteId=" + clienteId);
        } else {
            request.setAttribute("mensagem", "Cliente ou produto não encontrado.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("formAddProdutoToCliente.jsp");
            dispatcher.forward(request, response);
        }
    }
}

