package atividade04;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/updateProduto")
public class UpdateProduto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String precoStr = request.getParameter("preco");
        double preco;

        int id = Integer.parseInt(idStr);

        // Validação do preço
        try {
            preco = Double.parseDouble(precoStr);
        } catch (NumberFormatException e) {
            request.setAttribute("mensagem", "Preço inválido.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("formEditProduto.jsp");
            dispatcher.forward(request, response);
            return;
        }

        ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");

        if (produtos != null) {
            for (Produto produto : produtos) {
                if (produto.getId() == id) {
                    produto.setNome(nome);
                    produto.setPreco(preco);
                    break;
                }
            }
        }

        response.sendRedirect("listProduto");
    }
}
