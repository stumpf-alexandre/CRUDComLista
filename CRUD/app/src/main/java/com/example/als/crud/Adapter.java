package com.example.als.crud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by als on 13/12/2017.
 */

public class Adapter extends BaseAdapter {
    ArrayList<Estudante> estudante;
    Context context;
    TextView txtNome;

    public Adapter(ArrayList<Estudante> estudante, Context context){
        this.estudante = estudante;
        this.context = context;
    }

    @Override
    public int getCount() {
        return estudante.size();
    }

    @Override
    public Object getItem(int i) {
        return estudante.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View resultView = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        txtNome = resultView.findViewById(R.id.tvNomeItem);
     //   TextView tvCGU = resultView.findViewById(R.id.tvCGUItem);
       // TextView tvUID = resultView.findViewById(R.id.tvUIDItem);

        Estudante est = estudante.get(i);
        txtNome.setText(est.getNome());
       // tvCGU.setText( est.getCGU());
       // tvUID.setText(est.getUID());

        return null;
    }
}
