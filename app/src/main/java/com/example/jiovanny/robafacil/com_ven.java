package com.example.jiovanny.robafacil;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.awt.font.TextAttribute;

public class com_ven extends AppCompatActivity {

    private Button btnComprar, btnVender;
    private TextView txtVwBienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_ven);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnComprar = (Button) findViewById(R.id.btnComprar);
        btnVender = (Button) findViewById(R.id.btnVender);
        txtVwBienvenido = (TextView) findViewById(R.id.txtVwBienvenido);

        Intent leerUser = getIntent();
        Bundle userLeido = leerUser.getExtras();
        String user = userLeido.getString("USER");
        txtVwBienvenido.append(user);

        final Bundle envUsuario;
        envUsuario = new Bundle();
        envUsuario.putString("USER", user);

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com_ven.this, compra.class);
                intent.putExtras(envUsuario);
                startActivity(intent);
            }
        });

        btnVender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com_ven.this, venta.class);
                intent.putExtras(envUsuario);
                startActivity(intent);
            }
        });

    }

}
