import java.util.Objects;

public class Cliente {
    private String cpf;   // identifica o cliente de forma única - RA: 25129544-2
    private String nome;  // nome do cliente - RA: 25129544-2

    // Construtor: recebe os dados e guarda nos atributos - RA: 25129544-2
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() { return cpf; } 
    public String getNome() { return nome; }

    // dois clientes são iguais se tiverem o mesmo CPF - RA: 25129544-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                  // mesmo objeto na memória
        if (!(obj instanceof Cliente)) return false;   // tipo diferente
        Cliente outro = (Cliente) obj;
        return Objects.equals(this.cpf, outro.cpf);    // compara só o CPF
    }

    // hashCode usa o mesmo campo do equals (obrigatório para HashMap) - RA: 25129544-2
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
