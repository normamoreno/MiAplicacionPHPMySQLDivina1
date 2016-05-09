package mx.edu.utng.divinaphpsql;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.divinaphpsql.dao.DatabaseHelper;

public class FormLoginActivity extends AppCompatActivity implements View.OnClickListener{


    public Button btnIniciar, btnVista,btnRegistro;
    DatabaseHelper helper = new DatabaseHelper(this);
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_login_layout);
        btnIniciar=(Button)findViewById(R.id.btn_login);
        btnIniciar.setOnClickListener(this);

        btnRegistro=(Button)findViewById(R.id.btn_signup);
        btnRegistro.setOnClickListener(this);

        btnVista=(Button)findViewById(R.id.btn_mas_tarde);
        btnVista.setOnClickListener(this);
    }

    public void onClick(View view){
        bundle=new Bundle();
        bundle.putBoolean("Logeado",false);

        if(view.getId() == R.id.btn_login){
            EditText a = (EditText)findViewById(R.id.edt_user);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.edt_pass);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password)) {
                bundle.putBoolean("Logeado",true);
                bundle.putString("Username", str);
                Intent i = new Intent(this, SeleccionModuloActivity.class).putExtras(bundle);
                startActivity(i);
            }else{
                Toast temp = Toast.makeText(this,"Usuario o Contrasenia Invalida", Toast.LENGTH_SHORT);
                temp.show();
            }
        }
        if(view.getId() == R.id.btn_signup){
            Intent i = new Intent(this, FormCreateLoginActivity.class);
            startActivity(i);
        }

        if(view.getId() == R.id.btn_mas_tarde){
            Intent i = new Intent(this, SeleccionModuloActivity.class).putExtras(bundle);
            startActivity(i);
            System.exit(0);
        }
    }
}
