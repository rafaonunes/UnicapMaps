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
            {0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0}, //1  A
            {1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0}, //2  B
            {0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0}, //3  C
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //4  D
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0}, //5  E
            {0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,1,1,0,0,0}, //6  F
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0}, //7  G
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0}, //8  H = Capela
            {0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0}, //9  I
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //10 J
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1}, //11 K
            {0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1}, //12 L
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0}, //13 M = Biblioteca
            {0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0}, //14 N
            {0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0}, //15 O
            {1,1,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0}, //16 P = Estacionamento professores
            {0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0}, //17 Q
            {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0}, //18 R
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //19 S = Estacionamento estudantes
            {1,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,1,0,0,0,0,0}, //20 T
            {1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0}, //21 U = Quadra de esportes
            {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0}, //22 V = Jardim dos patos
            {0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0}  //23 W
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

