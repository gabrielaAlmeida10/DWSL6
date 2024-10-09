package exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/welcome-servlet")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtém a sessão existente (sem criar uma nova)
        HttpSession sessao = request.getSession(false);

        if (sessao != null && sessao.getAttribute("usuario") != null) {
            // Exibe o nome do usuário armazenado na sessão
            String nomeUsuario = (String) sessao.getAttribute("usuario");

            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h2>Bem-vindo, " + nomeUsuario + "!</h2>");
            response.getWriter().println("<a href='logout-servlet'>Logout</a>");
            response.getWriter().println("</body></html>");
        } else {
            // Se não houver sessão, redireciona para a página de login
            response.sendRedirect("signIn.html");
        }
    }
}
