package atividade04;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/listProdutosComprados")
public class ListProdutosComprados extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clienteIdStr = request.getParameter("clienteId");
        int clienteId = Integer.parseInt(clienteIdStr);

        ArrayList<Cliente> clientes = (ArrayList<Cliente>) getServletContext().getAttribute("clientes");
        Cliente cliente = null;

        // Procurar cliente pelo ID
        for (Cliente c : clientes) {
            if (c.getId() == clienteId) {
                cliente = c;
                break;
            }
        }

        if (cliente != null) {
            request.setAttribute("cliente", cliente);  // Passa o cliente para o JSP
            request.setAttribute("produtosComprados", cliente.getListaCompras()); // A chamada correta
            RequestDispatcher dispatcher = request.getRequestDispatcher("listProdutosComprados.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mensagem", "Cliente não encontrado.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("listCliente.jsp");
            dispatcher.forward(request, response);
        }
    }
}

