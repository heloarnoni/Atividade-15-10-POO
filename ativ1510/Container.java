import java.util.Objects;

public class Container {
    private String id;            // identificador único - RA: 25129544-2
    private String nomeApp;       // nome da aplicação - RA: 25129544-2
    private double ramNecessaria; // RAM que o container consome - RA: 25129544-2

    // construtor conforme o diagrama - RA: 25129544-2
    public Container(String id, String nomeApp, double ramNecessaria) {
        this.id = id;
        this.nomeApp = nomeApp;
        this.ramNecessaria = ramNecessaria;
    }

    public String getId() { return id; }                          // RA: 25129544-2
    public double getRamNecessaria() { return ramNecessaria; }    // RA: 25129544-2

    // iguais se tiverem o mesmo ID - RA: 25129544-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Container)) return false;
        Container outro = (Container) obj;
        return Objects.equals(this.id, outro.id);
    }

    // hashCode baseado no ID, coerente com o equals - RA: 25129544-2
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
