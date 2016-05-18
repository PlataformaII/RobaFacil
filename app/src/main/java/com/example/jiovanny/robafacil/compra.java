package com.example.jiovanny.robafacil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class compra extends AppCompatActivity{
    //variables usadas en la actividad Compra
    private Spinner spiCategorias;
    private ArrayAdapter<CharSequence> adapter;
    private SearchView sv;
    private MyBaseDatos mydb;
    private String consultaBus,categoriaBus;
    private ArrayList<Producto>productoArrayList1;
    private MiAdaptador miAdaptador;
    private ListView listViewProductos;
    private String correoVendedor;
    private Bundle bundleDaVen;
    private Intent intentVendedor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Obtenemos una referencia a los controles de la interfaz
        listViewProductos=(ListView)findViewById(R.id.listVwProductos);
        spiCategorias = (Spinner) findViewById(R.id.spiCategorias);
        sv=(android.widget.SearchView) findViewById(R.id.searchViewP);

        adapter = ArrayAdapter.createFromResource(this, R.array.Articulos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiCategorias.setAdapter(adapter);
        mydb = new MyBaseDatos(this,null,null,1);

        productoArrayList1=new ArrayList<Producto>();

        for (int i=1;i<=mydb.getFilas();i++){
            productoArrayList1.add(mydb.getProducto(i));
        }
        miAdaptador= new MiAdaptador(this,productoArrayList1);
        listViewProductos.setAdapter(miAdaptador);

        //implementacion del evento setOnQueryTextListener del spinner
        //fase de desarrollo
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                /*consultaBus=query;
                categoriaBus=spiCategorias.getSelectedItem().toString();
                cargarSQLiteProducto();*/
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                consultaBus=newText;
                categoriaBus=spiCategorias.getSelectedItem().toString();
                cargarSQLiteProducto();
                //adaptadorLista.getNombreP();
                return false;
            }
        });//fin del metodo OnQueryTextListener
        listViewProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                correoVendedor=productoArrayList1.get(position).getUser();
                bundleDaVen= new Bundle();
                bundleDaVen.putString("CORREOV",correoVendedor);
                intentVendedor= new Intent(compra.this,InfoVendedor.class);
                intentVendedor.putExtras(bundleDaVen);
                startActivity(intentVendedor);
            }
        });
    }//fin del metodoOnCreate

    //mantenimiento
    public void cargarSQLiteProducto(){
        Producto productoB=mydb.getProducto(consultaBus);
        if (productoB==null){
            Toast.makeText(getApplicationContext(),"Busqueda no encontrada",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"id_Productos: "+productoB.getId()+"Nombre Producto:" +productoB.getNombre(),Toast.LENGTH_SHORT).show();
        }
    }

    //creacion clase MiAdaptador
    public class MiAdaptador extends BaseAdapter{

        //variables usadas en la clase MiAdaptador
        ArrayList<Producto> productoArrayList2;
        LayoutInflater lInflater;

        //constructor
        public MiAdaptador(Context context,ArrayList<Producto> productos) {
            this.productoArrayList2 = productos;
            this.lInflater=LayoutInflater.from(context);
        }

        //métodos que nos pide crear la clase BaseAdapter
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
            TextView txtVwNomP=(TextView)convertView.findViewById(R.id.txtVwNombreP);
            TextView txtVwDescP=(TextView)convertView.findViewById(R.id.txtVwDescProList);
            TextView txtVwPreP=(TextView)convertView.findViewById(R.id.txtVwPrecList);
            TextView txtVwUser = (TextView) convertView.findViewById(R.id.txtVwUserList);

            txtVwDescP.setText("Descripción: "+productoArrayList2.get(position).getDescripcion());
            txtVwNomP.setText(productoArrayList2.get(position).getNombre());
            txtVwPreP.setText("Precio: "+productoArrayList2.get(position).getPrecio()+" Pesos");
            txtVwUser.setText("Vendedor: " + productoArrayList2.get(position).getUser());

            return convertView;
        }

    }//fin de la clase MiAdaptador

}//fin de la clase actividad
