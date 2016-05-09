package mx.edu.utng.divinaphpsql;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import mx.edu.utng.divinaphpsql.dao.DatabaseHelper;

/**
 * Created by user on 4/30/2016.
 */
public class InformacionPHP extends Activity {

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
            case "¿Qué es PHP?":
                titulo.setText(R.string.capitulo_queesphp);
                info.setText(R.string.informacion_queesphp);
                helper.actualizarCapitulo(2);
                break;
            case "¿Qué puede hacer PHP?":
                titulo.setText(R.string.capitulo_quehacephp);
                info.setText(R.string.informacion_quehacephp);
                helper.actualizarCapitulo(3);
                break;
            case "¿Donde puede emplearse?":
                titulo.setText(R.string.capitulo_dondeseemplea);
                info.setText(R.string.informacion_dondeseemplea);
                helper.actualizarCapitulo(4);
                break;
        }
       /*
        if(title=="¿Qué es PHP?"){
            info.setText(R.string.informacion_queesphp);
            helper.actualizarCapitulo(2);
        }else{
            if(title=="¿Qué puede hacer PHP?"){
                info.setText(R.string.informacion_quehacephp);
                helper.actualizarCapitulo(3);
                //}else{
                //if(t=="¿Qué puede hacer PHP?"){
                //  helper.actualizarCapitulo(4);
                // }
            }
        }
    }*/
    }
}