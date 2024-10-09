package exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout-servlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtém a sessão existente e a invalida
        HttpSession sessao = request.getSession(false);
        if (sessao != null) {
            sessao.invalidate(); // Invalida a sessão
        }

        // Redireciona para a página de login
        response.sendRedirect("signIn.html");
    }
}
