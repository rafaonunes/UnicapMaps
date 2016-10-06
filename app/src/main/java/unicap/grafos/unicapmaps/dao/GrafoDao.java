package unicap.grafos.unicapmaps.dao;

import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by Cais Automação on 06/10/2016. project Unicap Maps
 */
public class GrafoDao {

    private Grafo grafo;
    private int matrizAdjacencias[][] = {
          // A B C D E F G H I J K L M N O P Q R S T U V W
            {0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0}, //A
            {1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0}, //B
            {0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0}, //C
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //D
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0}, //E
            {0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,1,1,0,0,0}, //F
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0}, //G
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0}, //H = Capela
            {0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0}, //I
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //J
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1}, //K
            {0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1}, //L
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0}, //M = Biblioteca
            {0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0}, //N
            {0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0}, //O
            {1,1,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0}, //P = Estacionamento professores
            {0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0}, //Q
            {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0}, //R
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //S = Estacionamento estudantes
            {1,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,1,0,0,0,0,0}, //T
            {1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0}, //U = Quadra de esportes
            {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0}, //V = Jardim dos patos
            {0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0}  //W
          // A B C D E F G H I J K L M N O P Q R S T U V W
    };
    private int grauMatriz = matrizAdjacencias[0].length;


    public GrafoDao( ) {

    }

    public void montarGrafo(){
        grafo = Grafo.getInstance();
        criarVertices();
        estabelecerAdjacencias();
    }

    private void estabelecerAdjacencias() {
        int i;
        int id;
        Vertice adj;
        Aresta aresta;

        //verifica cada vertice se tem adjacencias, a partir da matriz de adjacencias
        for(Vertice atual: grafo.getVertices()){
            id = atual.getId();
            for(i = 0; i < grauMatriz; i++){
                if(matrizAdjacencias[id][i] == 1){ //se tiver adjacencia, o "i" é o id do vértice adjacente
                    //busca o vertice pelo id "i" e adiciona como adjacente no Vertice atual
                    adj = grafo.getVertice(i);
                    atual.addAdjacente(adj);

                    //cria aresta direcionada e adiciona tanto no grafo quanto no vertice
                    aresta = grafo.addAresta(atual, adj);
                    atual.addAresta(aresta);
                }
            }
        }
    }

    private void criarVertices(){
        //criar vértices
        int i;
        for(i = 0; i < grauMatriz; i++){
            Vertice novo = new Vertice(i);
            //novo.setNome(nomes[i]);
            //novo.setDescricao(descricoes[i]);
            grafo.addVertice(novo);
        }
    }


}

