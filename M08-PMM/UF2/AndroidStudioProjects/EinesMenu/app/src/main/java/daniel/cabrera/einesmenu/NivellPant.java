package daniel.cabrera.einesmenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;

import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;



public class NivellPant extends AppCompatImageView {

    int costat, radi, radiPet, tras;

    float[] angles; // Recibirá las variaciones del sensor

    Bitmap fons;  //  dibujo de fondo

    Paint trasDibuix;

    Bitmap bombolla;

    public NivellPant(Context context, int costat){   // recibe el tamaño del espacio de dibujo con "lado"

        super(context);

        this.costat=costat;

        radi=costat/2;

        radiPet=costat/10;

        tras=costat/100;

        angles=new float[2];

        angles[0]=0;

        angles[1]=0;

        fons=iniciaFondo();

        trasDibuix=new Paint();

        trasDibuix.setColor(Color.BLACK);

        trasDibuix.setTextSize(20);

        BitmapDrawable bola=(BitmapDrawable) ContextCompat.getDrawable(context, R.drawable.bombolla);

        bombolla=bola.getBitmap();

        bombolla=Bitmap.createScaledBitmap(bombolla, radiPet*2, radiPet*2, true);

    }


    private Bitmap iniciaFondo(){

        Bitmap.Config conf=Bitmap.Config.ARGB_4444;

        Bitmap fondo=Bitmap.createBitmap(costat, costat, conf);

        Canvas lienzo=new Canvas(fondo);

        Paint llapis=new Paint();

        llapis.setColor(Color.RED);

        lienzo.drawCircle(radi, radi, radi, llapis);

        llapis.setColor(Color.BLACK);

        lienzo.drawCircle(radi, radi, radi-tras, llapis);

        llapis.setColor(Color.RED);

        lienzo.drawCircle(radi, radi, radiPet+tras, llapis);

        llapis.setStrokeWidth(tras);

        lienzo.drawLine(radi, 0, radi, costat, llapis);

        lienzo.drawLine(0, radi, radi, radi, llapis);

        return fondo;

    }

    public void angles(float[] angulos){

        this.angles=angulos;

        invalidate();

    }


    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){  // ajustamos dimensiones de la vista (no trabaja a pantalla completa)

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(costat, costat);

    }

    protected void onDraw(Canvas lienzo){

        super.onDraw(lienzo);

        lienzo.drawBitmap(fons, 0, 0, null);

        int posX=radi-radiPet+(int)(angles[0]/10*radi);

        int posY=radi-radiPet-(int)(angles[1]/10*radi);

        lienzo.drawBitmap(bombolla, posX, posY, null);


    }

}
