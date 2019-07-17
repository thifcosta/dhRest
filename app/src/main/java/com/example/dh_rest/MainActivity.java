package com.example.dh_rest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dh_rest.Adapter.TadashiTypesAdapter;
import com.example.dh_rest.Interfaces.TadashiTypesListener;
import com.example.dh_rest.Model.Prato;
import com.example.dh_rest.Model.TadashiTypes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TadashiTypesListener {

    private String userNome;
    private String userEmail;
    private TextView nomeDisplay;
    private TextView mailDisplay;

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

        List<TadashiTypes> listaDeTadashis = generateTadashis();

        TadashiTypesAdapter tadashiTypesAdapter = new TadashiTypesAdapter(listaDeTadashis, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.main_recycler);
        recyclerView.setAdapter(tadashiTypesAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onTadashiTypesClicado(TadashiTypes tadashitypes) {

        Intent intent = new Intent(this, ChefEspecialidades.class);
        Bundle bundle = new Bundle();

        // Para poder adicionar um Pais ao bundle, a classe tem que implementar "Serializable"
        bundle.putSerializable("TADASHIOFCHOICE", tadashitypes);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    // Criar lista de pratos para adicionar a um Tadashi
    public List<Prato> generatePratos(){

        List<Prato> listaDePratos = new ArrayList<>();

        Prato prato01 = new Prato();
        prato01.setNome("Prato 01");
        prato01.setImage(R.drawable.icon_front);
        prato01.setReceita(this.getString(R.string.tempReceita));
        prato01.setTempoDePreparo("Preparo: 15 min.");
        listaDePratos.add(prato01);

        Prato prato02 = new Prato();
        prato02.setNome("Prato 02");
        prato02.setImage(R.drawable.icon_front);
        prato02.setReceita(this.getString(R.string.tempReceita));
        prato02.setTempoDePreparo("Preparo: 18 min.");
        listaDePratos.add(prato02);

        Prato prato03 = new Prato();
        prato03.setNome("Prato 03");
        prato03.setImage(R.drawable.icon_front);
        prato03.setReceita(this.getString(R.string.tempReceita));
        prato03.setTempoDePreparo("Preparo: 25 min.");
        listaDePratos.add(prato03);

        Prato prato04 = new Prato();
        prato04.setNome("Prato 04");
        prato04.setImage(R.drawable.icon_front);
        prato04.setReceita(this.getString(R.string.tempReceita));
        prato04.setTempoDePreparo("Preparo: 40 min.");
        listaDePratos.add(prato04);

        Prato prato05 = new Prato();
        prato05.setNome("Prato 05");
        prato05.setImage(R.drawable.icon_front);
        prato05.setReceita(this.getString(R.string.tempReceita));
        prato05.setTempoDePreparo("Preparo: 29 min.");
        listaDePratos.add(prato05);

        Prato prato06 = new Prato();
        prato06.setNome("Prato 06");
        prato06.setImage(R.drawable.icon_front);
        prato06.setReceita(this.getString(R.string.tempReceita));
        prato06.setTempoDePreparo("Preparo: 37 min.");
        listaDePratos.add(prato06);

        return listaDePratos;
    }

    // Cria lista de Tadashis com todas as infos necessárias para o projeto
    public List<TadashiTypes> generateTadashis(){

        List<TadashiTypes> listaDeTadashis = new ArrayList<>();

        TadashiTypes tadashi01 = new TadashiTypes();
        tadashi01.setNome("Tadashi Junior");
        tadashi01.setDefinition("Cozinheiro iniciante,\npratos simples de fazer!");
        tadashi01.setPersonaImage(R.drawable.tada_01);
        tadashi01.setPersonaBanner(R.drawable.bg_chef_tadashi_junior);
        tadashi01.setMaisDetalhes("Boa escolha para começar!\nConheça pratos simples deliciosos:");
        tadashi01.setListaDePratos(generatePratos());
        listaDeTadashis.add(tadashi01);

        TadashiTypes tadashi02 = new TadashiTypes();
        tadashi02.setNome("Tadashi Senior");
        tadashi02.setDefinition("Cozinheiro experiente,\num banquete na certa!");
        tadashi02.setPersonaImage(R.drawable.tada_02);
        tadashi02.setPersonaBanner(R.drawable.bg_chef_tadashi_senior);
        tadashi02.setMaisDetalhes("Se você já é veterano na cozinha,\nconheça as especialidades do vovô Tadashi:");
        tadashi02.setListaDePratos(generatePratos());
        listaDeTadashis.add(tadashi02);

        TadashiTypes tadashi03 = new TadashiTypes();
        tadashi03.setNome("Tadashi LatinLover");
        tadashi03.setDefinition("Aperitivos para\nimpressionar a sua gata");
        tadashi03.setPersonaImage(R.drawable.tada_03);
        tadashi03.setPersonaBanner(R.drawable.bg_chef_tadashi_latin_lover);
        tadashi03.setMaisDetalhes("Aperitivos calientes!\nCaptura las chicas con:");
        tadashi03.setListaDePratos(generatePratos());
        listaDeTadashis.add(tadashi03);

        TadashiTypes tadashi04 = new TadashiTypes();
        tadashi04.setNome("Tadashi GoodVibes");
        tadashi04.setDefinition("Lanches pra degustar\ndepois de pegar onda");
        tadashi04.setPersonaImage(R.drawable.tada_04);
        tadashi04.setPersonaBanner(R.drawable.bg_chef_tadashi_good_vibes);
        tadashi04.setMaisDetalhes("Rastaman vibration!\nOs melhores lanches pra por na roda:");
        tadashi04.setListaDePratos(generatePratos());
        listaDeTadashis.add(tadashi04);

        return listaDeTadashis;
    }
}
