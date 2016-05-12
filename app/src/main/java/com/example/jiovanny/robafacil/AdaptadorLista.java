package com.example.jiovanny.robafacil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by daniel on 09/05/2016.
 */
public class AdaptadorLista extends ArrayAdapter<String> {
    private Context context;
    private String []nombreP,descP,precioP,vendedorP;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.mostrarproductos, parent, false);

        TextView txtVwNomP=(TextView)convertView.findViewById(R.id.txtVwNombreP);
        TextView txtVwDescP=(TextView)convertView.findViewById(R.id.txtVwDescProList);
        TextView txtVwPreP=(TextView)convertView.findViewById(R.id.txtVwPrecList);
        TextView txtVwUser = (TextView) convertView.findViewById(R.id.txtVwUserList);

        txtVwDescP.setText("Descripción: "+descP[position]);
        txtVwNomP.setText(nombreP[position]);
        txtVwPreP.setText("Precio: "+precioP[position]+" Pesos");
        txtVwUser.setText("Vendedor: " + vendedorP[position]);
        return convertView;
    }

    @Override
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String[] getNombreP() {
        return nombreP;
    }

    public void setNombreP(String[] nombreP) {
        this.nombreP = nombreP;
    }

    public String[] getDescP() {
        return descP;
    }

    public void setDescP(String[] descP) {
        this.descP = descP;
    }

    public String[] getPrecioP() {
        return precioP;
    }

    public void setPrecioP(String[] precioP) {
        this.precioP = precioP;
    }

    public String[] getVendedorP() {
        return vendedorP;
    }

    public void setVendedorP(String[] vendedorP) {
        this.vendedorP = vendedorP;
    }

    public AdaptadorLista(Context context, int resource, int textViewResourceId, String[] objects) {
        super(context, resource, textViewResourceId, objects);
        this.context=context;
    }
}
