package com.example.iossenac.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<String> paises = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paises.add("Argentina");
        paises.add("Brasil");
        paises.add("Canadá");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises);
        ListView listView = (ListView) findViewById(R.id.lvPais);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void catalogarPais(View v) {
        EditText txtPais = (EditText) findViewById(R.id.txtPais);
        String novoPais = txtPais.getText().toString();
        if (!novoPais.isEmpty()) {
            paises.add(novoPais);
            adapter.notifyDataSetChanged();
        }
        txtPais.setText("");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, paises.get(position), Toast.LENGTH_SHORT).show();
    }
}
