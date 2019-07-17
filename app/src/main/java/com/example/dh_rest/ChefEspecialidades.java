package com.example.dh_rest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dh_rest.Adapter.PratosAdapter;
import com.example.dh_rest.Adapter.TadashiTypesAdapter;
import com.example.dh_rest.Interfaces.PratosListener;
import com.example.dh_rest.Model.Prato;
import com.example.dh_rest.Model.TadashiTypes;
import com.example.dh_rest.R;

import java.util.List;

public class ChefEspecialidades extends AppCompatActivity implements PratosListener {

    private ImageView chefImage;
    private TextView chefText;
    private TadashiTypes tadashiOfChoice;

//    public ChefEspecialidades(TadashiTypes tadashiOfChoice){
//        this.tadashiOfChoice = tadashiOfChoice;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_especialidades);

        tadashiOfChoice = (TadashiTypes) this.getIntent().getExtras().getSerializable("TADASHIOFCHOICE");

        chefImage = findViewById(R.id.chef_imagem);
        chefText = findViewById(R.id.chef_text);

        chefText.setText(tadashiOfChoice.getMaisDetalhes());
        chefImage.setImageResource(tadashiOfChoice.getPersonaBanner());

        PratosAdapter pratosAdapter = new PratosAdapter(tadashiOfChoice.getListaDePratos(), this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.chef_recycler);
        recyclerView.setAdapter(pratosAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    @Override
    public void onPratosClicado(Prato prato) {
//        Toast.makeText(this, "VOCE ME CLICOU", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, PratoDetalhe.class);
        Bundle bundle = new Bundle();

        // Para poder adicionar um Pais ao bundle, a classe tem que implementar "Serializable"
        bundle.putSerializable("PRATO_SELECIONADO", prato);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
