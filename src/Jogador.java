/**
 * Modela um jogador do jogo da forca.
 * Esta classe simples armazena o nome e a pontuação do jogador,
 * permitindo que o estado do jogador persista entre várias partidas.
 */
public class Jogador {
    private String nome;
    private int pontuacao;

    /**
     * Construtor para criar um novo jogador.
     * @param nome O nome do jogador.
     */
    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
    }

    /**
     * Retorna o nome do jogador.
     * @return O nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a pontuação atual do jogador.
     * @return A pontuação.
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * Adiciona uma quantidade de pontos à pontuação total do jogador.
     * @param pontos Os pontos a serem adicionados.
     */
    public void adicionarPontos(int pontos) {
        this.pontuacao += pontos;
    }
}