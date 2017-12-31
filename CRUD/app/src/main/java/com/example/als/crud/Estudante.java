package com.example.als.crud;

import java.util.Random;

/**
 * Created by als on 12/12/2017.
 */

public class Estudante {

    private String nome;
    private long CGU;
    private final String UID;

    public Estudante(String UID){
        this.UID = UID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCGU(){
        return Long.toString(CGU);
    }

    public void setCGU(long CGU) {
        this.CGU = CGU;
    }

    public String getUID() {
        return UID;
    }

    public static String criarUID(){
        return "@Estudante: " + System.currentTimeMillis() + new Random().nextDouble();
    }
}
