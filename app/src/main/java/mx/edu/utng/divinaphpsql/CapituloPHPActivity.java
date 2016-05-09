package mx.edu.utng.divinaphpsql;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.divinaphpsql.dao.DatabaseHelper;
import mx.edu.utng.divinaphpsql.estrategia.Manager;
import mx.edu.utng.divinaphpsql.examen.php.PHPQuestion;
import mx.edu.utng.divinaphpsql.galerias.GaleryActivity;

/**
 * Created by MD on 06/02/2016.
 */
public class CapituloPHPActivity extends AppCompatActivity implements View.OnClickListener{
    private Bundle bundleResivido,bundle;
    private Button modulo1;
    private Button modulo2;
    private Button modulo3;
    private Button examen;

    DatabaseHelper helper = new DatabaseHelper(this);
    private Intent intent;
    private MediaPlayer mp;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo);
        bundleResivido=getIntent().getExtras();
        bundle=new Bundle();
        modulo1=(Button)findViewById(R.id.txv_selec1);
        modulo1.setOnClickListener(this);
        modulo2=(Button)findViewById(R.id.txv_selec2);
        modulo2.setOnClickListener(this);
        modulo3=(Button)findViewById(R.id.txv_selec3);
        modulo3.setOnClickListener(this);
        examen=(Button)findViewById(R.id.txv_selec4);
        examen.setOnClickListener(this);

        imagen=(ImageView)findViewById(R.id.img_mod);
        String username=bundleResivido.getString("mod");
        TextView tv = (TextView)findViewById(R.id.txv_selec_title);
        tv.setText(username);

        imagen.setBackgroundResource(R.drawable.img_php);
        modulo1.setText(R.string.capitulo_queesphp);
        modulo2.setText(R.string.capitulo_quehacephp);
        modulo3.setText(R.string.capitulo_dondeseemplea);
        RelativeLayout fondo = (RelativeLayout)findViewById(R.id.relativeLayout);
        DatabaseHelper helper = new DatabaseHelper(this);
        int tema = helper.tema();
        if(tema==1){
            fondo.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }else{
            if(tema==2){
                fondo.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }else{
                if(tema==3){
                    fondo.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                }else{
                    if(tema==4){
                        fondo.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                    }
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Bundle bundle=new Bundle();
        String mensaje="";
        switch (item.getItemId()){
            case R.id.itm_menu_bar_configuracion:
                Intent i = new Intent(this,ConfiguracionActivity.class);
                startActivity(i);
                mensaje="Configuracion";
                break;
            case R.id.itm_menu_bar_desarrollador:
                bundle.putInt("posicion",R.id.itm_menu_bar_desarrollador);
                intent=new Intent(CapituloPHPActivity.this,DesarrolladorActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.itm_menu_bar_universidad:
                intent=new Intent(CapituloPHPActivity.this,VideoActivity.class);
                intent.putExtra("url", "Promocion");
                startActivity(intent);
                break;
            case R.id.itm_menu_bar_video:
                i = new Intent(this, SelectVideoActivity.class);
                startActivity(i);
                break;
            case R.id.itm_menu_bar_progreso_salir:
                finish();
                Intent intent1=new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
                break;
            case R.id.itm_menu_bar_musica:
                mp =new MediaPlayer().create(this,R.raw.heart);
                if (mp.isPlaying()) {
                    mp.pause();
                }else {
                    mp.start();
                }
                break;
            case R.id.itm_menu_bar_Tema:
                startActivity(new Intent(CapituloPHPActivity.this, TemaActivity.class));
                break;
            case R.id.itm_menu_bar_correo:
                startActivity(new Intent(CapituloPHPActivity.this, MailActivity.class));
                break;
            case R.id.itm_menu_bar_grafica:
                startActivity(new Intent(CapituloPHPActivity.this, GraficaMenuActiviry.class));
                break;
            case R.id.itm_menu_bar_juegos:
                startActivity(new Intent(CapituloPHPActivity.this, Manager.class));
                break;
            case R.id.itm_menu_bar_galery:
                startActivity(new Intent(CapituloPHPActivity.this, GaleriasActivity.class));
                break;
            case R.id.itm_menu_bar_tools:
                startActivity(new Intent(CapituloPHPActivity.this, UtileriasActivity.class));
                break;
            case R.id.itm_menu_bar_streaming:
                startActivity(new Intent(CapituloPHPActivity.this, StreamingMp3Player.class));
                break;
            default:
                break;
        }
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
        bundle.putBoolean("", bundleResivido.getBoolean("Logeado"));
        int bloqueo=helper.bloqueoCapitulos();
        switch (v.getId()) {
            case R.id.txv_selec1:
                Intent i = new Intent(this, InformacionPHP.class);
                String a= String.valueOf(R.string.informacion_queesphp);
                i.putExtra("titulo", modulo1.getText().toString());
                startActivity(i);
                break;
            case R.id.txv_selec2:
                if (bloqueo >= 2) {
                    i = new Intent(this, InformacionPHP.class);
                    i.putExtra("titulo", modulo2.getText().toString());
                    startActivity(i);
                } else {
                    Toast temp = Toast.makeText(this, "Tema Bloqueado", Toast.LENGTH_LONG);
                    temp.show();
                }
                break;
            case R.id.txv_selec3:
                if (bloqueo >= 3 ) {
                    i = new Intent(this, InformacionPHP.class);
                    i.putExtra("titulo", modulo3.getText().toString());
                    startActivity(i);
                } else {
                    Toast temp = Toast.makeText(this, "Tema Bloqueado", Toast.LENGTH_LONG);
                    temp.show();
                }
                break;
            case R.id.txv_selec4:
                if (bloqueo >= 4 ) {
                    new AlertDialog.Builder(this)
                            .setTitle("Realizar test")
                            .setMessage("Estas seguro de realizar el test")
                            .setIcon(R.drawable.icon)
                            .setNegativeButton("Cancelar", null)
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(CapituloPHPActivity.this, PHPQuestion.class).putExtra("Logeado",bundleResivido.getBoolean("Logeado"));
                                    startActivity(i);
                                }
                            }).show();
                } else {
                    Toast temp = Toast.makeText(this, "Tema Bloqueado", Toast.LENGTH_LONG);
                    temp.show();
                }
                break;
        }
    }
}
