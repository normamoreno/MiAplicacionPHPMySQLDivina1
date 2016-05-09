package mx.edu.utng.divinaphpsql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import mx.edu.utng.divinaphpsql.dao.DatabaseHelper;


/**
 * Created by MD on 07/02/2016.C
 */
public class InicioActivity extends AppCompatActivity {
    private ImageView imvPhp;
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_layout);
        imvPhp=(ImageView)findViewById(R.id.imb_php);
        imvPhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a= helper.traerNombre();
                //if(a!=""){
                  //  Intent intent= new Intent(InicioActivity.this,SeleccionModuloActivity.class);//Estava antes
                    //startActivity(intent);
                //}else{
                    Intent intent= new Intent(InicioActivity.this,FormLoginActivity.class);//Estava antes
                    startActivity(intent);
                //}

            }
        });
    }
}
