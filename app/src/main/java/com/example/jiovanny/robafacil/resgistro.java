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

public class resgistro extends AppCompatActivity{

    private Spinner spiEstados;
    private ArrayAdapter<CharSequence> adapter;
    private Button btnCrear;
    private EditText edtTxtNombre,edtTxtContra,edtTxtEmail;
    private MyBaseDatos manjadorDb;
    private String estado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnCrear=(Button)findViewById(R.id.btnCrear);
        edtTxtContra=(EditText)findViewById(R.id.txtContra);
        edtTxtNombre=(EditText)findViewById(R.id.txtNombre);
        edtTxtEmail=(EditText)findViewById(R.id.edtTxtEmailReg);

        spiEstados = (Spinner) findViewById(R.id.spiEstados);
        adapter = ArrayAdapter.createFromResource(this, R.array.Estados, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiEstados.setAdapter(adapter);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarSQLite();
            }
        });
        spiEstados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView miTexto= (TextView) view;
                estado=miTexto.getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        manjadorDb = new MyBaseDatos(this,null,null,1);
    }
    public void guardarSQLite(){
        String strError="";
        if (spiEstados.getSelectedItemPosition()==0)
            strError+="Selecciona un estado\n";
        if (edtTxtContra.getText().toString().isEmpty())
            strError+="Ingresa la contraseña\n";
        if (edtTxtEmail.getText().toString().isEmpty())
            strError+="Ingresa tu correo\n";
        if (edtTxtNombre.getText().toString().isEmpty())
            strError+="Ingresa tu nombre\n";
        if (!strError.equals("")){
            strError="Debes llenar los siguientes datos:\n"+strError;
            Toast.makeText(this,strError,Toast.LENGTH_LONG).show();
            return;
        }
        Usuario usr= new Usuario();
        usr.setNombre(edtTxtNombre.getText().toString());
        usr.setContrasena(edtTxtContra.getText().toString());
        usr.setCorreo(edtTxtEmail.getText().toString());
        usr.setEstado(estado);
        manjadorDb.addUsuario(usr);
        Toast.makeText(this,"Usuario Agregado con éxito",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(),Principal.class);
        edtTxtContra.setText("");
        edtTxtEmail.setText("");
        edtTxtNombre.setText("");
        spiEstados.setSelection(0);
        startActivity(intent);

    }


}
