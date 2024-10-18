package atividade04;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/updateCliente")
public class UpdateCliente extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");

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

        if (clientes != null) {
            for (Cliente cliente : clientes) {
                if (cliente.getId() == id) {
                    cliente.setNome(nome); // Atualiza o nome do cliente
                    break;
                }
            }
        }

        // Redirecionar para a lista de clientes
        response.sendRedirect("listCliente");
    }
}
