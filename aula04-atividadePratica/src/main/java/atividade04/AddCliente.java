package atividade04;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/addCliente")
public class AddCliente extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        // Lógica para adicionar o cliente na lista
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) getServletContext().getAttribute("clientes");
        if (clientes == null) {
            clientes = new ArrayList<>();
            getServletContext().setAttribute("clientes", clientes);
        }

        Cliente novoCliente = new Cliente(nome); // O ID será gerado automaticamente
        clientes.add(novoCliente);

        // Redirecionar para a lista de clientes
        response.sendRedirect("listCliente");
    }
}

