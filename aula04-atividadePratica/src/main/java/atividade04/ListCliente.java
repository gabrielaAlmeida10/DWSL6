package atividade04;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class ListCliente
 */
@WebServlet("/listCliente")
public class ListCliente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) getServletContext().getAttribute("clientes");

        // Criar uma lista de Maps para passar os dados dos clientes
        List<Map<String, Object>> clienteData = new ArrayList<>();
        for (Cliente cliente : clientes) {
            Map<String, Object> data = new HashMap<>();
            data.put("id", cliente.getId());
            data.put("nome", cliente.getNome());
            clienteData.add(data);
        }

        request.setAttribute("clientes", clienteData);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listCliente.jsp");
        dispatcher.forward(request, response);
    }
}

