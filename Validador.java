import java.text.Normalizer;

public class Validador {

    public static void validarTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio.\nRetornando ao menu...");
        }
    }


    public static void validarAutor(String autor) {
        
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor(a) não pode ser vazio.\nRetornando ao menu...");
        }

        String autorNormalizado = removerAcentos(autor);

        if (autorNormalizado.matches(".*\\d.*")) {
        throw new IllegalArgumentException("Nome do(a) autor(a) não pode conter números.\nRetornando ao menu...");
        
        }

        if (autorNormalizado.matches(".*[^a-zA-Z\\s].*")) {
            throw new IllegalArgumentException("Nome do(a) autor(a) não pode conter caracteres especiais.\nRetornando ao menu...");
        }
    }


    public static String removerAcentos(String str) {
    
        if (str == null) {
            return null;
        }
    
        String normalizado = Normalizer.normalize(str, Normalizer.Form.NFD);
    
        return normalizado.replaceAll("[^\\p{ASCII}]", "");
    }


    public static int validarAno(String anoStr) {

        if (anoStr == null || anoStr.trim().isEmpty()) {
            throw new IllegalArgumentException("Ano inválido.\nRetornando ao menu...");
        }

        if (!anoStr.matches("\\d+")) {
            throw new IllegalArgumentException("Ano inválido.\nRetornando ao menu...");
        }

        int ano = Integer.parseInt(anoStr);

        if (ano < 0 || ano > 2025) {
            throw new IllegalArgumentException("Ano inválido.\nRetornando ao menu...");
        }

        return ano; 
    }


    public static void validarIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN não pode ser vazio.\nRetornando ao menu...");
        }
        if (!isbn.matches("\\d+")) {
            throw new IllegalArgumentException("ISBN deve conter apenas números.\nRetornando ao menu...");
        }
    }
}
