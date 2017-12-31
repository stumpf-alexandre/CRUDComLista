package com.example.als.crud;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.als.crud.crud.Read;

import java.util.ArrayList;

public class MainListaActivity extends AppCompatActivity {
    ArrayList<Estudante> itemList ;
    Adapter adapter = new Adapter(itemList, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Read read = new Read();
        itemList = read.getEstudantes();
        if (itemList.size() != 0) {
            ListView lv;
            setContentView(R.layout.activity_main_lista);
            lv = (ListView) findViewById(R.id.listView);
            adapter = new Adapter(itemList, this);
            lv.setAdapter(adapter);
        }
        else {
            Context context = getApplicationContext();
            int tempo = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "Lista Vazia", tempo);
            toast.show();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
