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

        StringBuilder stringText1 = new StringBuilder();
        StringBuilder stringText2 = new StringBuilder();

        stringText1.append("Total de vertices ").append(grafo.countVertices());
        stringText2.append("Total de Arestas: ").append(grafo.countArestas());

        TextView texto1 = (TextView) findViewById(R.id.text1);
        TextView texto2 = (TextView) findViewById(R.id.text2);
        texto1.setText(stringText1);
        texto2.setText(stringText2);

    }
}
