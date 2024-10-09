package exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/primeiro-servlet")
public class PrimeiroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String valor = request.getParameter("valor");

        request.setAttribute("valorRecebido", valor);
        request.getRequestDispatcher("/segundo-servlet").forward(request, response);
    }
}
