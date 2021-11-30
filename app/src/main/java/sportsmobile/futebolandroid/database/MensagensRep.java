package sportsmobile.futebolandroid.database;

/**
 * Created by edsonreis on 27/10/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import sportsmobile.futebolandroid.Utils.Tools;

public class MensagensRep {

    public static final String NOME_TABELA = "Mensagens";
    protected SQLiteDatabase db;
    protected Context _ctx;

    public MensagensRep (Context ctx) {
        // Abre o banco de dados já existente
        _ctx = ctx;
        db = ctx.openOrCreateDatabase(SQLiteHelperScript.GET_NOME_BANCO(ctx), Context.MODE_PRIVATE, null);
    }

    protected MensagensRep() {
        // Apenas para criar uma subclasse...
    }
    public long save(Mensagens mensagens, boolean exist) {
        long id = mensagens.id;

        if (exist) {
            update(mensagens);
        } else {
            id = insert(mensagens);
        }

        return id;
    }

    public long insert(Mensagens mensagens) {
        ContentValues values = new ContentValues();
        values.put(Mensagens.Mensagenss.TITULO, mensagens.titulo);
        values.put(Mensagens.Mensagenss.DESCRICAO, mensagens.descricao);
        long id = insert(values);
        return id;
    }

    public long insert(ContentValues valores) {
        long id = db.insert(NOME_TABELA, "", valores);
        return id;
    }

    public int update(Mensagens mensagens) {
        ContentValues values = new ContentValues();
        values.put(Mensagens.Mensagenss.TITULO, mensagens.titulo);
        values.put(Mensagens.Mensagenss.DESCRICAO, mensagens.descricao);
        String _id = String.valueOf(mensagens.id);

        String where = Mensagens.Mensagenss._ID + "=?";
        String[] whereArgs = new String[] { _id };

        int count = update(values, where, whereArgs);

        return count;
    }

    public int update(ContentValues valores, String where, String[] whereArgs) {
        int count = db.update(NOME_TABELA, valores, where, whereArgs);
        Log.i(Tools.CATEGORY, "Atualizou [" + count + "] registros");
        return count;
    }

    public int delete(long id) {
        String where = Mensagens.Mensagenss._ID + "=?";

        String _id = String.valueOf(id);
        String[] whereArgs = new String[] { _id };

        int count = delete(where, whereArgs);

        return count;
    }

    public int deleteAll() {
        String where = Mensagens.Mensagenss._ID + ">=?";
        String _id = String.valueOf(0);
        String[] whereArgs = new String[] { _id };

        int count = delete(where, whereArgs);

        return count;
    }

    public int deleteSelecao(String titulo) {
        String where = Mensagens.Mensagenss.TITULO + "=?";
        String _id = titulo;
        String[] whereArgs = new String[] { _id };

        int count = delete(where, whereArgs);

        return count;
    }

    public int delete(String where, String[] whereArgs) {
        int count = db.delete(NOME_TABELA, where, whereArgs);
        Log.i(Tools.CATEGORY, "Deletou [" + count + "] registros");
        return count;
    }

    public Mensagens find(long id) {
        // select * from carro where _id=?
        Cursor c = db.query(true, NOME_TABELA, Mensagens.colunas, Mensagens.Mensagenss._ID + "=" + id, null, null, null, null, null);

        if (c.getCount() > 0) {

            // Posicinoa no primeiro elemento do cursor
            c.moveToFirst();

            Mensagens mensagens = new Mensagens();

            // Lê os dados
            mensagens.id = c.getInt(0);
            mensagens.titulo = c.getString(2);
            mensagens.descricao = c.getString(3);
            return mensagens;
        }

        return null;
    }

    public Cursor getCursor(String titulo) {
        try {
            // select * from Mensagens
            return db.query(NOME_TABELA, Mensagens.colunas, Mensagens.Mensagenss.TITULO + " = '" + titulo +"'", null, null, null, null, null);
        } catch (SQLException e) {
            Log.e(Tools.CATEGORY, "Erro ao buscar os mensagenss: " + e.toString());
            return null;
        }
    }

    public Cursor getCursor() {
        try {
            // select * from Mensagens
            return db.query(NOME_TABELA, Mensagens.colunas, null, null, null, null, null, null);
        } catch (SQLException e) {
            Log.e(Tools.CATEGORY, "Erro ao buscar os mensagenss: " + e.toString());
            return null;
        }
    }

    public Cursor getCursor(int id) {
        try {
            // select * from Mensagens
            return db.query(NOME_TABELA, Mensagens.colunas, Mensagens.Mensagenss._ID + " = " + Integer.toString(id), null, null, null, null, null);
        } catch (SQLException e) {
            Log.e(Tools.CATEGORY, "Erro ao buscar os mensagenss: " + e.toString());
            return null;
        }
    }


    public Cursor getDescCursor() {
        try {
            String orderBy =  Mensagens.Mensagenss._ID + " DESC";
            // select * from mensagenss
            return db.query(NOME_TABELA, Mensagens.colunas, null, null, null, null, orderBy, null);
        } catch (SQLException e) {
            Log.e(Tools.CATEGORY, "Erro ao buscar os selecaos: " + e.toString());
            return null;
        }
    }

    public List<Mensagens> list(String Nome) {
        Cursor c = getCursor(Nome);

        List<Mensagens> mensagenss = new ArrayList<Mensagens>();

        if (c.moveToFirst()) {

            // Recupera os índices das colunas
            int idxId = c.getColumnIndex(Mensagens.Mensagenss._ID);
            int idxTITULO = c.getColumnIndex(Mensagens.Mensagenss.TITULO);
            int idxDESCRICAO = c.getColumnIndex(Mensagens.Mensagenss.DESCRICAO);
            // Loop até o final
            do {
                Mensagens mensagens = new Mensagens();
                mensagenss.add(mensagens);

                // recupera os atributos de tracking
                mensagens.id = c.getInt(idxId);
                mensagens.titulo = c.getString(idxTITULO);
                mensagens.descricao = c.getString(idxDESCRICAO);
            } while (c.moveToNext());
        }

        return mensagenss;
    }

    public List<Mensagens> listAll() {
        Cursor c = getCursor();

        List<Mensagens> mensagenss = new ArrayList<Mensagens>();

        if (c.moveToFirst()) {

            // Recupera os índices das colunas
            int idxId = c.getColumnIndex(Mensagens.Mensagenss._ID);
            int idxTITULO = c.getColumnIndex(Mensagens.Mensagenss.TITULO);
            int idxDESCRICAO = c.getColumnIndex(Mensagens.Mensagenss.DESCRICAO);

            // Loop até o final
            do {
                Mensagens mensagens = new Mensagens();
                mensagenss.add(mensagens);

                // recupera os atributos de tracking
                mensagens.id = c.getInt(idxId);
                mensagens.titulo = c.getString(idxTITULO);
                mensagens.descricao = c.getString(idxDESCRICAO);
            } while (c.moveToNext());
        }

        return mensagenss;
    }

    public Mensagens list(int id) {
        Cursor c = getCursor(id);

        Mensagens mensagens = new Mensagens();

        if (c.moveToFirst()) {

            // Recupera os índices das colunas
            int idxId = c.getColumnIndex(Mensagens.Mensagenss._ID);
            int idxTITULO = c.getColumnIndex(Mensagens.Mensagenss.TITULO);
            int idxDESCRICAO = c.getColumnIndex(Mensagens.Mensagenss.DESCRICAO);

            // Loop até o final
            do {

                // recupera os atributos de tracking
                mensagens.id = c.getInt(idxId);
                mensagens.titulo = c.getString(idxTITULO);
                mensagens.descricao = c.getString(idxDESCRICAO);
            } while (c.moveToNext());
        }

        return mensagens;
    }

    public Cursor query(SQLiteQueryBuilder queryBuilder, String[] projection, String selection, String[] selectionArgs,
                        String groupBy, String having, String orderBy) {
        Cursor c = queryBuilder.query(this.db, projection, selection, selectionArgs, groupBy, having, orderBy);
        return c;
    }

    public void close() {
        // fecha o banco de dados
        if (db != null) {
            db.close();
        }
    }

    public Cursor getCursorTitulo(String titulo) {
        try {
            // select * from Mensagens
            return db.query(NOME_TABELA, Mensagens.colunas, Mensagens.Mensagenss.TITULO + " = '" + titulo + "'" , null, null, null, null, null);
            //return db.query(NOME_TABELA, Mensagens.colunas, null, null, null, null, null, null);
        } catch (SQLException e) {
            Log.e(Tools.CATEGORY, "Erro ao buscar os mensagenss: " + e.toString());
            return null;
        }

    }

    public Mensagens findByTitulo(String titulo) {
        Cursor c = getCursorTitulo(titulo);

        Mensagens mensagens = null;

        if(c != null){
            if (c.moveToFirst()) {

                // Recupera os índices das colunas
                int idxId = c.getColumnIndex(Mensagens.Mensagenss._ID);
                int idxTITULO = c.getColumnIndex(Mensagens.Mensagenss.TITULO);
                int idxDESCRICAO = c.getColumnIndex(Mensagens.Mensagenss.DESCRICAO);

                // Loop até o final
                do {

                    mensagens = new Mensagens();
                    // recupera os atributos de tracking
                    mensagens.id = c.getInt(idxId);
                    mensagens.titulo = c.getString(idxTITULO);
                    mensagens.descricao = c.getString(idxDESCRICAO);
                } while (c.moveToNext());
            }
        }

        return mensagens;
    }


}
