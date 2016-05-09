package mx.edu.utng.divinaphpsql.ahorcado;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

import mx.edu.utng.divinaphpsql.R;

/**
 * Created by Mauricio on 05/04/2016.
 */
public class Marcador {

    private String palabraPensada;
    private int puntuacion;
    private ArrayList<Character>letras;
    private String estadoPalabra;
    private int numFallos;

    private Context context;
    private Bitmap[] imagenes;
    private Rect[] posiciones;

    public Marcador(Context context,String palabra){
        this.palabraPensada = palabra;
        this.context = context;
        this.puntuacion = 0;
        this.numFallos = 0;
        this.letras = new ArrayList<>();

        representarPalabra();
        this.imagenes = new Bitmap[6];
        this.posiciones = new Rect[6];
        this.imagenes[0] = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.cabeza);
        this.imagenes[1] = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.cabeza1);
        this.imagenes[2] = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.cabeza2);
        this.imagenes[3] = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.cabeza3);
        this.imagenes[4] = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.cabeza4);
        this.imagenes[5] = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.cabeza5);



    }



    private void anotarLetra(char letra){
        this.letras.add(letra);
    }

    public boolean comprobarPalabra(char letra){

        anotarLetra(letra);

        boolean existe = false;

        for (int i = 1; i < this.palabraPensada.length() -1; i++){
            if (this.palabraPensada.charAt(i) == letra){
                StringBuilder palabra = new StringBuilder(this.estadoPalabra);
                palabra.setCharAt(i, letra);
                this.estadoPalabra = palabra.toString();
                existe = true;
            }
        }

        if (!existe && this.numFallos < 6) this.numFallos++;

        return this.palabraPensada.compareTo(this.estadoPalabra) == 0;
    }

    public void representarPalabra(){
        StringBuilder palabraOculta = new StringBuilder(this.palabraPensada);

        for (int i = 1; i < this.palabraPensada.length() -1; i++){
            palabraOculta.setCharAt(i, '_');
        }

        this.estadoPalabra = palabraOculta.toString();
    }

    public void draw(Canvas canvas){


        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(75);

        canvas.drawText("Fallos: " + this.numFallos, 0, 75, paint);
        canvas.drawText("" + this.estadoPalabra.replace("", " ").trim(), 75, canvas.getHeight() - 75, paint);

        if (this.numFallos > 0){
            canvas.drawBitmap(this.imagenes[this.numFallos - 1], 230, 230, new Paint());
        }
    }

    public boolean ahorcado(){
        return this.numFallos >= 6;
    }
}
