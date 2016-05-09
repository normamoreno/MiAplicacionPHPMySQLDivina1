package mx.edu.utng.divinaphpsql.ahorcado;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Mauricio on 05/04/2016.
 */
public class VistaJuego extends View {

    private Context context;
    private Marcador marcador;

    public VistaJuego(Context context, String palabra) {
        super(context);

        this.context = context;
        this.marcador = new Marcador(context,palabra);
    }


    public void introducirLetra(char letra){
        boolean finalizado =this.marcador.comprobarPalabra(letra);
        if (finalizado){
            Toast.makeText(this.context,"Ganaste",Toast.LENGTH_SHORT).show();
        }else if(this.marcador.ahorcado()){
                Toast.makeText(this.context, "Suerte para la próxima",Toast.LENGTH_SHORT).show();

            }

        invalidate();
        }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        this.marcador.draw(canvas);
    }


}
