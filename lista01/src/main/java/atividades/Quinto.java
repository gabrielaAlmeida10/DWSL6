package atividades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/addName") 
public class Quinto extends HttpServlet {
    
    // ArrayList para armazenar os nomes
    private ArrayList<String> nomes = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Captura o parâmetro "nome" da URL
        String nome = request.getParameter("nome");
        
        // Se o nome não for nulo, adiciona ao ArrayList
        if (nome != null && !nome.isEmpty()) {
            nomes.add(nome);
        }

        // Define o tipo de conteúdo da resposta
        response.setContentType("text/html");
        
        // Obtem o PrintWriter para escrever a resposta
        PrintWriter out = response.getWriter();
        
        // Escreve a mensagem na resposta
        out.println("<html><body>");
        out.println("<h1>Nomes Armazenados:</h1>");
        out.println("<ul>");
        
        // Exibe todos os nomes armazenados
        for (String n : nomes) {
            out.println("<li>" + n + "</li>");
        }
        
        out.println("</ul>");
        out.println("<a href='index.jsp'>Voltar</a>");
        out.println("</body></html>");
    }
}
