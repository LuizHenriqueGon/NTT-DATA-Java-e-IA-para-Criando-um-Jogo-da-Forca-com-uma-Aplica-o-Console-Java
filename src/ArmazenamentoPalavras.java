import java.util.List;

/**
 * Define o contrato para qualquer classe que forneça palavras para o jogo.
 * Isso permite que a fonte das palavras (arquivos locais, banco de dados, API web)
 * possa ser trocada sem impactar a lógica do jogo.
 */
public interface ArmazenamentoPalavras {
    /**
     * Obtém uma palavra aleatória do armazenamento.
     * @return Uma palavra para a partida.
     */
    String getPalavraAleatoria();
}