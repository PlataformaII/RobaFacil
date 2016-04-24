package com.example.jiovanny.robafacil;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class venta extends AppCompatActivity {

    private Spinner spiProductos;
    private ArrayAdapter<CharSequence> adapter;
    private EditText edtTxtNomPro, edtTxtDesc,edtTxtPrec;
    private Button btnAgregarProducto;
    private MyBaseDatos manjedorDb;
    private String categoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spiProductos = (Spinner) findViewById(R.id.spiProductos);
        adapter = ArrayAdapter.createFromResource(this, R.array.Articulos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiProductos.setAdapter(adapter);
        edtTxtDesc=(EditText)findViewById(R.id.txtDescripcion);
        edtTxtNomPro=(EditText)findViewById(R.id.txtNomArt);
        edtTxtPrec=(EditText)findViewById(R.id.txtPrecio);
        btnAgregarProducto=(Button)findViewById(R.id.btnAgregarProducto);

        Intent leerUser = getIntent();
        Bundle userLeido = leerUser.getExtras();
        String user = userLeido.getString("USER");
        Toast.makeText(getApplicationContext(), "" + user, Toast.LENGTH_SHORT).show();

        btnAgregarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarSQLite();
            }
        });
        spiProductos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView miTexto = (TextView) view;
                categoria = miTexto.getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        manjedorDb = new MyBaseDatos(this, null, null, 1);
    }
    public void guardarSQLite(){
        String strError="";
        if (edtTxtNomPro.getText().toString().isEmpty())
            strError+="Ingresa el nombre del articulo\n";
        if (spiProductos.getSelectedItem().toString().equals("Selecciona una categoria"))
            strError+="Selecciona una categoria\n";
        if (edtTxtDesc.getText().toString().isEmpty())
            strError+="Ingresa una descripción\n";
        if (edtTxtPrec.getText().toString().isEmpty())
            strError+="Ingresa precio\n";
        if (!strError.equals("")){
            strError="Debes llenar los siguientes datos:\n"+strError;
            Toast.makeText(this, strError, Toast.LENGTH_LONG).show();
            return;
        }

        Producto pdc= new Producto();
        pdc.setNombre(edtTxtNomPro.getText().toString());
        pdc.setDescripcion(edtTxtDesc.getText().toString());
        pdc.setPrecio(Integer.parseInt(edtTxtPrec.getText().toString()));
        switch (categoria){
            case "Selecciona una categoria":
                break;
            case "Electrodomesticos": pdc.setCategoria(Producto.ELECTRODOMESTICOS);
                break;
            case "Linea Blanca":pdc.setCategoria(Producto.LINEA_BLANCA);
                break;
            case "Muebles":pdc.setCategoria(Producto.MUEBLES);
                break;
            case"Autos":pdc.setCategoria(Producto.AUTOS);
                break;
        }
        manjedorDb.addProducto(pdc);
        Toast.makeText(this,"Producto Agregado",Toast.LENGTH_SHORT).show();
    }
}
