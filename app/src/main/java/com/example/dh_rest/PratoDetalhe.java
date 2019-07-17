package com.example.dh_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dh_rest.Model.Prato;
import com.example.dh_rest.Model.TadashiTypes;

import de.hdodenhof.circleimageview.CircleImageView;

public class PratoDetalhe extends AppCompatActivity{

    public Prato pratoOfChoice;
    public TextView nomeDoPrato;
    public TextView tempoDePreparo;
    public CircleImageView pratoImagem;
    public TextView pratoReceita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prato_detalhe);

        pratoOfChoice = (Prato) this.getIntent().getExtras().getSerializable("PRATO_SELECIONADO");

        nomeDoPrato = findViewById(R.id.prato_detalhe_nome);
        tempoDePreparo = findViewById(R.id.prato_detalhe_tempo_preparo);
        pratoImagem = findViewById(R.id.prato_detalhe_imagem);
        pratoReceita = findViewById(R.id.prato_detalhe_receita);

        nomeDoPrato.setText(pratoOfChoice.getNome());
        tempoDePreparo.setText(pratoOfChoice.getTempoDePreparo());
        pratoImagem.setImageResource(pratoOfChoice.getImage());
        pratoReceita.setText(pratoOfChoice.getReceita());

    }
}
