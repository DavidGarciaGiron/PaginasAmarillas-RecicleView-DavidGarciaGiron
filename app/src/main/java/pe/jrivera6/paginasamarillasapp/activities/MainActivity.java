package pe.jrivera6.paginasamarillasapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.jrivera6.paginasamarillasapp.R;
import pe.jrivera6.paginasamarillasapp.repositories.EmpresaRepository;

public class MainActivity extends AppCompatActivity {

    private EditText txtBuscar;
    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBuscar = findViewById(R.id.txtBuscar);
        btnBuscar = findViewById(R.id.btnAcpetar);



        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ListaDatosActivity.class);

                String filtro = txtBuscar.getText().toString().toLowerCase();
                if (filtro.isEmpty()){
                    Toast.makeText(MainActivity.this,"Ingresar datos",Toast.LENGTH_SHORT).show();
                    return;
                }
                intent.putExtra("filtro", filtro);
                startActivity(intent);
            }
        });
    }
}
