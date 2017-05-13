package com.example.iossenac.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.iossenac.listview.R;
import com.example.iossenac.listview.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatoAdapter extends BaseAdapter {

    private List<Contato> contatos;
    private Context contexto;

    public ContatoAdapter(List<Contato> contatos, Context contexto) {
        this.contatos = contatos;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return contatos.size();
    }

    @Override
    public Object getItem(int position) {
        return contatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contato contato = contatos.get(position);

        LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.contato_adapter_activity, null);

        TextView txtNome = (TextView) view.findViewById(R.id.txtNome);
        txtNome.setText(contato.getNome());

        TextView txtTelefone = (TextView) view.findViewById(R.id.txtTelefone);
        txtTelefone.setText(contato.getTelefone());

        return view;
    }
}
