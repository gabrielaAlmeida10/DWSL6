package atividade04;

import java.util.ArrayList;

public class Cliente {
    private static int contador = 0; // Contador estático para gerar IDs únicos
    private int id;
    private String nome;
    private ArrayList<Produto> listaCompras; // Lista de produtos comprados


    public Cliente(String nome) {
        this.id = ++contador; // Incrementa o contador e atribui o ID
        this.nome = nome;
        this.listaCompras = new ArrayList<>();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public ArrayList<Produto> getListaCompras() {
        return listaCompras;
    }

    public void adicionarProduto(Produto produto) {
        this.listaCompras.add(produto);
    }

    public void removerProduto(int produtoId) {
        listaCompras.removeIf(produto -> produto.getId() == produtoId);
    }
}
