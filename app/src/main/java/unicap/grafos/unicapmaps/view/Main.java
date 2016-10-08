package unicap.grafos.unicapmaps.view;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Grafo;

public class Main extends AppCompatActivity {

    private Float escala = 1f;
    private ScaleGestureDetector detectorGestos;
    private RelativeLayout mapaView;
    private Grafo grafo = Grafo.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GrafoController gController = new GrafoController();

        mapaView = (RelativeLayout) findViewById(R.id.mapaView);
        detectorGestos = new ScaleGestureDetector(this, new ScaleListener());

        StringBuilder stringText1 = new StringBuilder();
        StringBuilder stringText2 = new StringBuilder();

        stringText1.append("Total de vertices ").append(grafo.countVertices());
        stringText2.append("Total de Arestas: ").append(grafo.countArestas());

        TextView texto1 = (TextView) findViewById(R.id.text1);
        TextView texto2 = (TextView) findViewById(R.id.text2);
        TextView texto3 = (TextView) findViewById(R.id.text3);
        texto1.setText(stringText1);
        texto2.setText(stringText2);
        texto3.setText(gController.exibirArestas(grafo));
    }


    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            escala = escala * detector.getScaleFactor();
            escala = Math.max(0.1f, Math.min(escala, 5f));
            ScaleAnimation scaleAnimation = new ScaleAnimation(1f / escala, 1f / escala, 1f / escala, 1f / escala, detector.getFocusX(), detector.getFocusY());
            scaleAnimation.setDuration(0);
            scaleAnimation.setFillAfter(true);
            mapaView.startAnimation(scaleAnimation);
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detectorGestos.onTouchEvent(event);
        return true;
    }
}
