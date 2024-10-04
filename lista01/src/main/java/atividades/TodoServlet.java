package atividades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todo")
public class TodoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private List<String> tarefas = new ArrayList<>();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tarefa = request.getParameter("tarefa");
        if (tarefa != null && !tarefa.isEmpty()) {
            tarefas.add(tarefa);
        }
        request.setAttribute("tarefas", tarefas);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tarefas", tarefas);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
