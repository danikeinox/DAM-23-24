package dam2.dcabrera.activitat3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bt_clear;

    Path path = new Path();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new PaintVista(this));
    }

    public class PaintVista extends View {
        float x = 50;
        float y = 50;
        String accio = "accio";

        public PaintVista(Context context) { super(context);}
        protected void onDraw(Canvas cnv) {
            /*
            //PRIMERA OPCIÓ ACT3

            int x,y;
            Paint pinzell = new Paint();
            pinzell.setColor(Color.GREEN);
            pinzell.setStrokeWidth(10);
            pinzell.setStyle(Paint.Style.FILL);
            cnv.drawCircle(getWidth()/2, getHeight()/2, 90,pinzell);
            cnv.drawRGB(Color.RED, Color.GREEN, Color.BLUE);
            int cl = ContextCompat.getColor(getContext(), R.color.black);
            for (int i = 0; i<1000; i++){
                x = (int) (Math.random() * getWidth());
                y = (int) (Math.random() * getWidth());
                cnv.drawPoint(x,y,pinzell);
            }
            */

            /*
            //SEGONA OPCIÓ ACT3 (Cercle dins d'un cercle amb text rodejant el cercle)

            Path mTra = new Path();
            Paint pinzell = new Paint();
            pinzell.setColor(Color.WHITE);
            pinzell.setStrokeWidth(100);
            pinzell.setStyle(Paint.Style.FILL);
            mTra.addCircle(getWidth()/2, getHeight()/2,180,Path.Direction.CCW);
            cnv.drawPath(mTra,pinzell);
            pinzell.setColor(Color.RED);
            mTra.addCircle(getWidth()/2,getHeight()/2,90,Path.Direction.CW);
            cnv.drawPath(mTra, pinzell);
            //mTra.reset();
            pinzell.setStrokeWidth(1);
            pinzell.setStyle(Paint.Style.FILL);
            pinzell.setTextSize(42);
            pinzell.setTypeface(Typeface.SANS_SERIF);
            cnv.drawTextOnPath("DAM2-Android", mTra,600,55,pinzell);
            cnv.drawTextOnPath("Daniel Cabrera", mTra,15,55,pinzell);
             */

            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            int ample = cnv.getWidth();
            if (accio == "down")
                path.moveTo(x, y);
            if (accio == "move")
                path.lineTo(x, y);
            cnv.drawPath(path, paint);
        }
        public boolean onTouchEvent(MotionEvent e){
            x = e.getX();
            y = e.getY();
            if(e.getAction() == MotionEvent.ACTION_DOWN)
                accio = "down";
            if(e.getAction() == MotionEvent.ACTION_MOVE)
                accio = "move";
            invalidate();
            return true;

        }
    }

}