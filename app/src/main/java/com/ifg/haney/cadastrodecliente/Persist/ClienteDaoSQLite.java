package com.ifg.haney.cadastrodecliente.Persist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.NetworkOnMainThreadException;

import com.ifg.haney.cadastrodecliente.Model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haney on 21/05/2015.
 */
public class ClienteDaoSQLite implements ClienteDAO {

    private DataBaseHelper helper;

    private String where = "_id = ? ";
    private String[] args = new String[] { "_id" };
    private String[] colunas = new String[]{
            "_id",
            DataBaseHelper.NOME,
            DataBaseHelper.CPF,
            DataBaseHelper.RG,
            DataBaseHelper.ENDERECO,
            DataBaseHelper.BAIRRO,
            DataBaseHelper.CIDADE,
            DataBaseHelper.UF,
            DataBaseHelper.NOMEPAI,
            DataBaseHelper.NOMEMAE,
            DataBaseHelper.DATANAS,
            DataBaseHelper.LOCALNAS
    };


    public ClienteDaoSQLite(Context context) {
        helper = new DataBaseHelper(context);
    }

    @Override
    public Cliente salvar(Cliente obj) throws Exception {

        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.NOME , obj.getNome());
        values.put(DataBaseHelper.CPF, obj.getCpf());
        values.put(DataBaseHelper.RG, obj.getRg());
        values.put(DataBaseHelper.ENDERECO, obj.getEndereco());
        values.put(DataBaseHelper.BAIRRO, obj.getBairro());
        values.put(DataBaseHelper.CIDADE, obj.getCidade());
        values.put(DataBaseHelper.UF, obj.getUf());
        values.put(DataBaseHelper.NOMEPAI, obj.getNomeDoPai());
        values.put(DataBaseHelper.NOMEMAE, obj.getNomeDaMae());
        values.put(DataBaseHelper.DATANAS, obj.getDataNascimento());
        values.put(DataBaseHelper.LOCALNAS, obj.getLocalNascimento());

        long id = db.insert(DataBaseHelper.TABELACLIENTE, null, values);

        if(id == -1)
            throw new Exception("Erro na gravação do cliente");

        obj.setId(id);

        return obj;
        /*if(id != -1 ){
            Toast.makeText(this, "Cliente salvo com sucesso", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Erro na gravação", Toast.LENGTH_SHORT).show();
        }*/
    }

    @Override
    public void exluir(Cliente c) throws Exception {

        int id = (int) c.getId();
        exluir(id);
    }

    @Override
    public void exluir(int id) throws Exception {

        SQLiteDatabase db = helper.getWritableDatabase();

        db.delete(DataBaseHelper.TABELACLIENTE, where, args);
    }

    @Override
    public List<Cliente> listarTodos() throws Exception {

        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor c = db.query(DataBaseHelper.TABELACLIENTE, colunas, null, null, null, null, null);
        List<Cliente> lista = new ArrayList<Cliente>();

        while (c.moveToNext()) {
            Cliente cliente = new Cliente();
            cliente.setId(c.getLong(0));
            cliente.setNome(c.getString(1));
            cliente.setCpf(c.getString(2));
            cliente.setRg(c.getString(3));
            cliente.setEndereco(c.getString(4));
            cliente.setBairro(c.getString(5));
            cliente.setCidade(c.getString(6));
            cliente.setUf(c.getString(7));
            cliente.setNomeDoPai(c.getString(8));
            cliente.setNomeDaMae(c.getString(9));
            cliente.setDataNascimento(c.getString(10));
            cliente.setLocalNascimento(c.getString(11));

            lista.add(cliente);
        }

        c.close();

        return lista;
    }

    @Override
    public Cliente buscar(int id) throws Exception {

        SQLiteDatabase db = helper.getReadableDatabase();

        Cliente cliente = null;
        Cursor c = db.query(DataBaseHelper.TABELACLIENTE, colunas, where, args, null, null, null);

        c.moveToFirst();

        if (c != null) {
            cliente = new Cliente();
            cliente.setId(c.getLong(0));
            cliente.setNome(c.getString(1));
            cliente.setCpf(c.getString(2));
            cliente.setRg(c.getString(3));
            cliente.setEndereco(c.getString(4));
            cliente.setBairro(c.getString(5));
            cliente.setCidade(c.getString(6));
            cliente.setUf(c.getString(7));
            cliente.setNomeDoPai(c.getString(8));
            cliente.setNomeDaMae(c.getString(9));
            cliente.setDataNascimento(c.getString(10));
            cliente.setLocalNascimento(c.getString(11));
        }

        if(c != null) c.close();

        return cliente;
    }

    @Override
    public void alterar(Cliente c) throws Exception {

        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.NOME , c.getNome());
        values.put(DataBaseHelper.CPF, c.getCpf());
        values.put(DataBaseHelper.RG, c.getRg());
        values.put(DataBaseHelper.ENDERECO, c.getEndereco());
        values.put(DataBaseHelper.BAIRRO, c.getBairro());
        values.put(DataBaseHelper.CIDADE, c.getCidade());
        values.put(DataBaseHelper.UF, c.getUf());
        values.put(DataBaseHelper.NOMEPAI, c.getNomeDoPai());
        values.put(DataBaseHelper.NOMEMAE, c.getNomeDaMae());
        values.put(DataBaseHelper.DATANAS, c.getDataNascimento());
        values.put(DataBaseHelper.LOCALNAS, c.getLocalNascimento());

        db.update(DataBaseHelper.TABELACLIENTE, values, where, args);
    }
}
