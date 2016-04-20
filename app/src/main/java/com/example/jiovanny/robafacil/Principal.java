package com.example.jiovanny.robafacil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    private Button btnSomos, btnSesion, btnRegistrate;
    //Button btnSesion;
    private EditText edtTxtUsuario,edtTxtContra;
    private String error="";
    private MyBaseDatos mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        edtTxtContra = (EditText)findViewById(R.id.eTxtContra);
        edtTxtUsuario=(EditText)findViewById(R.id.eTxtUsuario);
        btnSesion = (Button) findViewById(R.id.btnSesion);
        btnSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtTxtContra.getText().toString().isEmpty()||edtTxtUsuario.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Ingresa la contraseña y el usuario\n"+"para poder ingresar",Toast.LENGTH_SHORT).show();
                    return;
                }
                cargarSQLite();


            }
        });

        btnRegistrate = (Button) findViewById(R.id.btnRegistrate);
        btnRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Principal.this, resgistro.class);
                startActivity(intent);
            }
        });

        btnSomos = (Button) findViewById(R.id.btnSomos);
        btnSomos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Principal.this,somos.class);
                startActivity(intent);
            }
        });
        mydb = new MyBaseDatos(this,null,null,1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }



        return super.onOptionsItemSelected(item);
    }
    public void cargarSQLite(){
        Usuario usuario= mydb.getUsuario(edtTxtUsuario.getText().toString());
        if (usuario==null){
            Toast.makeText(this,"usuario no encontrado",Toast.LENGTH_SHORT).show();
            return;
        }
        if (!(usuario.getContrasena().equals(edtTxtContra.getText().toString())&&usuario.getCorreo().equals(edtTxtUsuario.getText().toString()))){
            Toast.makeText(this,"Correo o contraseña incorrecta",Toast.LENGTH_SHORT).show();
            Toast.makeText(this,usuario.getId()+usuario.getCorreo()+usuario.getContrasena()+usuario.getEstado()+usuario.getNombre(),Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this,"Ingresaste Correctamente",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Principal.this, com_ven.class);
        startActivity(intent);
        /*
        SQLiteDatabase sqLitedb=mydb.getReadableDatabase();
        String[] columnas={
            MyBaseDatos.KEY_CONTRA_USUA,MyBaseDatos.KEY_EMAIL
        };
        String usuario=MyBaseDatos.KEY_EMAIL+" LIKE '"+edtTxtUsuario.getText().toString()+"'";
        String contra=MyBaseDatos.KEY_CONTRA_USUA+" LIKE '"+edtTxtContra.getText().toString()+"'";
        String resContra=MyBaseDatos.KEY_CONTRA_USUA+" DESC";
        String resCorreo=MyBaseDatos.KEY_EMAIL+" DESC";
        Cursor cursor=sqLitedb.query(MyBaseDatos.TABLA_USARIO,columnas,usuario,null,null,null,resCorreo);
        Cursor cursor2=sqLitedb.query(MyBaseDatos.TABLA_USARIO,columnas,contra,null,null,null,resContra);
        if (cursor.getCount()!=0&&cursor2.getCount()!=0){
            cursor.moveToFirst();
            Toast.makeText(this,"Ingresaste Correctamente",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Principal.this, com_ven.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"el correo o contraseña incorrecta",Toast.LENGTH_SHORT).show();
        }
        mydb.close();*/

    }


}
