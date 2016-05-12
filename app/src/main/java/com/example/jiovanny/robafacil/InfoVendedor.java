package com.example.jiovanny.robafacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class InfoVendedor extends AppCompatActivity {
    private Intent intentVendedor;
    private Bundle bundleVendedor;
    private TextView txtVwNombVend,txtVwCorreoVen,txtVwUbiVen;
    private Button btnMostrarMapa;
    private String correoVendedor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_vendedor);
        txtVwCorreoVen=(TextView)findViewById(R.id.txtVwCorreo);
        txtVwNombVend=(TextView)findViewById(R.id.txtVwNomVen);
        txtVwUbiVen=(TextView)findViewById(R.id.txtVwUbi);
        intentVendedor=getIntent();
        bundleVendedor=intentVendedor.getExtras();
        correoVendedor=bundleVendedor.getString("CORREOV");
        txtVwCorreoVen.setText(correoVendedor);
    }
}
