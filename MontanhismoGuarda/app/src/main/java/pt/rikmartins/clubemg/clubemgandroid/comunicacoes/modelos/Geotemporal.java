package pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geotemporal extends Localizacao {

    @SerializedName("ordem")
    @Expose
    private Long ordem;
    @SerializedName("diahora")
    @Expose
    private Object diahora;

    /**
     * No args constructor for use in serialization
     */
    public Geotemporal() {
    }

    /**
     * @param ordem
     * @param diahora
     * @param longitude
     * @param latitude
     * @param designacao
     */
    public Geotemporal(String designacao, Double latitude, Double longitude, Long ordem, Object diahora) {
        super(designacao, latitude, longitude);
        this.ordem = ordem;
        this.diahora = diahora;
    }

    /**
     * @return The ordem
     */
    public Long getOrdem() {
        return ordem;
    }

    /**
     * @param ordem The ordem
     */
    public void setOrdem(Long ordem) {
        this.ordem = ordem;
    }

    /**
     * @return The diahora
     */
    public Object getDiahora() {
        return diahora;
    }

    /**
     * @param diahora The diahora
     */
    public void setDiahora(Object diahora) {
        this.diahora = diahora;
    }

}
