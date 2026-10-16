// herda de Exception, então o compilador OBRIGA a tratar ou declarar - RA: 25129544-2
public class CapacidadeExcedidaException extends Exception {
    public CapacidadeExcedidaException(String msg) {
        super(msg); // RA: 25129544-2
    }
}
