import java.util.List;
import java.util.Scanner;

/**
 * Implementação de {@link InterfaceUsuario} para interação via console de texto.
 * Toda a lógica de impressão de texto e leitura de entrada do teclado está
 * centralizada aqui, separando completamente a "visão" do resto do sistema.
 */
public class ConsoleUI implements InterfaceUsuario {

    private final Scanner scanner = new Scanner(System.in);

    // Dentro da classe ConsoleUI

    @Override
    public void exibirEstado(JogoDaForca jogo) {
        System.out.println("\n================ JOGO DA FORCA ================");
        desenharForca(jogo.getNumeroDeErros());
        System.out.println("\nPalavra: " + jogo.getPalavraMascarada());
        System.out.println("Letras erradas: " + jogo.getLetrasErradas());
        System.out.println("Tentativas restantes: " + jogo.getTentativasRestantes());
        System.out.println("Dicas restantes: " + jogo.getDicasRestantes()); // LINHA ADICIONADA
    }

// O resto da classe ConsoleUI continua igual

    @Override
    public void exibirVitoria(String palavra) {
        System.out.println("\n*********************************************");
        System.out.println(" PARABÉNS! Você venceu! A palavra era: " + palavra);
        System.out.println("*********************************************");
    }

    @Override
    public void exibirDerrota(String palavra) {
        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(" QUE PENA! Você perdeu. A palavra era: " + palavra);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        desenharForca(6);
    }

    @Override
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    @Override
    public String lerEntrada(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    @Override
    public String escolherCategoria(List<String> categorias) {
        // ... (código do menu de categorias, sem alterações)
        System.out.println("\nEscolha uma categoria:");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, categorias.get(i));
        }
        int escolha = -1;
        while (escolha < 1 || escolha > categorias.size()) {
            try {
                String entrada = lerEntrada("Opção: ");
                escolha = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                exibirMensagem("Entrada inválida. Por favor, digite um número.");
            }
        }
        return categorias.get(escolha - 1);
    }

    @Override
    public Dificuldade escolherDificuldade() {
        // ... (código do menu de dificuldade, sem alterações)
        System.out.println("\nEscolha o nível de dificuldade:");
        Dificuldade[] dificuldades = Dificuldade.values();
        for (int i = 0; i < dificuldades.length; i++) {
            System.out.printf("%d - %s (%d tentativas)\n", i + 1, dificuldades[i], dificuldades[i].getNumeroDeTentativas());
        }
        int escolha = -1;
        while (escolha < 1 || escolha > dificuldades.length) {
            try {
                String entrada = lerEntrada("Opção: ");
                escolha = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                exibirMensagem("Entrada inválida. Por favor, digite um número.");
            }
        }
        return dificuldades[escolha - 1];
    }

    @Override
    public boolean jogarNovamente() {
        String resposta = lerEntrada("\nDeseja jogar novamente? (s/n): ");
        return resposta.equalsIgnoreCase("s");
    }

    private void desenharForca(int numeroDeErros) {
        // ... (código do desenharForca, sem alterações)
        System.out.println("  +---+");
        System.out.println("  |   |");
        if (numeroDeErros >= 1) System.out.println("  |   O"); else System.out.println("  |");
        if (numeroDeErros == 2) System.out.println("  |   |"); else if (numeroDeErros == 3) System.out.println("  |  /|"); else if (numeroDeErros >= 4) System.out.println("  |  /|\\"); else System.out.println("  |");
        if (numeroDeErros == 5) System.out.println("  |  /"); else if (numeroDeErros >= 6) System.out.println("  |  / \\"); else System.out.println("  |");
        System.out.println("  |");
        System.out.println("=======");
    }
}