package mx.edu.utng.divinaphpsql.ahorcado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import mx.edu.utng.divinaphpsql.R;

/**
 * Created by Mauricio on 05/04/2016.
 */
public class MainAhorcado extends AppCompatActivity implements View.OnClickListener{

    Button btnEmpezar,btnPuntos,btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ahorcado_principal);

        btnEmpezar = (Button)findViewById(R.id.btn_empezar);
        btnPuntos = (Button)findViewById(R.id.btn_puntuar);
        btnSalir = (Button)findViewById(R.id.btn_salir);

        btnEmpezar.setOnClickListener(this);
        btnPuntos.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnEmpezar){
            Intent i = new Intent(this, JuegoActivity.class);
            startActivity(i);
        }else if (v == btnPuntos){

        }else if(v == btnSalir){
            finish();
        }
    }
}
