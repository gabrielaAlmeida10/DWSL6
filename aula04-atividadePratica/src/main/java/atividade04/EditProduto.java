package atividade04;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/editProduto")
public class EditProduto extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);

        ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");
        Produto produtoParaEditar = null;

        // Procurar o produto pelo ID
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtoParaEditar = produto;
                break;
            }
        }

        if (produtoParaEditar != null) {
            request.setAttribute("produto", produtoParaEditar);
            RequestDispatcher dispatcher = request.getRequestDispatcher("formEditProduto.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mensagem", "Produto não encontrado.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("listProduto.jsp");
            dispatcher.forward(request, response);
        }
    }
}
