/**
 * Exceção personalizada para representar uma entrada inválida fornecida pelo usuário.
 * O uso de uma exceção específica torna o tratamento de erros mais claro e robusto.
 */
public class EntradaInvalidaException extends Exception {
    public EntradaInvalidaException(String message) {
        super(message);
    }
}