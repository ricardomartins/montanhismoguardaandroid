package pt.rikmartins.clubemg.clubemgandroid.bd.modelos;

import io.realm.RealmObject;

public class Etiqueta extends RealmObject {
    private String designacao;

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
}
