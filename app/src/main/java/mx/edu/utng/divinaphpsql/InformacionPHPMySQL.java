package mx.edu.utng.divinaphpsql;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import mx.edu.utng.divinaphpsql.dao.DatabaseHelper;

/**
 * Created by user on 4/30/2016.
 */
public class InformacionPHPMySQL extends Activity {

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
            case "La combinación de PHP y MySQL":
                titulo.setText(R.string.capitulo_queesphpymysql);
                info.setText(R.string.informacion_queesphpymysql);
                helper.actualizarCapitulo(7);
                break;
            case "Conectando con una Base de datos":
                titulo.setText(R.string.capitulo_dondeseempleaphmysql);
                info.setText(R.string.informacion_dondeseempleaphmysql);
                helper.actualizarCapitulo(8);
                break;
            case "Otras funciónes php para base de datos Mysql":
                titulo.setText(R.string.capitulo_quehacephpmysql);
                info.setText(R.string.informacion_quehacephpmysq);
                helper.actualizarCapitulo(9);
                break;
        }
    }
}