package com.example.als.crud.crud;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import com.example.als.crud.MyApp;

/**
 * Created by als on 12/12/2017.
 */

public class MainDB extends SQLiteOpenHelper{
    private static String NOME_DB = "DB";
    private static int VERSAO_DB = 1;
    public static String TABELA_ESTUDANTE = "TABELA_ESTUDANTE";

    private static MainDB instancia;

    public static MainDB getInstancia(){
        if (instancia == null)instancia = new MainDB();
        return instancia;
    }

    private MainDB(){
        super(MyApp.getContext(),NOME_DB,null,VERSAO_DB);
    }
    @Override
    public void onCreate(SQLiteDatabase db){}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}

    @Override
    public synchronized void close(){
        instancia = null;
        super.close();
    }
}
