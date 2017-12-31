package com.example.als.crud.crud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.als.crud.Estudante;

import java.util.ArrayList;

/**
 * Created by als on 12/12/2017.
 */

public class Read {
    public ArrayList<Estudante> getEstudantes(){
        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TABELA_ESTUDANTE;
        ArrayList<Estudante> estudantes = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()){
            do {
                Estudante estudante =new Estudante(c.getString(0));
                estudante.setNome(c.getString(1));
                estudante.setCGU(c.getInt(2));
                estudantes.add(estudante);
            }while (c.moveToNext());
        }

        return estudantes;
    }
}
