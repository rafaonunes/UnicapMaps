package unicap.grafos.unicapmaps.model;

/**
 * Created by Cais Automação on 06/10/2016.
 */
public class Aresta {
    private int id;
    private Vertice A;
    private Vertice B;
    private int custo;
    private String descicaoAB;
    private String descricaoBA;

    //private restrições

    private Vertice getAdjacente(Vertice vertice){
        if(vertice == null){
            //exceção
            return null;
        }else{
            if(vertice == A){
                return B;
            }else{
                return A;
            }
        }
    }
}
