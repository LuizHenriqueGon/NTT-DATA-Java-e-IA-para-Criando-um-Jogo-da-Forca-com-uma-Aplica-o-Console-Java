/**
 * Enum que representa os níveis de dificuldade do jogo.
 * O uso de um enum torna o código mais seguro e legível, evitando o uso de
 * números ou strings "mágicas" para representar a dificuldade.
 * Cada nível de dificuldade encapsula o número de tentativas correspondente.
 */
public enum Dificuldade {
    FACIL(8),
    MEDIO(6),
    DIFICIL(4);

    private final int numeroDeTentativas;

    Dificuldade(int tentativas) {
        this.numeroDeTentativas = tentativas;
    }

    public int getNumeroDeTentativas() {
        return numeroDeTentativas;
    }
}