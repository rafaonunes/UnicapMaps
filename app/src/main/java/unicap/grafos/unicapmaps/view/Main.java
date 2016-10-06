package unicap.grafos.unicapmaps.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.model.Grafo;

public class Main extends AppCompatActivity {

    private Grafo grafo = Grafo.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView texto1 = (TextView) findViewById(R.id.text1);
        TextView texto2 = (TextView) findViewById(R.id.text2);
        texto1.setText("Total de Vertices: " + grafo.countVertices());
        texto1.setText("Total de Arestas: " + grafo.countArestas());

    }
}
