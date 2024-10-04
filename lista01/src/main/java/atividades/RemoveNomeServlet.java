package atividades; // Certifique-se de que este é o pacote correto

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/removeNome") // Verifique se a URL é acessada corretamente
public class RemoveNomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<String> nomes = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        nomes.add("Maria");
        nomes.add("João");
        nomes.add("Ana");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");

        if (nome != null && nomes.contains(nome)) {
            nomes.remove(nome);
        }

        request.setAttribute("nomes", nomes);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
