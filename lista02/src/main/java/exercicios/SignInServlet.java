package exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/signIn-servlet")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtém o nome do formulário
        String nome = request.getParameter("nome");

        // Cria ou obtém a sessão do usuário
        HttpSession sessao = request.getSession();

        // Armazena o nome do usuário na sessão
        sessao.setAttribute("usuario", nome);

        // Redireciona para o servlet de boas-vindas
        response.sendRedirect("welcome-servlet");
    }
}
