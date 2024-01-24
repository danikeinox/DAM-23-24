package cat.eugeni.pilotafils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

import java.util.List;

public class Partida extends androidx.appcompat.widget.AppCompatImageView {

    private List<Partida> listaPelotas;
    private int acel;
    private Bitmap pilota, fons;
    private int tam_pantX, tam_pantY, posX, posY, velX, velY;
    private int tamPilota;
    private boolean pilota_puja;

    public Partida(Context contexto, int nivel_dificultad, List<Partida> listaPelotas) {
        super(contexto);
        this.listaPelotas = listaPelotas;

        WindowManager manejador_ventana = (WindowManager) contexto.getSystemService(Context.WINDOW_SERVICE);

        Display pantalla = manejador_ventana.getDefaultDisplay();

        Point maneja_coord = new Point();

        pantalla.getSize(maneja_coord);

        tam_pantX = maneja_coord.x;
        tam_pantY = maneja_coord.y;

        BitmapDrawable dibuix_fons = (BitmapDrawable) ContextCompat.getDrawable(contexto, R.drawable.paisatge_1);
        fons = dibuix_fons.getBitmap();
        fons = Bitmap.createScaledBitmap(fons, tam_pantX, tam_pantY, false);

        BitmapDrawable objectePilota = (BitmapDrawable) ContextCompat.getDrawable(contexto, R.drawable.pilota_1);
        pilota = objectePilota.getBitmap();
        tamPilota = tam_pantY / 3;
        pilota = Bitmap.createScaledBitmap(pilota, tamPilota, tamPilota, false);

        posX = tam_pantX / 2 - tamPilota / 2;
        posY = 0 - tamPilota;
        acel = nivel_dificultad * (maneja_coord.y / 400);
    }

    public Partida(Context contexto, int nivel_dificultad) {
        super(contexto);

        WindowManager manejador_ventana = (WindowManager) contexto.getSystemService(Context.WINDOW_SERVICE);

        Display pantalla = manejador_ventana.getDefaultDisplay();

        Point maneja_coord = new Point();

        pantalla.getSize(maneja_coord);

        tam_pantX = maneja_coord.x;
        tam_pantY = maneja_coord.y;

        BitmapDrawable dibuix_fons = (BitmapDrawable) ContextCompat.getDrawable(contexto, R.drawable.paisatge_1);
        fons = dibuix_fons.getBitmap();
        fons = Bitmap.createScaledBitmap(fons, tam_pantX, tam_pantY, false);

        BitmapDrawable objectePilota = (BitmapDrawable) ContextCompat.getDrawable(contexto, R.drawable.pilota_1);
        pilota = objectePilota.getBitmap();
        tamPilota = tam_pantY / 3;
        pilota = Bitmap.createScaledBitmap(pilota, tamPilota, tamPilota, false);

        posX = tam_pantX / 2 - tamPilota / 2;
        posY = 0 - tamPilota;
        acel = nivel_dificultad * (maneja_coord.y / 400);
    }

    public boolean toc(int x, int y) {
        if (y < tam_pantY / 3) return false;
        if (velY <= 0) return false;
        if (x < posX || x > posX + tamPilota) return false;
        if (y < posY || y > posY + tamPilota) return false;

        velY = -Math.abs(velY);

        double desplX = x - (posX + tamPilota / 2);
        desplX = desplX / (tamPilota / 2) * velY / 2;
        velX += (int) desplX;

        return true;
    }

    public boolean movimentBola() {
//        Log.d("Movimiento Pelota", "posX: " + posX + ", posY: " + posY);
        if (posX < 0 - tamPilota) {
            posY = 0 - tamPilota;
            velY = Math.abs(acel);
        }

        posX += velX;
        posY += velY;

        if (posY >= tam_pantY) return true;
        if (posX + tamPilota < 0 || posX > tam_pantX) return true;

        if (velY < 0) pilota_puja = true;

        if (velY > 0 && pilota_puja) {
            pilota_puja = false;
        }

        velY += acel;

        return false;
    }

    protected void onDraw(Canvas llenç) {
        llenç.drawBitmap(fons, 0, 0, null);
        llenç.drawBitmap(pilota, posX, posY, null);

        // log de posicio pilota
//        Log.d("Pilota Position", "posX: " + posX + ", posY: " + posY);

        // Iterar sobre la listaPelotas, pero asegúrate de que no sea nulo
        if (listaPelotas != null) {
            for (Partida p : listaPelotas) {
                p.dibujarPelota(llenç);
//                Log.d("Nueva Pelota", "posX: " + p.posX + ", posY: " + p.posY);
            }
        }
    }

    public void dibujarPelota(Canvas llenç) {
        llenç.drawBitmap(pilota, posX, posY, null);
    }

    // Método para agregar una nueva pelota a la lista
    public void agregarPelota() {
        listaPelotas.add(new Partida(getContext(), 1, listaPelotas));
    }
}
