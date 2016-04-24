package com.example.jiovanny.robafacil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

public class compra extends AppCompatActivity {
    private Spinner spiCategorias;
    private ArrayAdapter<CharSequence> adapter;
    private SearchView sv;
    private MyBaseDatos mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent leerUser = getIntent();
        Bundle userLeido = leerUser.getExtras();
        String user = userLeido.getString("USER");
        //Toast.makeText(this, "Compras: " + user, Toast.LENGTH_SHORT).show();

        spiCategorias = (Spinner) findViewById(R.id.spiCategorias);
        adapter = ArrayAdapter.createFromResource(this, R.array.Articulos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiCategorias.setAdapter(adapter);
        sv= (android.widget.SearchView) findViewById(R.id.searchViewP);

        mydb = new MyBaseDatos(this,null,null,1);

    }
    public void cargarSQLiteProducto(){
        Producto productoB=mydb.getProducto(sv.getQuery().toString());

    }
}
