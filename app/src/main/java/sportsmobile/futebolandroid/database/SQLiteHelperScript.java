package sportsmobile.futebolandroid.database;

import android.content.Context;

import sportsmobile.futebolandroid.Utils.Tools;

/**
 * Created by edsonreis on 27/10/17.
 */

public class SQLiteHelperScript {

    // Script para fazer drop na tabela
    public static final String[] SCRIPT_DATABASE_DELETE = new String[] {
            "DROP TABLE IF EXISTS Mensagens"
    };

    // Cria a tabela com o "_id" sequencial
    public  static String[] FUNC_SCRIPT_DATABASE_CREATE(Context context){

        String[] TMP_SCRIPT_DATABASE_CREATE = new String[]{};

        TMP_SCRIPT_DATABASE_CREATE = new String[] {
                "create table Mensagens ( _id integer primary key autoincrement, " +
                        "titulo text not null, " +
                        "descricao text);",
                "insert into Mensagens (titulo, descricao) values ('','');"

        };

        return TMP_SCRIPT_DATABASE_CREATE;

    }

    public  static String GET_NOME_BANCO(Context context)
    {
        return Tools.CATEGORY;
    }

    // Controle de versão
    public static final int VERSAO_BANCO = 1;

}

