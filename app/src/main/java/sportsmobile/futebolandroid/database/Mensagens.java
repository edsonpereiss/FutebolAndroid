package sportsmobile.futebolandroid.database;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by edsonreis on 27/10/17.
 */

public class  Mensagens {

    public static String[] colunas = new String[] { Mensagenss._ID,
            Mensagenss.TITULO,
            Mensagenss.DESCRICAO};

    public static final String AUTHORITY = "br.digitalmob.firula.banco.structure.mensagens";

    public long id;
    public String titulo;
    public String descricao;


    public Mensagens(){
    }

    public Mensagens(String titulo,
                     String descricao)
    {
        super();
        this.titulo = titulo;
        this.descricao = descricao;

    }

    public Mensagens(  long id,
                       String titulo,
                       String descricao)
    {
        super();
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }


    public static final class Mensagenss implements BaseColumns {


        // Não pode instanciar esta Classe
        private Mensagenss() {
        }

        // content://br.ereis.capturegoae.provider.tracking/campeonatos
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/mensagens");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.mensagens";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.mensagens";
        public static final String DEFAULT_SORT_ORDER = "_id ASC";

        public static final String TITULO = "titulo";
        public static final String DESCRICAO = "descricao";

        public static Uri getUriId(long id) {

            Uri uriMensagens = ContentUris.withAppendedId(Mensagenss.CONTENT_URI, id);
            return uriMensagens;
        }
    }


    @Override
    public String toString() {
        return  " titulo: " + titulo +
                ", descricao: " + descricao;
    }
}
