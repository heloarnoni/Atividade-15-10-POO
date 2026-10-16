public class MainCloud {
    // "throws" é necessário só porque o passo 6 chama alocarContainer fora de
    // try-catch (a exceção checked precisa ser declarada) - RA: 25129544-2
    public static void main(String[] args) throws CapacidadeExcedidaException {

        CloudManager manager = new CloudManager();                              // 1 - RA: 25129544-2

        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");   // 2 - RA: 25129544-2

        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);            // 3 - RA: 25129544-2

        manager.registrarCliente(cliente);                                      // 4 - RA: 25129544-2
        manager.provisionarServidor(cliente, servidor);

        Container c1 = new Container("C-01", "App Batman", 10.0);               // 5 - RA: 25129544-2
        Container c2 = new Container("C-02", "App Robin", 8.0);

        // teste unchecked: servidor desligado, deve estourar no console - RA: 25129544-2

        servidor.ligar();

        servidor.alocarContainer(c1); //sucesso (10 de 16) - RA: 25129544-2

        //teste checked: 10 + 8 = 18 > 16, então lança exceção - RA: 25129544-2
        try {
            servidor.alocarContainer(c2);
        } catch (CapacidadeExcedidaException e) {
            System.out.println(e.getMessage()); // imprime o erro de forma elegante - RA: 25129544-2
        }

        //servidor ligado, deve imprimir 5.5 - RA: 25129544-2
        System.out.println("Fatura ativa: R$ " + manager.calcularFaturaAtiva(cliente));
    }
}
