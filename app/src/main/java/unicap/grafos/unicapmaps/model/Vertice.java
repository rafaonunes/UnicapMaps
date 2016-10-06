package unicap.grafos.unicapmaps.model;

import java.util.ArrayList;

/**
 * Created by Cais Automação on 06/10/2016. project Unicap Maps
 */
public class Vertice {
    private int id;
    private String nome;
    private String descricao;
    private ArrayList<Aresta> arestas = null;
    private ArrayList<Vertice> adjacentes = null;

    public Vertice(int id) {
        this.id = id;
    }

    public void addAdjacente(Vertice novoAdj) {
        adjacentes.add(novoAdj);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void addAresta(Aresta aresta) {
        arestas.add(aresta);
    }
}
