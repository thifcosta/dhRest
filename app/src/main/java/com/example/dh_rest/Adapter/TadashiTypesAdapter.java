package com.example.dh_rest.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dh_rest.Interfaces.TadashiTypesListener;
import com.example.dh_rest.Model.TadashiTypes;
import com.example.dh_rest.R;

import java.util.List;

public class TadashiTypesAdapter extends RecyclerView.Adapter<TadashiTypesAdapter.ViewHolder>{

    private List<TadashiTypes> listadeTadashis;
    private TadashiTypesListener tadashiTypesListener;

    public TadashiTypesAdapter(List<TadashiTypes> listaDeTadashis, TadashiTypesListener tadashiTypesListener){
        this.listadeTadashis = listaDeTadashis;
        this.tadashiTypesListener = tadashiTypesListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detalhe_tadashi_types, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final TadashiTypes tadashiTypes = listadeTadashis.get(position);
        viewHolder.setupTadashi(tadashiTypes);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tadashiTypesListener.onTadashiTypesClicado(tadashiTypes);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listadeTadashis.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tadashiTypesNome;
        private TextView tadashiTypesDefinition;
        private ImageView tadashiTypesImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tadashiTypesNome = itemView.findViewById(R.id.types_tadashi_type);
            tadashiTypesDefinition = itemView.findViewById(R.id.types_tadashi_description);
            tadashiTypesImage = itemView.findViewById(R.id.types_tadashi_image);
        }

        public void setupTadashi(TadashiTypes tadashiTypes) {
            tadashiTypesNome.setText(tadashiTypes.getNome());
            tadashiTypesDefinition.setText(tadashiTypes.getDefinition());
            tadashiTypesImage.setImageResource(tadashiTypes.getImagem());
        }

    }

}
