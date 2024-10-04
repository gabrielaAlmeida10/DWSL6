package atividades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/addComment")
public class Sexto extends HttpServlet {
    
    // ArrayList para armazenar os comentários
    private ArrayList<String> comentarios = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Captura o parâmetro "comentario" do formulário
        String comentario = request.getParameter("comentario");
        
        // Se o comentário não for nulo, adiciona ao ArrayList
        if (comentario != null && !comentario.isEmpty()) {
            comentarios.add(comentario);
        }

        // Define o tipo de conteúdo da resposta
        response.setContentType("text/html");
        
        // Obtem o PrintWriter para escrever a resposta
        PrintWriter out = response.getWriter();
        
        // Escreve a mensagem na resposta
        out.println("<html><body>");
        out.println("<h1>Comentários Submetidos:</h1>");
        out.println("<ul>");
        
        // Exibe todos os comentários armazenados
        for (String c : comentarios) {
            out.println("<li>" + c + "</li>");
        }
        
        out.println("</ul>");
        out.println("<a href='index.jsp'>Voltar</a>");
        out.println("</body></html>");
    }
}
