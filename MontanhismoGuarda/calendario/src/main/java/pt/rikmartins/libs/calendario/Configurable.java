package pt.rikmartins.libs.calendario;

public interface Configurable<C extends CalendarConfig> {
    C getCopyOfConfig();
    void setConfig(C config);
}
