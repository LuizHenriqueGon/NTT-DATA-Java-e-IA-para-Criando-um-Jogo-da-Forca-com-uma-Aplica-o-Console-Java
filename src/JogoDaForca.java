import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Representa a lógica e o estado de uma única partida do Jogo da Forca.
 * Esta classe é o "Model" principal do jogo, encapsulando todas as regras de negócio,
 * como a palavra secreta, tentativas, dicas e o estado atual (jogando, venceu, perdeu).
 */
public class JogoDaForca {

    private final String palavraSecreta;
    private final char[] palavraMascarada;
    private final List<Character> letrasErradas;
    private final List<Character> letrasTentadas;
    private int tentativasRestantes;
    private EstadoDoJogo estado;
    private int dicasRestantes;

    /**
     * Construtor que inicializa uma nova partida.
     * @param palavraSecreta A palavra que o jogador deve adivinhar.
     * @param dificuldade O nível de dificuldade, que define o número de tentativas.
     */
    public JogoDaForca(String palavraSecreta, Dificuldade dificuldade) {
        this.palavraSecreta = palavraSecreta.toUpperCase();
        this.tentativasRestantes = dificuldade.getNumeroDeTentativas();
        this.letrasErradas = new ArrayList<>();
        this.letrasTentadas = new ArrayList<>();
        this.estado = EstadoDoJogo.JOGANDO;
        this.dicasRestantes = 3; // Inicializa com 3 dicas

        this.palavraMascarada = new char[this.palavraSecreta.length()];
        for (int i = 0; i < this.palavraMascarada.length; i++) {
            this.palavraMascarada[i] = '_';
        }
    }

    /**
     * Processa a tentativa de uma letra pelo jogador.
     * Verifica se a letra está na palavra secreta, atualiza o estado do jogo
     * (palavra mascarada, erros, tentativas) e verifica se houve vitória ou derrota.
     * @param letra A letra que o jogador tentou.
     */
    public void tentarLetra(char letra) {
        letra = Character.toUpperCase(letra);
        if (letrasTentadas.contains(letra)) {
            return; // Ignora letras já tentadas.
        }
        letrasTentadas.add(letra);

        if (palavraSecreta.indexOf(letra) >= 0) { // Acertou
            atualizarPalavraMascarada(letra);
            verificarVitoria();
        } else { // Errou
            letrasErradas.add(letra);
            tentativasRestantes--;
            verificarDerrota();
        }
    }

    /**
     * Fornece uma dica ao jogador, revelando uma letra aleatória ainda não descoberta.
     * Consome uma dica e uma tentativa como penalidade.
     * @return {@code true} se a dica foi dada com sucesso, {@code false} caso contrário
     * (sem dicas restantes, sem tentativas ou palavra já completa).
     */
    public boolean darDica() {
        if (dicasRestantes > 0 && tentativasRestantes > 1) {
            List<Integer> indicesNaoRevelados = new ArrayList<>();
            for (int i = 0; i < palavraMascarada.length; i++) {
                if (palavraMascarada[i] == '_') {
                    indicesNaoRevelados.add(i);
                }
            }

            if (!indicesNaoRevelados.isEmpty()) {
                int indiceAleatorio = indicesNaoRevelados.get(new Random().nextInt(indicesNaoRevelados.size()));
                char letraDica = palavraSecreta.charAt(indiceAleatorio);

                tentarLetra(letraDica);
                tentativasRestantes--; // Penalidade pela dica
                dicasRestantes--;
                verificarDerrota();

                return true;
            }
        }
        return false;
    }

    // --- MÉTODOS PRIVADOS DE LÓGICA INTERNA ---

    private void atualizarPalavraMascarada(char letra) {
        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                palavraMascarada[i] = letra;
            }
        }
    }

    private void verificarVitoria() {
        if (new String(palavraMascarada).equals(palavraSecreta)) {
            this.estado = EstadoDoJogo.VENCEU;
        }
    }

    private void verificarDerrota() {
        if (tentativasRestantes <= 0) {
            this.estado = EstadoDoJogo.PERDEU;
        }
    }

    // --- MÉTODOS GETTERS PÚBLICOS (ENCAPSULAMENTO) ---

    public String getPalavraMascarada() {
        StringBuilder sb = new StringBuilder();
        for (char c : palavraMascarada) {
            sb.append(c).append(' ');
        }
        return sb.toString();
    }

    public int getDicasRestantes() { return dicasRestantes; }
    public String getPalavraSecreta() { return palavraSecreta; }
    public List<Character> getLetrasErradas() { return letrasErradas; }
    public int getTentativasRestantes() { return tentativasRestantes; }
    public EstadoDoJogo getEstado() { return estado; }
    public int getNumeroDeErros() { return letrasErradas.size(); }
}