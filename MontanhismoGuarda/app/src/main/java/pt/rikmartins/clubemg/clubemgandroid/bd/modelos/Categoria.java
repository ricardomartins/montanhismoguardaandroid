package pt.rikmartins.clubemg.clubemgandroid.bd.modelos;

import io.realm.RealmObject;

/**
 * Created by Ricardo Martins on 17-12-2015.
 */
public class Categoria extends RealmObject {
    private String designacao;

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
}
