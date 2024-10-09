package exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebServlet("/cookie-signIn-servlet")
public class CookieSignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");

        Cookie cookie = new Cookie("usuario", nome);

        response.addCookie(cookie);

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Bem-vindo, " + nome + "! O cookie foi salvo com sucesso.</h2>");
        response.getWriter().println("<a href='show-cookie-servlet'>Clique aqui para ver o cookie</a>");
        response.getWriter().println("</body></html>");
    }
}
