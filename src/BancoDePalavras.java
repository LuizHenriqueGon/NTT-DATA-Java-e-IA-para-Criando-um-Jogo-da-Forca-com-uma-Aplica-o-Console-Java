import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.io.File;
import java.io.IOException;
// ... outros imports

/**
 * Implementação de {@link ArmazenamentoPalavras} que carrega palavras
 * a partir de arquivos de texto localizados em uma pasta "palavras".
 */
public class BancoDePalavras implements ArmazenamentoPalavras {

    // ... (o resto da classe não muda)
    private final List<String> palavras;
    private static final Random random = new Random();
    private static final String PASTA_PALAVRAS = "palavras";

    public BancoDePalavras(String categoria) throws IOException {
        this.palavras = carregarPalavrasDoArquivo(categoria);
    }

    // ... (carregarPalavrasDoArquivo e getPalavraAleatoria não mudam)
    @Override
    public String getPalavraAleatoria() {
        if (palavras.isEmpty()) {
            return "PADRAO";
        }
        return palavras.get(random.nextInt(palavras.size()));
    }

    private List<String> carregarPalavrasDoArquivo(String categoria) throws IOException {
        String nomeArquivo = PASTA_PALAVRAS + "/" + categoria + ".txt";
        return Files.readAllLines(Paths.get(nomeArquivo))
                .stream()
                .filter(linha -> !linha.trim().isEmpty())
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }


    // ***** ALTERAÇÃO AQUI *****
    // Remova apenas a anotação @Override. O método continua public static.
    public static List<String> getCategoriasDisponiveis() {
        File pasta = new File(PASTA_PALAVRAS);
        File[] arquivos = pasta.listFiles();
        if (arquivos == null) {
            return new ArrayList<>();
        }

        List<String> nomesCategorias = new ArrayList<>();
        for (File arquivo : arquivos) {
            if (arquivo.isFile() && arquivo.getName().endsWith(".txt")) {
                nomesCategorias.add(arquivo.getName().replace(".txt", ""));
            }
        }
        return nomesCategorias;
    }
}