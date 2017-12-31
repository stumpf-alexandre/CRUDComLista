package com.example.als.crud.crud;

import android.database.sqlite.SQLiteDatabase;

import com.example.als.crud.Estudante;

/**
 * Created by als on 12/12/2017.
 */

public class Delete {
    public boolean removerEstudante(Estudante estudante){
        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        String query = "UID = '" +estudante.getUID() + "'";
        return db.delete(MainDB.TABELA_ESTUDANTE, query, null) > 0;
    }
}
