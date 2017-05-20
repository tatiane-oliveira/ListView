package com.example.iossenac.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.iossenac.listview.adapter.ContatoAdapter;
import com.example.iossenac.listview.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatoActivity extends AppCompatActivity {

    private List<Contato> contatos = new ArrayList<Contato>();
    private ContatoAdapter adapter;
    private static int REQ_CADASTRO = 1;
    private static int REQ_EDICAO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("CicloDeVida", "Criando a activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        contatos.add(new Contato("Adriano", "33441133"));
        contatos.add(new Contato("Bruno", "33441133"));
        contatos.add(new Contato("Cássio", "33441133"));

        adapter = new ContatoAdapter(contatos, this);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = contatos.get(position).getNome();
                String telefone = contatos.get(position).getTelefone();
                Intent i = new Intent(ContatoActivity.this, FormularioActivity.class);
                i.putExtra("contato", contatos.get(position));
                startActivityForResult(i, REQ_EDICAO);
                //Toast.makeText(ContatoActivity.this, contatos.get(position).getNome(), Toast.LENGTH_SHORT).show();//CASO SEJA CRIADA UMA CLASSE EXTERNA É NECESSÁRIO PASSA POR PARAMETRO O CONTEXTO
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CADASTRO) {
            if (resultCode == RESULT_OK) {
                Contato contato = (Contato) data.getSerializableExtra("contato");
                contatos.add(contato);
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void iniciaCadastro(View v) {
        Intent i = new Intent(this, FormularioActivity.class);
        startActivityForResult(i, REQ_CADASTRO);
    }

    public void cancelar(View view) {
        finish();
    }
}
