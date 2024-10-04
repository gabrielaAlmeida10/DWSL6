package atividades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/access") 
public class Setimo extends HttpServlet {
    
    // HashMap para armazenar o contador de acessos por usuário
    private HashMap<String, Integer> contadorAcessos = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Captura o parâmetro "nome" da URL
        String nome = request.getParameter("nome");

        // Se o nome não for nulo, atualiza o contador de acessos
        if (nome != null && !nome.isEmpty()) {
            contadorAcessos.put(nome, contadorAcessos.getOrDefault(nome, 0) + 1);
        }

        // Define o tipo de conteúdo da resposta
        response.setContentType("text/html");
        
        // Obtem o PrintWriter para escrever a resposta
        PrintWriter out = response.getWriter();
        
        // Escreve a mensagem na resposta
        out.println("<html><body>");
        out.println("<h1>Contador de Acessos:</h1>");
        out.println("<ul>");

        // Exibe o contador de acessos de cada usuário
        for (String usuario : contadorAcessos.keySet()) {
            out.println("<li>" + usuario + ": " + contadorAcessos.get(usuario) + " acessos</li>");
        }

        out.println("</ul>");
        out.println("<a href='index.jsp'>Voltar</a>");
        out.println("</body></html>");
    }
}
