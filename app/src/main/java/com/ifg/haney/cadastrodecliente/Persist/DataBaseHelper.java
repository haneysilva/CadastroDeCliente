package com.ifg.haney.cadastrodecliente.Persist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Haney on 28/04/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "Meu_Banco";
    private static final int VERSAO = 1;

    public static final String TABELACLIENTE = "pessoa";

    public static final String NOME = "nome";
    public static final String CPF = "cpf";
    public static final String RG = "rg";
    public static final String ENDERECO = "endereco";
    public static final String BAIRRO = "bairro";
    public static final String CIDADE = "cidade";
    public static final String UF = "uf";
    public static final String NOMEPAI = "nomePai";
    public static final String NOMEMAE = "nomeMae";
    public static final String LOCALNAS = "localNas";
    public static final String DATANAS = "dataNas";

    public DataBaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String ddl = "CREATE TABLE " + TABELACLIENTE + "(" +
                     "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     NOME + " TEXT not null, " +
                     CPF + " TEXT not null, " +
                     RG + " TEXT not null, " +
                     ENDERECO + " TEXT not null, " +
                     BAIRRO + " TEXT not null, " +
                     CIDADE + " TEXT not null, " +
                     UF + " TEXT not null, " +
                     NOMEPAI + " TEXT not null, " +
                     NOMEMAE + " TEXT not null, " +
                     LOCALNAS + " TEXT not null, " +
                     DATANAS + " TEXT not null" +
                     ")";

        db.execSQL(ddl);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
