package com.example.dh_rest.Model;

import java.io.Serializable;
import java.util.List;

public class TadashiTypes implements Serializable {

    private String nome;
    private String definition;
    private String maisDetalhes;
    private int personaImage;
    private int personaBanner;
    private List<Prato> listaDePratos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getPersonaImage() {
        return personaImage;
    }

    public void setPersonaImage(int personaImage) {
        this.personaImage = personaImage;
    }

    public int getPersonaBanner() {
        return personaBanner;
    }

    public void setPersonaBanner(int personaBanner) {
        this.personaBanner = personaBanner;
    }

    public String getMaisDetalhes() {
        return maisDetalhes;
    }

    public void setMaisDetalhes(String maisDetalhes) {
        this.maisDetalhes = maisDetalhes;
    }

    public List<Prato> getListaDePratos() {
        return listaDePratos;
    }

    public void setListaDePratos(List<Prato> listaDePratos) {
        this.listaDePratos = listaDePratos;
    }
}
