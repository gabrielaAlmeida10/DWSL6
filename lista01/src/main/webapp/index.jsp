<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exerc�cios Aula 02</title>
</head>
<body>
	<h1>Lista 01</h1>
	<div>
		<h2>Exerc�cio 01:</h2>
		<form action="welcome" method="post">
		    <input type="submit" value="Enviar">
		</form>
	</div>
	<br>
	<div>
		<h2>Exerc�cio 02:</h2>
		<form action="hello" method="get">
		    <label for="nome">Nome:</label>
		    <input type="text" id="nome" name="nome">
		    <input type="submit" value="Saudar">
		</form>
	</div>
	<div>
		<h2>Exerc�cio 03:</h2>
		<form action="login" method="post">
	    	<label for="usuario">Usu�rio:</label>
	    	<input type="text" id="usuario" name="usuario">
	   		<input type="submit" value="Login">
		</form>
	</div>
	<div>
		<h2>Exerc�cio 04:</h2>
		<a href="counter">Contador de Acessos</a>
	</div>
	<div>
		<h2>Exerc�cio 05:</h2>
		<form action="addName" method="get">
		    <label for="novoNome">Adicionar Nome:</label>
		    <input type="text" id="novoNome" name="nome">
		    <input type="submit" value="Adicionar">
		</form>
	</div>
	<div>
		<h2>Exerc�cio 06:</h2>
		<form action="addComment" method="post">
		    <label for="comentario">Coment�rio:</label>
		    <textarea id="comentario" name="comentario" rows="4" cols="50"></textarea>
		    <input type="submit" value="Enviar Coment�rio">
		</form>
	</div>
	<div>
		<h2>Exerc�cio 07:</h2>
		<form action="access" method="get">
		    <label for="usuarioNome">Seu Nome:</label>
		    <input type="text" id="usuarioNome" name="nome">
		    <input type="submit" value="Contar Acessos">
		</form>
	</div>
	<div>
		<h2>Exerc�cio 08:</h2>
		<h3>Cadastro de Produtos</h3>
	    <form action="ProdutoServlet" method="post">
	        <label for="nome">Nome do Produto:</label>
	        <input type="text" id="nome" name="nome" required>
	        <br>
	        <label for="preco">Pre�o do Produto:</label>
	        <input type="number" id="preco" name="preco" required step="0.01">
	        <br>
	        <input type="submit" value="Cadastrar Produto">
	    </form>
	    
	    <h3>Produtos Cadastrados:</h3>
	    <ul>
	        <%
	            // Exibindo produtos cadastrados
	            List<String> produtos = (List<String>) request.getAttribute("produtos");
	            if (produtos != null) {
	                for (String produto : produtos) {
	                    out.println("<li>" + produto + "</li>");
	                }
	            }
	        %>
	    </ul>
	</div>
	<div>
	    <h2>Exerc�cio 09: Remover Nome</h2>
	    <form action="removeNome" method="get">
	        <label for="nomeRemover">Nome a Remover:</label>
	        <input type="text" id="nomeRemover" name="nome">
	        <input type="submit" value="Remover">
	    </form>
	    
	    <h3>Nomes Restantes:</h3>
	    <ul>
	        <%
	            List<String> nomes = (List<String>) request.getAttribute("nomes");
	            if (nomes != null) {
	                for (String nome : nomes) {
	                    out.println("<li>" + nome + "</li>");
	                }
	            }
	        %>
	    </ul>
	</div>
	 <div>
        <h2>Exerc�cio 10: Lista de Tarefas</h2>
        <h3>Adicionar Tarefa</h3>
	      <form action="todo" method="post">
		    <label for="tarefa">Nova Tarefa:</label>
		    <input type="text" id="tarefa" name="tarefa">
		    <input type="submit" value="Adicionar Tarefa">
		</form>
		<h3>Tarefas Cadastradas:</h3>
		<ul>
		    <%
		        List<String> tarefas = (List<String>) request.getAttribute("tarefas");
		        if (tarefas != null) {
		            for (String tarefa : tarefas) {
		                out.println("<li>" + tarefa + "</li>");
		            }
		        }
		    %>
		</ul>
    </div>
</body>
</html>
