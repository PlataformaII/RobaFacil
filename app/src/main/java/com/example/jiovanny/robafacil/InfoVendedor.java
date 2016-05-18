package com.example.jiovanny.robafacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InfoVendedor extends AppCompatActivity {
    private Intent intentVendedor, intentMapa;
    private Bundle bundleVendedor;
    private TextView txtVwNombVend,txtVwCorreoVen,txtVwUbiVen;
    private Button btnMostrarMapa;
    private String correoVendedor;
    private MyBaseDatos mydb;
    private Button btnPruebaMapa;
    private String estadoVendedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_vendedor);
        txtVwCorreoVen=(TextView)findViewById(R.id.txtVwCorreo);
        txtVwNombVend=(TextView)findViewById(R.id.txtVwNomVen);
        txtVwUbiVen=(TextView)findViewById(R.id.txtVwUbi);
        btnMostrarMapa=(Button)findViewById(R.id.btnMapaVendedor);
        intentVendedor=getIntent();
        bundleVendedor=intentVendedor.getExtras();
        correoVendedor=bundleVendedor.getString("CORREOV");
        txtVwCorreoVen.setText(correoVendedor);
        mydb = new MyBaseDatos(this,null,null,1);
        cargarSQLiteUsuario();

        btnMostrarMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle= new Bundle();
                Intent i;
                bundle.putString("ESTADO",estadoVendedor);
                i=new Intent(InfoVendedor.this,MapasVen.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    public void cargarSQLiteUsuario(){
        Usuario usuario=mydb.getUsuario(correoVendedor);
        if (usuario==null){
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        }else{
            estadoVendedor=usuario.getEstado();
            txtVwNombVend.setText(usuario.getNombre());
            txtVwUbiVen.setText(estadoVendedor);
        }
    }
}
