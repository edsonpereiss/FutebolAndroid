package sportsmobile.futebolandroid.database;

import android.content.Context;

/**
 * Created by edsonreis on 27/10/17.
 */

public class MensagensScript  extends MensagensRep {
    // Classe utilitária para abrir, criar, e atualizar o banco de dados
    private SQLiteHelper dbHelper;

    // Cria o banco de dados com um script SQL
    public MensagensScript(Context ctx) {
        // Criar utilizando um script SQL
        dbHelper = new SQLiteHelper(ctx, SQLiteHelperScript.GET_NOME_BANCO(ctx), SQLiteHelperScript.VERSAO_BANCO,
                SQLiteHelperScript.FUNC_SCRIPT_DATABASE_CREATE(ctx), SQLiteHelperScript.SCRIPT_DATABASE_DELETE);

        // abre o banco no modo escrita para poder alterar também
        db = dbHelper.getWritableDatabase();
    }

    // Fecha o banco
    @Override
    public void close() {
        super.close();
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
}