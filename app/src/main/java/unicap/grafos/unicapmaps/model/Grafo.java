package unicap.grafos.unicapmaps.model;

import java.util.ArrayList;

/**
 * Created by Cais Automação on 06/10/2016. project UnicapMaps
 */

public class Grafo {
    private ArrayList<Vertice> vertices = null;
    private ArrayList<Aresta> arestas = null;

    private static Grafo grafo = null;

    private Grafo() {
        grafo = new Grafo();
    }

    public static Grafo getInstance(){
        if(grafo == null){
            grafo = new Grafo();
        }
        return grafo;
    }


    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public Vertice getVertice(int i) {
        return vertices.get(i);
    }

    public void addVertice(Vertice novoVertice) {
        vertices.add(novoVertice);
    }

    public Aresta addAresta(Vertice v1, Vertice v2) {
        Aresta novaAresta = new Aresta(v1, v2);
        novaAresta.setId(arestas.size());
        arestas.add(novaAresta);
        return novaAresta;
    }

    public int countVertices() {
        return vertices.size();
    }

    public int countArestas() {
        return arestas.size();
    }
}
