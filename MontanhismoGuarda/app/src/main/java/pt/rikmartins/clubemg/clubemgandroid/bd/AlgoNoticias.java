package pt.rikmartins.clubemg.clubemgandroid.bd;

import java.util.List;

import io.realm.Realm;
import pt.rikmartins.clubemg.clubemgandroid.bd.modelos.Categoria;
import pt.rikmartins.clubemg.clubemgandroid.bd.modelos.Noticia;

public class AlgoNoticias {

    public static List<Categoria> gravaNoticias(Realm realm, List<Noticia> noticias) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(noticias);
        realm.commitTransaction();
        return realm.where(Categoria.class).findAll();
    }
}
