package pe.jrivera6.paginasamarillasapp.activities;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pe.jrivera6.paginasamarillasapp.R;
import pe.jrivera6.paginasamarillasapp.models.Empresa;
import pe.jrivera6.paginasamarillasapp.repositories.EmpresaRepository;

public class InformacionActivity extends AppCompatActivity {

     TextView nombreEmp, direccionEmp, telefonoEmp, categoriaEmp, descripcionEmp;
     ImageView logoEmp;
     Button btnLlamar, btnEmail, btnWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        nombreEmp = findViewById(R.id.txtNombreEmp);
        direccionEmp = findViewById(R.id.txtDireccion);
        telefonoEmp = findViewById(R.id.txtTelefono);
        categoriaEmp = findViewById(R.id.txtCategoria);
        descripcionEmp = findViewById(R.id.txtDescripcion);
        logoEmp = findViewById(R.id.logoEmp);
        btnLlamar = findViewById(R.id.btnLlamar);
        btnWeb = findViewById(R.id.btnWeb);
        btnEmail = findViewById(R.id.btnEmail);
        recibirDatos();

    }

    private void recibirDatos(){

        Bundle extras = getIntent().getExtras();
        final int idObjeto = extras.getInt("idObjeto");
        EmpresaRepository empresaRepository = new EmpresaRepository();
        Empresa empresa = empresaRepository.buscarId(idObjeto);
        //Log.e("recibirDatos: ",""+empresa.getNombre() );

        final String nomEmpresa = empresa.getNombre();
        String dicEmpresa = empresa.getDireccion();
        final int telef = empresa.getTelefono();
        String catEmpresa = empresa.getCategoria();
        String descEmpresa = empresa.getInfo();
        final String emialEmpresa = empresa.getEmail();
        final String webEmpresa = empresa.getUrl();
        nombreEmp.setText(nomEmpresa);
        direccionEmp.setText(dicEmpresa);
        telefonoEmp.setText(String.valueOf(telef));
        categoriaEmp.setText(catEmpresa);
        descripcionEmp.setText(descEmpresa);
        int id = getResources().getIdentifier(empresa.getLogo(),"drawable",getPackageName());
        logoEmp.setImageResource(id);


        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telef));

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(InformacionActivity.this,new String[]{Manifest.permission.CALL_PHONE}, 0);
                    return;
                }
                startActivity(intent);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www."+webEmpresa));
                startActivity(intent);
            }

        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emialEmpresa});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Correo de prueba");
                intent.putExtra(Intent.EXTRA_TEXT, "Email de prueba para " + nomEmpresa);

                try {
                    startActivity(Intent.createChooser(intent, "Enviar Correo"));
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "No hay aplicacion instalada", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
