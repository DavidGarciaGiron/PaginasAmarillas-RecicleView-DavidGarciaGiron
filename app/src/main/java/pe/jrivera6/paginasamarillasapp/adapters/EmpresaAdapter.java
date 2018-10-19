package pe.jrivera6.paginasamarillasapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.jrivera6.paginasamarillasapp.R;
import pe.jrivera6.paginasamarillasapp.activities.InformacionActivity;
import pe.jrivera6.paginasamarillasapp.models.Empresa;

public class EmpresaAdapter extends RecyclerView.Adapter<EmpresaAdapter.ViewHolder> {

    private List<Empresa> empresas;

    public EmpresaAdapter(){
        empresas = new ArrayList<>();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView logo;

        TextView txtNombreEmp;
        TextView txtDireccion;
        TextView txtTelefono;

        public ViewHolder(View itemView) {
            super(itemView);

            logo = itemView.findViewById(R.id.logo);
            txtNombreEmp = itemView.findViewById(R.id.txtNombreEmp);
            txtDireccion = itemView.findViewById(R.id.txtDireccion);
            txtTelefono = itemView.findViewById(R.id.txtTelefono);

        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.empresa_items,null,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {



        final Empresa empresa = empresas.get(position);
        holder.txtNombreEmp.setText(empresa.getNombre());
        holder.txtDireccion.setText(empresa.getDireccion());
        holder.txtTelefono.setText(String.valueOf(empresa.getTelefono()));

        final Context context = holder.itemView.getContext();
        int idRes = context.getResources().getIdentifier(empresa.getLogo(),"drawable", context.getPackageName());
        holder.logo.setImageResource(idRes);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idObjeto =  empresa.getId();

                Toast.makeText(context,"Respuesta correcta",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, InformacionActivity.class);
                intent.putExtra("idObjeto",idObjeto);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return empresas.size();
    }

    public void setEmpresas(List<Empresa> empresas){
        this.empresas = empresas;
    }

}
