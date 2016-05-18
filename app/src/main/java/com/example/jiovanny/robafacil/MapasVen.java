package com.example.jiovanny.robafacil;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapasVen extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private Bundle bundleEstado;
    private Intent intentEstado;
    private String estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas_ven);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        /*intentEstado=getIntent();
        bundleEstado=intentEstado.getExtras();
        estado=bundleEstado.getString("ESTADO");
        Toast.makeText(getApplicationContext(),estado,Toast.LENGTH_LONG).show();*/
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        estado=bundle.getString("ESTADO","ESTADO NO ENCONTRADO");
        Toast.makeText(getApplicationContext(),estado,Toast.LENGTH_SHORT).show();

    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera


        switch (estado){
            case "Aguascalientes":
                LatLng aguascalientes = new LatLng(21.8857199,-102.3613407);
                mMap.addMarker(new MarkerOptions().position(aguascalientes).title("Aguascalientes"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(aguascalientes));
                break;
            case "Baja California":
                LatLng bajacalifornia = new LatLng(30.3401527,-117.2724874);
                mMap.addMarker(new MarkerOptions().position(bajacalifornia).title("Baja California"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(bajacalifornia));
                break;
            case "Baja California Sur":
                LatLng bajacaliforniasur = new LatLng(25.419102,-114.558323);
                mMap.addMarker(new MarkerOptions().position(bajacaliforniasur).title("Baja California Sur"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(bajacaliforniasur));
                break;
            case "Campeche":
                LatLng campeche = new LatLng(19.3168611,-93.0398177);
                mMap.addMarker(new MarkerOptions().position(campeche).title("Campeche"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(campeche));
                break;
            case "Chiapas":
                LatLng chiapas = new LatLng(16.2456606,-94.4998304);
                mMap.addMarker(new MarkerOptions().position(chiapas).title("Chiapas"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(chiapas));
                break;
            case "Chihuahua":
                LatLng chihuahua = new LatLng(28.5973705,-110.6875034);
                mMap.addMarker(new MarkerOptions().position(chihuahua).title("Chihuahua"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(chihuahua));
                break;
            case "Coahuila":
                LatLng coahuila = new LatLng(27.1934727,-104.1462227);
                mMap.addMarker(new MarkerOptions().position(coahuila).title("Coahuila"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(coahuila));
                break;
            case "Colima":
                LatLng colima = new LatLng(19.2400444,-103.7636275);
                mMap.addMarker(new MarkerOptions().position(colima).title("Colima"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(colima));
                break;
            case "Durango":
                LatLng durango = new LatLng(24.0226824,-104.7177659);
                mMap.addMarker(new MarkerOptions().position(durango).title("Durango"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(durango));
                break;
            case "Distrito Federal":
                LatLng distritofederal = new LatLng(19.3202829,-99.4328191);
                mMap.addMarker(new MarkerOptions().position(distritofederal).title("Distrito Federal"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(distritofederal));
                break;
            case "Estado de Mexico":
                LatLng edomexico = new LatLng(19.3229768,-100.7264897);
                mMap.addMarker(new MarkerOptions().position(edomexico).title("Estado de Mexico"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(edomexico));
                break;
            case "Guanajuato":
                LatLng guanajuato = new LatLng(20.8724289,-102.0056661);
                mMap.addMarker(new MarkerOptions().position(guanajuato).title("Guanajuato"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(guanajuato));
                break;
            case "Guerrero":
                LatLng guerrero = new LatLng(17.5892215,-102.3409117);
                mMap.addMarker(new MarkerOptions().position(guerrero).title("Guerrero"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(guerrero));
                break;
            case "Hidalgo":
                LatLng hidalgo = new LatLng(20.0826668,-98.8268193);
                mMap.addMarker(new MarkerOptions().position(hidalgo).title("Hidalgo"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(hidalgo));
                break;
            case "Jalisco":
                LatLng jalisco = new LatLng(20.8234373,-105.8476389);
                mMap.addMarker(new MarkerOptions().position(jalisco).title("Jalisco"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(jalisco));
                break;
            case "Michoacan":
                LatLng michoacan = new LatLng(19.1513299,-103.0220921);
                mMap.addMarker(new MarkerOptions().position(michoacan).title("Michoacan"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(michoacan));
                break;
            case "Morelos":
                LatLng morelos = new LatLng(18.7312035,-99.6242042);
                mMap.addMarker(new MarkerOptions().position(morelos).title("Morelos"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(morelos));
                break;
            case "Nayarit":
                LatLng nayarit = new LatLng(21.8400715,-105.9266843);
                mMap.addMarker(new MarkerOptions().position(nayarit).title("Nayarit"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(nayarit));
                break;
            case "Nuevo Leon":
                LatLng nuevoleon = new LatLng(25.4638324,-102.0589216);
                mMap.addMarker(new MarkerOptions().position(nuevoleon).title("Nuevo Leon"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(nuevoleon));
                break;
            case "Oaxaca":
                LatLng oaxaca = new LatLng(17.1510524,-98.4551808);
                mMap.addMarker(new MarkerOptions().position(oaxaca).title("Oaxaca"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(oaxaca));
                break;
            case "Puebla":
                LatLng puebla = new LatLng(19.3366859,-100.1426196);
                mMap.addMarker(new MarkerOptions().position(puebla).title("Puebla"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(puebla));
                break;
            case "Queretaro":
                LatLng queretaro = new LatLng(20.8388621,-100.9413067);
                mMap.addMarker(new MarkerOptions().position(queretaro).title("Queretaro"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(queretaro));
                break;
            case "Quintana Roo":
                LatLng quintanaroo = new LatLng(19.726821,-90.2485818);
                mMap.addMarker(new MarkerOptions().position(quintanaroo).title("Quintana Roo"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(quintanaroo));
                break;
            case "San Luis Potosi":
                LatLng sanlupot = new LatLng(22.8101136,-102.5558838);
                mMap.addMarker(new MarkerOptions().position(sanlupot).title("San Luis Potosi"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sanlupot));
                break;
            case "Sinaloa":
                LatLng sinaloa = new LatLng(24.7379982,-109.6644981);
                mMap.addMarker(new MarkerOptions().position(sinaloa).title("Sinaloa"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sinaloa));
                break;
            case "Sonora":
                LatLng sonora = new LatLng(29.3199825,-116.2349574);
                mMap.addMarker(new MarkerOptions().position(sonora).title("Sonora"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sonora));
                break;
            case "Tabasco":
                LatLng tabasco = new LatLng(17.9473782,-93.6802631);
                mMap.addMarker(new MarkerOptions().position(tabasco).title("Tabasco"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(tabasco));
                break;
            case "Tamaulipas":
                LatLng tamaulipas = new LatLng(24.9262311,-100.8893849);
                mMap.addMarker(new MarkerOptions().position(tamaulipas).title("Tamaulipas"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(tamaulipas));
                break;
            case "Tlaxcala":
                LatLng tlaxcala = new LatLng(19.5039621,-98.8949103);
                mMap.addMarker(new MarkerOptions().position(tlaxcala).title("Tlaxcala"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(tlaxcala));
                break;
            case "Veracruz":
                LatLng veracruz = new LatLng(19.790338,-98.3897559);
                mMap.addMarker(new MarkerOptions().position(veracruz).title("Veracruz"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(veracruz));
                break;
            case "Yucatan":
                LatLng yucatan = new LatLng(20.5840785,-90.0915714);
                mMap.addMarker(new MarkerOptions().position(yucatan).title("Yucatan"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(yucatan));
                break;
            case "Zacatecas":
                LatLng zacatecas = new LatLng(23.0676908,-104.7927977);
                mMap.addMarker(new MarkerOptions().position(zacatecas).title("Zacatecas"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(zacatecas));
                break;
        }
    }
}
