package atividade04;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class EditCliente
 */
@WebServlet("/editCliente")
public class EditCliente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");

        // Tratamento para verificar se o ID é válido
        if (idStr == null || idStr.isEmpty()) {
            request.setAttribute("mensagem", "ID do cliente não fornecido.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("listCliente.jsp");
            dispatcher.forward(request, response);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            request.setAttribute("mensagem", "ID inválido.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("listCliente.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Obter a lista de clientes do contexto
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) getServletContext().getAttribute("clientes");

        // Verificar se a lista de clientes foi inicializada
        if (clientes == null) {
            clientes = new ArrayList<>();
            getServletContext().setAttribute("clientes", clientes);
        }

        Cliente clienteParaEditar = null;

        // Procurar o cliente pelo ID
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clienteParaEditar = cliente;
                break;
            }
        }

        if (clienteParaEditar != null) {
            request.setAttribute("cliente", clienteParaEditar);
            RequestDispatcher dispatcher = request.getRequestDispatcher("formEditCliente.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mensagem", "Cliente não encontrado.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("listCliente.jsp");
            dispatcher.forward(request, response);
        }
    }
}
