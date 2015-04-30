package com.ifg.haney.cadastrodecliente;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class TelaDeCadastro extends ActionBarActivity {

    EditText nome, cpf, rg, endereco, bairro, cidade, uf, nomeDoPai, nomeDaMae, dataNascimento, localNascimento;
    public static final String NOME = "objeto";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_cadastro);

        nome = (EditText) findViewById(R.id.editTextNome);
        cpf = (EditText) findViewById(R.id.editTextCPF);
        rg = (EditText) findViewById(R.id.editTextRG);
        endereco = (EditText) findViewById(R.id.editTextEndereco);
        bairro = (EditText) findViewById(R.id.editTextBairro);
        cidade = (EditText) findViewById(R.id.editTextCidade);
        uf = (EditText) findViewById(R.id.editTextUF);
        nomeDoPai = (EditText) findViewById(R.id.editTextNomePai);
        nomeDaMae = (EditText) findViewById(R.id.editTextNomeMae);
        dataNascimento = (EditText) findViewById(R.id.editTextDataNascimento);
        localNascimento = (EditText) findViewById(R.id.editTextLocalNascimento);
    }

    public void enviar (View v) {

        ObjetoDeTransporte obj = new ObjetoDeTransporte();

        obj.setNome(nome.getText().toString());
        obj.setCpf(cpf.getText().toString());
        obj.setRg(rg.getText().toString());
        obj.setEndereco(endereco.getText().toString());
        obj.setBairro(bairro.getText().toString());
        obj.setCidade(cidade.getText().toString());
        obj.setUf(uf.getText().toString());
        obj.setNomeDoPai(nomeDoPai.getText().toString());
        obj.setNomeDaMae(nomeDaMae.getText().toString());
        obj.setDataNascimento(dataNascimento.getText().toString());
        obj.setLocalNascimento(localNascimento.getText().toString());

        Intent i = new Intent(this, TelaDadosCadastrados.class);
        i.putExtra(NOME, obj);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_de_cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
