package mx.edu.utng.divinaphpsql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by MD on 2/18/2016.
 */
public class DesarrolladorActivity extends AppCompatActivity {
    private TextView txvInfo;
    private String contenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion_desarrollador_activity);

        txvInfo=(TextView)findViewById(R.id.txv_info);
        contenido=getResources().getString(R.string.informacion_desarrolladora);
        CharSequence textoInterpretado = Html.fromHtml(contenido);
        txvInfo.setText(textoInterpretado);



    }
}
