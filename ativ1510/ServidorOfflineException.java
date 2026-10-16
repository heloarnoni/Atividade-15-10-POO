// herda de RuntimeException, então o compilador não obriga try-catch - RA: 25129544-2
public class ServidorOfflineException extends RuntimeException {
    public ServidorOfflineException(String msg) {
        super(msg); // repassa a mensagem para a classe pai - RA: 25129544-2
    }
}
