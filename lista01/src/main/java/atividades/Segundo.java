package atividades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello") 
public class Segundo extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Captura o parâmetro 'nome' da URL
        String nome = request.getParameter("nome");
        
        // Define o tipo de conteúdo da resposta
        response.setContentType("text/html");
        
        // Obtem o PrintWriter para escrever a resposta
        PrintWriter out = response.getWriter();
        
        // Escreve a mensagem na resposta
        out.println("<html><body>");
        out.println("<h1>Olá, " + (nome != null ? nome : "Visitante") + "!</h1>");
        out.println("</body></html>");
    }
}
