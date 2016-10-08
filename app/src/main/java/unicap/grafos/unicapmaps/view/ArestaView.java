package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Cais Automação on 08/10/2016. project UnicapMaps
 */

public class ArestaView extends View{

    Paint paint;
    Path path;

    public ArestaView(Context context){
        super(context);
        init();
    }
    public ArestaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ArestaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAlpha(127);
        paint.setAntiAlias(true);

        path = new Path();
        path.moveTo(10,10);
        path.lineTo(200,200);
        path.lineTo(20, 200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);
    }
}
