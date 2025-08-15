import java.util.List;

/**
 * Define o contrato (as regras) para qualquer classe que sirva como interface
 * para o usuário. Ao programar para esta interface, o resto do sistema
 * se torna independente de ser um console, uma janela gráfica (GUI) ou outra forma de interação.
 */
public interface InterfaceUsuario {
    void exibirEstado(JogoDaForca jogo);
    void exibirVitoria(String palavra);
    void exibirDerrota(String palavra);
    void exibirMensagem(String mensagem);
    String lerEntrada(String prompt);
    String escolherCategoria(List<String> categorias);
    Dificuldade escolherDificuldade();
    boolean jogarNovamente();
}