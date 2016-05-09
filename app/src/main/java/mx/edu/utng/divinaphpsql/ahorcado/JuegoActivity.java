package mx.edu.utng.divinaphpsql.ahorcado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import mx.edu.utng.divinaphpsql.R;

/**
 * Created by Mauricio on 05/04/2016.
 */
public class JuegoActivity extends AppCompatActivity implements View.OnClickListener {
    FrameLayout frmJuego;
    EditText txtLetra;
    Button btnEIntro;
    VistaJuego juego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);


        btnEIntro = (Button)findViewById(R.id.btn_intro);
        txtLetra = (EditText)findViewById(R.id.letra);
        frmJuego = (FrameLayout)findViewById(R.id.juego_v_juego);

        btnEIntro.setOnClickListener(this);


        GeneradorPalabras generador = new GeneradorPalabras(this, R.array.arrayPalabras);
        String palabra = generador.generarPalabra();
        juego = new VistaJuego(this, palabra);
        frmJuego.addView(juego);
    }

    @Override
    public void onClick(View v) {
        if (v == btnEIntro){
            if (txtLetra.length()>0){
                char letra = txtLetra.getText().toString().charAt(0);
                juego.introducirLetra(letra);
                txtLetra.setText("");
            }else {
                Toast.makeText(JuegoActivity.this, "Campo vacío", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
