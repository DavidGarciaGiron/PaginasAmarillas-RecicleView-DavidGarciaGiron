package pe.jrivera6.paginasamarillasapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pe.jrivera6.paginasamarillasapp.R;
import pe.jrivera6.paginasamarillasapp.adapters.EmpresaAdapter;
import pe.jrivera6.paginasamarillasapp.repositories.EmpresaRepository;

public class ListaDatosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardView cardView;
    private ImageView logoEmpresa;
    private TextView nombreEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_datos);

        recyclerView = findViewById(R.id.lista_empresas);
        cardView = findViewById(R.id.cardView);
        nombreEmp = findViewById(R.id.txtNombreEmp);


        cargarDatos();

    }

    public void cargarDatos(){
        Bundle extras = getIntent().getExtras();
        final String nombreBuscar = extras.getString("filtro");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        EmpresaAdapter empresaAdapter = new EmpresaAdapter();

        empresaAdapter.setEmpresas(EmpresaRepository.getFiltro(nombreBuscar));
        recyclerView.setAdapter(empresaAdapter);
    }

}
