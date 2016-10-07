package unicap.grafos.unicapmaps.controller;


import android.content.Context;

import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;

/**
 * Created by Cais Automação on 06/10/2016. project UnicapMaps
 */

public class GrafoController {

    public GrafoController(){

    }

    public StringBuilder exibirArestas(Grafo grafo){
        StringBuilder lista = new StringBuilder();
        for(Aresta aresta: grafo.getArestas()){
            lista.append(aresta.getA().getId());
            lista.append(" -> ");
            lista.append(aresta.getB().getId());
            lista.append('\n');
        }
        return lista;

    }
}
