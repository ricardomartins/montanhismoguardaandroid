
package pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Localizacao {

    @SerializedName("designacao")
    @Expose
    private String designacao;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Localizacao() {
    }

    /**
     * 
     * @param longitude
     * @param latitude
     * @param designacao
     */
    public Localizacao(String designacao, Double latitude, Double longitude) {
        this.designacao = designacao;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * 
     * @return
     *     The designacao
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * 
     * @param designacao
     *     The designacao
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * 
     * @return
     *     The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
