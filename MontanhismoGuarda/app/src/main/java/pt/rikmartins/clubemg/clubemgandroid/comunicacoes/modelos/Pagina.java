package pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Pagina<P extends Paginavel> {
    @SerializedName("count")
    @Expose
    private Long count;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("previous")
    @Expose
    private String previous;
    @SerializedName("results")
    @Expose
    private List<P> results = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     */
    public Pagina() {
    }

    /**
     * @param results
     * @param previous
     * @param count
     * @param next
     */
    public Pagina(Long count, String next, String previous, List<P> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    /**
     * @return The count
     */
    public Long getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * @return The next
     */
    public String getNext() {
        return next;
    }

    /**
     * @param next The next
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * @return The previous
     */
    public String getPrevious() {
        return previous;
    }

    /**
     * @param previous The previous
     */
    public void setPrevious(String previous) {
        this.previous = previous;
    }

    /**
     * @return The results
     */
    public List<P> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<P> results) {
        this.results = results;
    }
}
