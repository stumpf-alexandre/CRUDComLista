package com.example.als.crud;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.als.crud.crud.Create;
import com.example.als.crud.crud.Delete;
import com.example.als.crud.crud.MainDB;
import com.example.als.crud.crud.Read;
import com.example.als.crud.crud.Update;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etNome, etCGU, etPosicao;
    private Estudante estudantePraEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = (EditText) findViewById(R.id.edt_nome);
        etCGU = (EditText) findViewById(R.id.edt_cgu);
        etPosicao = (EditText) findViewById(R.id.edt_posicao);
        Button btnListView;

        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnCarregarEstudante).setOnClickListener(this);
        findViewById(R.id.btnEdt).setOnClickListener(this);
        findViewById(R.id.btnRemover).setOnClickListener(this);
        findViewById(R.id.btnVerLista).setOnClickListener(this);
        btnListView = findViewById(R.id.btnVerLista);

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainListaActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        new Create().createLista();
    }

    @Override
    public void onClick(View view){
        int id = view.getId();

        if (id == R.id.btnAdd){
            adicionarEstudante();
        }
        else if (id == R.id.btnEdt){
            editarEstudante();
        }
        else if (id == R.id.btnCarregarEstudante){
            carregarEstudante();
        }
        else if (id == R.id.btnRemover){
            removerEstudante();
        }
    }

    private void carregarEstudante(){
        if (etPosicao.length() != 0) {
            int posicao = Integer.parseInt(etPosicao.getText().toString());
            ArrayList<Estudante> mEstudantes = new Read().getEstudantes();
            if (posicao >= mEstudantes.size()) {
                Context context = getApplicationContext();
                int tempo = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Estudante não Cadastrado", tempo);
                toast.show();
                etPosicao.setText("");
                return;
            }

            estudantePraEditar = mEstudantes.get(posicao);
            etNome.setText(estudantePraEditar.getNome());
            etCGU.setText(String.valueOf(estudantePraEditar.getCGU()));
        }
        else {
            Context context = getApplicationContext();
            int tempo = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "Preenchimento de Campo Obrigatorio", tempo);
            toast.show();
            limparCampos();
        }
    }

    private void adicionarEstudante(){
        if (etNome.length() != 0 && etCGU.length() != 0) {
            Estudante est = new Estudante(Estudante.criarUID());
            est.setNome(etNome.getText().toString());
            est.setCGU(Integer.parseInt(etCGU.getText().toString()));

            if (new Update().addEstudante(est)) {
                Context context = getApplicationContext();
                int tempo = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Estudante Cadastrado", tempo);
                toast.show();
                limparCampos();
            } else {
                Context context = getApplicationContext();
                int tempo = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Erro ao Cadastrar Estudante", tempo);
                toast.show();
                limparCampos();
            }
        }
        else {
            Context context = getApplicationContext();
            int tempo = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "Preenchimento de Campo Obrigatorio", tempo);
            toast.show();
            limparCampos();
        }
    }

    private void editarEstudante(){
        if (etNome.length() != 0 && etCGU.length() != 0 && etPosicao.length() != 0) {
            estudantePraEditar.setNome(etNome.getText().toString());
            estudantePraEditar.setCGU(Integer.parseInt(etCGU.getText().toString()));

            if (new Update().updateEstudante(estudantePraEditar)) {
                Context context = getApplicationContext();
                int tempo = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Estudante Atualizado", tempo);
                toast.show();
                limparCampos();
            } else {
                Context context = getApplicationContext();
                int tempo = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Erro ao Atualizar Estudante", tempo);
                toast.show();
                limparCampos();
            }
        }
        else {
            Context context = getApplicationContext();
            int tempo = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "Preenchimento de Campo Obrigatório", tempo);
            toast.show();
            limparCampos();
        }
    }

    private void removerEstudante(){
        if (etNome.length() != 0 && etCGU.length() != 0 && etPosicao.length() != 0) {
            estudantePraEditar.setNome(etNome.getText().toString());
            estudantePraEditar.setCGU(Integer.parseInt(etCGU.getText().toString()));


            if (new Delete().removerEstudante(estudantePraEditar)) {
                Context context = getApplicationContext();
                int tempo = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Estudante Removido", tempo);
                toast.show();
                limparCampos();

            } else {
                Context context = getApplicationContext();
                int tempo = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Erro ao Remover Estudante", tempo);
                toast.show();
                limparCampos();
            }
        }
        else {
            Context context = getApplicationContext();
            int tempo = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "Preenchimento de Campo Obrigatório", tempo);
            toast.show();
            limparCampos();
        }
    }

    private void limparCampos(){
        estudantePraEditar = null;
        etNome.setText("");
        etCGU.setText("");
        etPosicao.setText("");
    }

    @Override
    protected void onStop(){
        Context context = getApplicationContext();
        int tempo = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, "BD Fechado", tempo);
        toast.show();
        MainDB.getInstancia().close();

        super.onStop();
    }
}
