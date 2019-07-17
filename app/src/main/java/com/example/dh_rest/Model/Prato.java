package com.example.dh_rest.Model;

import java.io.Serializable;

public class Prato implements Serializable {

    private String nome;
    private int image;
    private String receita;
    private String tempoDePreparo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public String getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(String tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }
}
