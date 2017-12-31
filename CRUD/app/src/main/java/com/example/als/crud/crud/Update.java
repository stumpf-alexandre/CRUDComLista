package com.example.als.crud.crud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.als.crud.Estudante;

/**
 * Created by als on 12/12/2017.
 */

public class Update {
    public boolean addEstudante(Estudante estudante){
        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("UID", estudante.getUID());
        cv.put("NOME", estudante.getNome());
        cv.put("CGU", estudante.getCGU());

        return db.insert(MainDB.TABELA_ESTUDANTE, null, cv) != -1;
    }

    public boolean updateEstudante(Estudante estudante){
        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("UID", estudante.getUID());
        cv.put("NOME", estudante.getNome());
        cv.put("CGU", estudante.getCGU());

        String where = "UID = '" + estudante.getUID() + "'";

        return db.update(MainDB.TABELA_ESTUDANTE, cv, where, null) > 0;
    }
}
