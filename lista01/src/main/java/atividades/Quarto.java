package atividades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/counter") 
public class Quarto extends HttpServlet {

    private int contador = 0; // Variável para armazenar o número de acessos
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Incrementa o contador a cada acesso
        contador++;
        
        // Define o tipo de conteúdo da resposta
        response.setContentType("text/html");
        
        // Obtem o PrintWriter para escrever a resposta
        PrintWriter out = response.getWriter();
        
        // Escreve a mensagem na resposta
        out.println("<html><body>");
        out.println("<h1>Número de acessos: " + contador + "</h1>");
 
        out.println("<a href='index.jsp'>Voltar</a>");
        out.println("</body></html>");   
    }
}
