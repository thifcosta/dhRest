package com.example.dh_rest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dh_rest.Adapter.TadashiTypesAdapter;
import com.example.dh_rest.Interfaces.TadashiTypesListener;
import com.example.dh_rest.Model.TadashiTypes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TadashiTypesListener {

    private String userNome;
    private String userEmail;
    private TextView nomeDisplay;
    private TextView mailDisplay;
    private List<TadashiTypes> listaDeTadashis = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeDisplay = findViewById(R.id.main_nome_display);
        mailDisplay = findViewById(R.id.main_mail_display);

        //Buscar infos através do bundle recebido
        Intent intent = getIntent();
        if(intent!=null){
            Bundle bundle = intent.getExtras();
            if(bundle!=null){
                userNome = bundle.getString("NOME","Nome não digitado...");
                userEmail = bundle.getString("EMAIL","E-mail não digitado...");
            }
        }

        nomeDisplay.setText("Bem vindo, "+userNome+"!");
        mailDisplay.setText("E-mail: "+userEmail);

        TadashiTypes tadashi01 = new TadashiTypes();
        tadashi01.setNome("Tadashi Junior");
        tadashi01.setDefinition("Comida rápida,\npronta em 10 minutos!");
        tadashi01.setImagem(R.drawable.tada_01);
        listaDeTadashis.add(tadashi01);

        TadashiTypes tadashi02 = new TadashiTypes();
        tadashi02.setNome("Tadashi Senior");
        tadashi02.setDefinition("Banquete com\no vovô Tadashi!");
        tadashi02.setImagem(R.drawable.tada_02);
        listaDeTadashis.add(tadashi02);

        TadashiTypes tadashi03 = new TadashiTypes();
        tadashi03.setNome("Tadashi LatinLover");
        tadashi03.setDefinition("Aperitivos para\nimpressionar a sua gata");
        tadashi03.setImagem(R.drawable.tada_03);
        listaDeTadashis.add(tadashi03);

        TadashiTypes tadashi04 = new TadashiTypes();
        tadashi04.setNome("Tadashi GoodVibes");
        tadashi04.setDefinition("Lanches pra degustar\ndepois de pegar onda");
        tadashi04.setImagem(R.drawable.tada_04);
        listaDeTadashis.add(tadashi04);

        TadashiTypesAdapter tadashiTypesAdapter = new TadashiTypesAdapter(listaDeTadashis, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.main_recycler);
        recyclerView.setAdapter(tadashiTypesAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onTadashiTypesClicado(TadashiTypes tadashitypes) {

        Intent intent = new Intent(this, TadashiTypeSelected.class);
        Bundle bundle = new Bundle();

        // Para poder adicionar um Pais ao bundle, a classe tem que implementar "Serializable"
        bundle.putSerializable("TADASHITYPES", tadashitypes);
        intent.putExtras(bundle);

        startActivity(intent);

    }
}
