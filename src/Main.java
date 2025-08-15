/**
 * Ponto de entrada da aplicação (Entry Point).
 * A responsabilidade desta classe é unicamente instanciar os componentes
 * principais do sistema (UI e Controlador) e iniciar o jogo.
 * Este design mantém a classe principal limpa e focada em sua única função.
 */
public class Main {
    /**
     * Método principal que é executado quando a aplicação inicia.
     * @param args Argumentos de linha de comando (não utilizados neste projeto).
     */
    public static void main(String[] args) {
        // Cria a implementação da UI que queremos usar (neste caso, o console).
        // Graças à interface, poderíamos trocar "new ConsoleUI()" por "new GuiUI()"
        // sem alterar o resto do código.
        InterfaceUsuario ui = new ConsoleUI();

        // Cria o controlador do jogo, injetando a dependência da UI.
        // Isso é um exemplo de Inversão de Dependência.
        ControladorDoJogo controlador = new ControladorDoJogo(ui);
        controlador.iniciar();
    }
}