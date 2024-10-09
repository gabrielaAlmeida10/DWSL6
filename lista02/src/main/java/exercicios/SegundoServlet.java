package exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/segundo-servlet")
public class SegundoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String valorRecebido = (String) request.getAttribute("valorRecebido");

        request.setAttribute("valorProcessado", valorRecebido);

        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
