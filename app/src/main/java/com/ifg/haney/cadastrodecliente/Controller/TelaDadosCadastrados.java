package com.ifg.haney.cadastrodecliente.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ifg.haney.cadastrodecliente.Model.Cliente;
import com.ifg.haney.cadastrodecliente.Persist.ClienteDAO;
import com.ifg.haney.cadastrodecliente.Persist.ClienteDaoSQLite;
import com.ifg.haney.cadastrodecliente.R;


public class TelaDadosCadastrados extends ActionBarActivity {

    TextView nome, cpf, rg, endereco, bairro, cidade, uf, nomeDoPai, nomeDaMae, dataNascimento, localNascimento;
    Cliente obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dados_cadastrados);

        nome = (TextView) findViewById(R.id.textViewNome);
        cpf = (TextView) findViewById(R.id.textViewCPF);
        rg = (TextView) findViewById(R.id.textViewRG);
        endereco = (TextView) findViewById(R.id.textViewEndereco);
        bairro = (TextView) findViewById(R.id.textViewBairro);
        cidade = (TextView) findViewById(R.id.textViewCidade);
        uf = (TextView) findViewById(R.id.textViewUF);
        nomeDoPai = (TextView) findViewById(R.id.textViewNomePai);
        nomeDaMae = (TextView) findViewById(R.id.textViewNomeMae);
        dataNascimento = (TextView) findViewById(R.id.textViewDataNascimento);
        localNascimento = (TextView) findViewById(R.id.textViewLocalNascimento);

        exibirDados();
    }

    public void exibirDados() {

        Intent i = getIntent();
        obj = (Cliente) i.getSerializableExtra(TelaDeCadastro.NOME);

        nome.setText(obj.getNome());
        cpf.setText(obj.getCpf());
        rg.setText(obj.getRg());
        endereco.setText(obj.getEndereco());
        bairro.setText(obj.getBairro());
        cidade.setText(obj.getCidade());
        uf.setText(obj.getUf());
        nomeDoPai.setText(obj.getNomeDoPai());
        nomeDaMae.setText(obj.getNomeDaMae());
        dataNascimento.setText(obj.getDataNascimento());
        localNascimento.setText(obj.getLocalNascimento());
    }

    public void salvarCliente(View v) {

        ClienteDAO dao = new ClienteDaoSQLite(this);
        try {
            obj = dao.salvar(obj);
            Toast.makeText(this, "Cliente salvo com sucesso", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_dados_cadastrados, menu);
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
