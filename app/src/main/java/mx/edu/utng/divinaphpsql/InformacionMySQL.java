package mx.edu.utng.divinaphpsql;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import mx.edu.utng.divinaphpsql.dao.DatabaseHelper;

/**
 * Created by user on 4/30/2016.
 */
public class InformacionMySQL extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);
    private TextView info;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion_activity);
        info = (TextView) findViewById(R.id.txv_contenido);
        titulo = (TextView) findViewById(R.id.txv_titulo);

        String title = getIntent().getStringExtra("titulo");

        switch (title) {
            case "¿Que es MySQL?":
                titulo.setText(R.string.capitulo_queesmysql);
                info.setText(R.string.informacion_queesmysql);
                helper.actualizarCapitulo(4);
                break;
            case "¿Por qué usar MySQL?":
                titulo.setText(R.string.capitulo_porquemysql);
                info.setText(R.string.informacion_porquemysql);
                helper.actualizarCapitulo(5);
                break;
            case "Sentencias basicas:":
                titulo.setText(R.string.capitulo_sentenciasmysql);
                info.setText(R.string.informacion_sentenciasmysql);
                helper.actualizarCapitulo(6);
                break;
        }
    }
}