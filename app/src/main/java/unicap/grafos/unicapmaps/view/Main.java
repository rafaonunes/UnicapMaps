package unicap.grafos.unicapmaps.view;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Grafo;

public class Main extends AppCompatActivity {

    private Grafo grafo = Grafo.getInstance();
    GestureDetector.SimpleOnGestureListener gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ZoomLayout mapaViewPort = (ZoomLayout) findViewById(R.id.mapaViewPort);
        //mapaViewPort.removeView(mapaConteudo);
        //mapaViewPort.addFilho(mapaConteudo);

        GrafoController gController = new GrafoController();

    }
}
