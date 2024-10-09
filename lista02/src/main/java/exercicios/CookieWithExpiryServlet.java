package exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebServlet("/cookie-expiry-servlet")
public class CookieWithExpiryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtém o nome do usuário do formulário
        String nome = request.getParameter("nome");

        // Cria um cookie com o nome do usuário
        Cookie cookie = new Cookie("usuario", nome);

        // Define o tempo de expiração (2 minutos, em segundos)
        cookie.setMaxAge(2 * 60);

        // Adiciona o cookie na resposta
        response.addCookie(cookie);

        // Exibe uma mensagem confirmando a criação e expiração do cookie
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Bem-vindo, " + nome + "! O cookie será expirado em 2 minutos.</h2>");
        response.getWriter().println("<a href='show-cookie-servlet'>Ver Cookie</a>");
        response.getWriter().println("</body></html>");
    }
}
