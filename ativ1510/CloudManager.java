import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloudManager {
    // HashMap: chave = Cliente, valor = Set de Servidores.
    // HashSet não permite duplicados e não tem ordem - RA: 25129544-2
    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    // construtor sem parâmetros, como no diagrama - RA: 25129544-2
    public CloudManager() {
    }

    // cadastra o cliente com um conjunto vazio de servidores - RA: 25129544-2
    public void registrarCliente(Cliente c) {
        bancoDeDados.putIfAbsent(c, new HashSet<>());
    }

    // sdiciona o servidor ao conjunto do cliente - RA: 25129544-2
    public void provisionarServidor(Cliente c, Servidor s) {
        bancoDeDados.get(c).add(s);
    }

    // soma o preço dos servidores LIGADOS do cliente, com Stream - RA: 25129544-2
    public double calcularFaturaAtiva(Cliente c) {
        return bancoDeDados.get(c).stream()
                .filter(Servidor::isStatusLigado)            // só os ligados
                .mapToDouble(Servidor::getPrecoPorHora)      // pega o preço de cada um
                .sum();                                      // soma final - RA: 25129544-2
    }
}
