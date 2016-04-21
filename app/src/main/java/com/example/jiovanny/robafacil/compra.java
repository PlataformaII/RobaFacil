package com.example.jiovanny.robafacil;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class compra extends AppCompatActivity {
    private Spinner spiCategorias;
    private ArrayAdapter<CharSequence> adapter;
    SearchView searchViewProduc;
    private MyBaseDatos mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
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

        spiCategorias = (Spinner) findViewById(R.id.spiCategorias);
        adapter = ArrayAdapter.createFromResource(this, R.array.Articulos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiCategorias.setAdapter(adapter);
        searchViewProduc=(SearchView)findViewById(R.id.searchViewProducto);

        mydb = new MyBaseDatos(this,null,null,1);

    }
    public void cargarSQLiteProducto(){
        Producto productoB=mydb.getProducto(searchViewProduc.getQuery().toString());

    }
}
