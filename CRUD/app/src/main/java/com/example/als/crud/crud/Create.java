package com.example.als.crud.crud;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by als on 12/12/2017.
 */

public class Create {
    public void createLista(){
        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        String colunas = "(UID TEXT, NOME TEXT, CGU INTEGER)";
        String query = "CREATE TABLE IF NOT EXISTS " + MainDB.TABELA_ESTUDANTE + colunas;
        db.execSQL(query);
    }
}