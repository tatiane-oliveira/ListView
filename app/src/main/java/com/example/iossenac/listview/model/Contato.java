package com.example.iossenac.listview.model;

import java.io.Serializable;

/**
 * Created by iossenac on 13/05/17.
 */

public class Contato implements Serializable {

    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
