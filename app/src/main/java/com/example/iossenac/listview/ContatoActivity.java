package com.example.iossenac.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        contatos.add(new Contato("Adriano", "33441133"));
        contatos.add(new Contato("Bruno", "33441133"));
        contatos.add(new Contato("Cássio", "33441133"));

        ContatoAdapter adapter = new ContatoAdapter(contatos, this);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ContatoActivity.this, contatos.get(position).getNome(), Toast.LENGTH_SHORT).show();//CASO SEJA CRIADA UMA CLASSE EXTERNA É NECESSÁRIO PASSA POR PARAMETRO O CONTEXTO
            }
        });
    }
}
