package atividades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ProdutoServlet")
public class ProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<String> produtos = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String preco = request.getParameter("preco");

        // Adicionar produto à lista
        produtos.add(nome + " - R$ " + preco);

        // Atribuir a lista de produtos ao request
        request.setAttribute("produtos", produtos);

        // Redirecionar de volta para o index.jsp
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
