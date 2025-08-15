import java.io.IOException;
import java.util.List;

/**
 * Classe orquestradora que gerencia o fluxo completo do jogo da forca.
 * Ela conecta a interface do usuário (UI), a lógica do jogo (Model) e o
 * armazenamento de palavras, atuando como o "Cérebro" da aplicação (Controller).
 */
public class ControladorDoJogo {

    private final InterfaceUsuario ui;
    private Jogador jogador;

    /**
     * Construtor que recebe a implementação da interface do usuário.
     * Este mecanismo é chamado de Injeção de Dependência, tornando o controlador
     * independente da implementação concreta da UI (seja console, gráfica, etc.).
     * @param ui A interface de usuário a ser utilizada pelo jogo.
     */
    public ControladorDoJogo(InterfaceUsuario ui) {
        this.ui = ui;
    }

    /**
     * Inicia a execução do jogo, cumprimentando o jogador e mantendo o jogo
     * em um loop de "jogar novamente" até que o jogador decida parar.
     */
    public void iniciar() {
        String nome = ui.lerEntrada("Bem-vindo ao Jogo da Forca! Qual é o seu nome? ");
        this.jogador = new Jogador(nome);
        ui.exibirMensagem("Olá, " + jogador.getNome() + "! Vamos começar.");

        boolean jogar = true;
        while (jogar) {
            rodarPartida();
            jogar = ui.jogarNovamente();
        }
        ui.exibirMensagem("\nObrigado por jogar! Sua pontuação final foi: " + jogador.getPontuacao());
    }

    /**
     * Executa uma única partida do jogo da forca, desde a seleção da categoria
     * até a exibição do resultado final (vitória ou derrota).
     */
    private void rodarPartida() {
        try {
            // 1. Obtém as categorias disponíveis antes de criar o banco de palavras.
            List<String> categorias = BancoDePalavras.getCategoriasDisponiveis();
            if (categorias.isEmpty()){
                ui.exibirMensagem("Nenhuma categoria de palavras encontrada na pasta 'palavras'. Verifique a pasta.");
                return;
            }

            // 2. Interage com o usuário para escolher as configurações da partida.
            String categoriaEscolhida = ui.escolherCategoria(categorias);
            Dificuldade dificuldade = ui.escolherDificuldade();

            // 3. Cria a instância do armazenamento de palavras com a categoria selecionada.
            ArmazenamentoPalavras armazenamento = new BancoDePalavras(categoriaEscolhida);
            String palavra = armazenamento.getPalavraAleatoria();

            JogoDaForca jogo = new JogoDaForca(palavra, dificuldade);

            // 4. Loop principal da partida, que continua enquanto o estado for "JOGANDO".
            while (jogo.getEstado() == EstadoDoJogo.JOGANDO) {
                ui.exibirEstado(jogo);
                String entrada = ui.lerEntrada("Digite uma letra (ou '1' para dica): ");

                if ("1".equals(entrada)) {
                    if (!jogo.darDica()) {
                        ui.exibirMensagem("Não foi possível usar a dica!");
                    }
                } else if (entrada.length() == 1 && Character.isLetter(entrada.charAt(0))) {
                    jogo.tentarLetra(entrada.charAt(0));
                } else {
                    ui.exibirMensagem("Entrada inválida.");
                }
            }

            // 5. Exibe o resultado final e atualiza a pontuação.
            if (jogo.getEstado() == EstadoDoJogo.VENCEU) {
                ui.exibirVitoria(jogo.getPalavraSecreta());
                jogador.adicionarPontos(10);
            } else {
                ui.exibirDerrota(jogo.getPalavraSecreta());
            }

        } catch (IOException e) {
            ui.exibirMensagem("Erro crítico: Não foi possível carregar as palavras da categoria selecionada. Verifique se o arquivo existe.");
        }
    }
}