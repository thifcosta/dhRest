package com.example.dh_rest.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dh_rest.Interfaces.PratosListener;
import com.example.dh_rest.Model.Prato;
import com.example.dh_rest.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PratosAdapter extends RecyclerView.Adapter<PratosAdapter.ViewHolder>{
    private List<Prato> listaDePratos;
    private PratosListener pratosListener;

    public PratosAdapter(List<Prato> listaDePratos, PratosListener pratosListener){
        this.listaDePratos = listaDePratos;
        this.pratosListener = pratosListener;
    }

    @NonNull
    @Override
    public PratosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detalhe_prato, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Prato prato = listaDePratos.get(position);
        viewHolder.setupPratos(prato);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pratosListener.onPratosClicado(prato);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDePratos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nomeDoPrato;
        private TextView tempoDePreparo;
        private CircleImageView imagemPrato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeDoPrato = itemView.findViewById(R.id.prato_detalhe_nome);
            tempoDePreparo = itemView.findViewById(R.id.prato_tempo_preparo);
            imagemPrato = itemView.findViewById(R.id.prato_detalhe_imagem);
        }

        public void setupPratos(Prato prato) {
            nomeDoPrato.setText(prato.getNome());
            tempoDePreparo.setText(prato.getTempoDePreparo());
            imagemPrato.setImageResource(prato.getImage());
        }
    }
}
