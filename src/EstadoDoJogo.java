/**
 * Enum que representa os possíveis estados de uma partida.
 * Garante que o jogo só possa estar em um dos três estados definidos,
 * o que simplifica a lógica de controle de fluxo no controlador.
 */
public enum EstadoDoJogo {
    JOGANDO,
    VENCEU,
    PERDEU
}