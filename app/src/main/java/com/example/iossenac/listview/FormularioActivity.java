package com.example.iossenac.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iossenac.listview.model.Contato;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        verificaOperacao();
    }

    public void cancelar(View v) {
        finish();
    }

    private void verificaOperacao() {
        Intent i = getIntent();
        if (i.getExtras() != null) {
            Contato contato = (Contato) i.getExtras().get("contato");
            EditText telefone = (EditText) findViewById(R.id.edtTelefone);
            telefone.setText(contato.getTelefone());
            telefone.setEnabled(false);

            EditText nome = (EditText) findViewById(R.id.edtNome);
            nome.setText(contato.getNome());
            nome.setEnabled(false);

            Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
            btnCadastrar.setEnabled(false);
        }
    }

    public void cadastrar(View view) {
        EditText nome = (EditText) findViewById(R.id.edtNome);
        EditText telefone = (EditText) findViewById(R.id.edtTelefone);
        Contato contato = new Contato(nome.getText().toString(), telefone.getText().toString());
        Intent data = new Intent();
        data.putExtra("contato", contato);
        setResult(RESULT_OK, data);
        Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }

}
