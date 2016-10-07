package unicap.grafos.unicapmaps.model;

import android.hardware.usb.UsbConfiguration;

/**
 * Created by Cais Automação on 06/10/2016. project Unicap Maps
 */
public class Aresta {
    private int id;
    private Vertice A = null;
    private Vertice B = null;
    private int custo;
    private String descricao;
    //private restrições

    public Aresta(Vertice vA, Vertice vB){
        A = vA;
        B = vB;
    }

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
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setA(Vertice a) {
        A = a;
    }

    public void setB(Vertice b) {
        B = b;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public Vertice getA() {
        return A;
    }

    public Vertice getB(){
        return B;
    }
}
