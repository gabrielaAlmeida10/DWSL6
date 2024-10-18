package atividade04;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/addProduto")
public class AddProduto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String precoStr = request.getParameter("preco");
        double preco;

        // Validação do preço
        try {
            preco = Double.parseDouble(precoStr);
        } catch (NumberFormatException e) {
            request.setAttribute("mensagem", "Preço inválido.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("formAddProduto.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Gerar um ID único
        ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");
        int id = produtos != null ? produtos.size() + 1 : 1; // Incrementa o ID

        Produto novoProduto = new Produto(id, nome, preco);

        if (produtos == null) {
            produtos = new ArrayList<>();
        }
        produtos.add(novoProduto);
        getServletContext().setAttribute("produtos", produtos);

        // Redirecionar para a lista de produtos
        response.sendRedirect("listProduto");
    }
}
