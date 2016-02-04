package pt.rikmartins.clubemg.clubemgandroid.bd.modelos;

import io.realm.RealmObject;

public class Ligacao extends RealmObject {
    private String designacao;
    private String endereco;

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
