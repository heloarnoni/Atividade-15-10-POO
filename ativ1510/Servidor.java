import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Servidor {
    private String ip;
    private double precoPorHora;
    private double ramTotal;
    private boolean statusLigado;
    //ja nasce inicializada para não dar NullPointerException - RA: 25129544-2
    private List<Container> containers = new ArrayList<>();

    // construtor conforme o diagrama - RA: 25129544-2
    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip;
        this.ramTotal = ramTotal;
        this.precoPorHora = precoPorHora;
    }

    public void ligar() { this.statusLigado = true; }
    public void desligar() { this.statusLigado = false; }
    public String getIp() { return ip; }
    public double getPrecoPorHora() { return precoPorHora; }
    public boolean isStatusLigado() { return statusLigado; }

    // soma a RAM de todos os containers usando Stream, sem for - RA: 25129544-2
    public double calcularRamEmUso() {
        return containers.stream()
                .mapToDouble(Container::getRamNecessaria) // transforma cada container em sua RAM
                .sum();                                   // soma tudo - RA: 25129544-2
    }

    //fail-Fast: valida antes de adicionar - RA: 25129544-2
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {
        // regra 1: servidor desligado lança exceção unchecked - RA: 25129544-2
        if (!statusLigado) {
            throw new ServidorOfflineException(
                "Erro: Não é possível alocar containers em um servidor desligado.");
        }
        // regra 2: RAM em uso + RAM do novo container não pode passar do total - RA: 25129544-2
        if (calcularRamEmUso() + c.getRamNecessaria() > ramTotal) {
            throw new CapacidadeExcedidaException(
                "Falha Crítica: Memória RAM insuficiente no servidor " + ip + ".");
        }
        containers.add(c); // passou nas duas validações, pode adicionar - RA: 25129544-2
    }

    // iguais se tiverem o mesmo IP - RA: 25129544-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Servidor)) return false;
        Servidor outro = (Servidor) obj;
        return Objects.equals(this.ip, outro.ip);
    }

    // hashCode baseado no IP - RA: 25129544-2
    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }
}
