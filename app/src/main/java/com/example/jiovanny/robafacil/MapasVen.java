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
        intentEstado=getIntent();
        bundleEstado=intentEstado.getExtras();
        estado=bundleEstado.getString("ESTADO");
        Toast.makeText(getApplicationContext(),estado,Toast.LENGTH_LONG).show();
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
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        switch (estado){
            case "Aguascalientes":
                break;
            case "Baja California":
                break;
            case "Baja California Sur":
                break;
            case "Campeche":
                break;
            case "Chiapas":
                break;
            case "Chihuahua":
                break;
            case "Coahuila":
                break;
            case "Colima":
                break;
            case "Durango":
                break;
            case "Distrito Federal":
                break;
            case "Estado de Mexico":
                break;
            case "Guanajuato":
                break;
            case "Guerrero":
                break;
            case "Hidalgo":
                break;
            case "Jalisco":
                break;
            case "Michoacan":
                break;
            case "Morelos":
                break;
            case "Nayarit":
                break;
            case "Nuevo Leon":
                break;
            case "Oaxaca":
                break;
            case "Puebla":
                break;
            case "Queretaro":
                break;
            case "Quintana Roo":
                break;
            case "San Luis Potosi":
                break;
            case "Sinaloa":
                break;
            case "Sonora":
                break;
            case "Tabasco":
                break;
            case "Tamaulipas":
                break;
            case "Tlaxcala":
                break;
            case "Veracruz":
                break;
            case "Yucatan":
                break;
            case "Zacatecas":
                break;
        }
    }
}
