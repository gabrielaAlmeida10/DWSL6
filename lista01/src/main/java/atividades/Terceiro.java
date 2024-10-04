package atividades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login") 
public class Terceiro extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Captura o parâmetro 'usuario' do formulário
        String usuario = request.getParameter("usuario");
        
        // Define o tipo de conteúdo da resposta
        response.setContentType("text/html");
        
        // Obtem o PrintWriter para escrever a resposta
        PrintWriter out = response.getWriter();
        
        // Escreve a mensagem na resposta
        out.println("<html><body>");
        out.println("<h1>Bem-vindo, " + (usuario != null ? usuario : "Visitante") + "!</h1>");
        out.println("</body></html>");
    }
}
