package com.example.jiovanny.robafacil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class compra extends AppCompatActivity {
    private Spinner spiCategorias;
    private ArrayAdapter<CharSequence> adapter;
    private SearchView sv;
    private MyBaseDatos mydb;
    private String consultaBus,categoriaBus;
    private ArrayList<Producto>productoArrayList1;
    MiAdaptador miAdaptador;
    private ListView listViewProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*Intent leerUser = getIntent();
        Bundle userLeido = leerUser.getExtras();
        String user = userLeido.getString("USER");
        //Toast.makeText(this, "Compras: " + user, Toast.LENGTH_SHORT).show();*/

        listViewProductos=(ListView)findViewById(R.id.listVwProductos);
        spiCategorias = (Spinner) findViewById(R.id.spiCategorias);
        adapter = ArrayAdapter.createFromResource(this, R.array.Articulos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiCategorias.setAdapter(adapter);
        sv=(android.widget.SearchView) findViewById(R.id.searchViewP);
        mydb = new MyBaseDatos(this,null,null,1);

        productoArrayList1=new ArrayList<Producto>();
        for (int i=1;i<=mydb.getFilas();i++){
            productoArrayList1.add(mydb.getProducto(i));
        }

        miAdaptador = new MiAdaptador(this,productoArrayList1);
        listViewProductos.setAdapter(miAdaptador);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                consultaBus=query;
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                consultaBus=newText;
                categoriaBus=spiCategorias.getSelectedItem().toString();
                cargarSQLiteProducto();
                return false;
            }
        });
    }
    
    public void cargarSQLiteProducto(){
        Producto productoB=mydb.getProducto(consultaBus);
        Toast.makeText(getApplicationContext(),"Este es el query "+ consultaBus +" Categoria "+ categoriaBus,Toast.LENGTH_SHORT).show();

    }
    public class MiAdaptador extends BaseAdapter{
        ArrayList<Producto> productoArrayList2;
        LayoutInflater lInflater;

        public MiAdaptador(Context context,ArrayList<Producto> productos) {
            this.productoArrayList2 = productos;
            this.lInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return productoArrayList2.size();
        }

        @Override
        public Object getItem(int position) {
            return productoArrayList2.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Intent leerUser = getIntent();
            Bundle userLeido = leerUser.getExtras();
            String user = userLeido.getString("USER");

            convertView=lInflater.inflate(R.layout.mostrarproductos,null);
            TextView txtVwNomP=(TextView)convertView.findViewById(R.id.txtVwNomProList);
            TextView txtVwDescP=(TextView)convertView.findViewById(R.id.txtVwDescProList);
            TextView txtVwPreP=(TextView)convertView.findViewById(R.id.txtVwPrecList);
            TextView txtVwUser = (TextView) convertView.findViewById(R.id.txtVwUserList);

            txtVwDescP.setText("Descripción: "+productoArrayList2.get(position).getDescripcion());
            txtVwNomP.setText("Nombre Producto: "+productoArrayList2.get(position).getNombre());
            txtVwPreP.setText("Precio: "+productoArrayList2.get(position).getPrecio()+" Pesos");
            txtVwUser.setText("Usuario: " + productoArrayList2.get(position).getUser());

            return convertView;
        }
    }

}
