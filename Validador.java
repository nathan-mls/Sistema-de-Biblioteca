public class Validador {

    public static void validarTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio.");
        }
    }

    public static void validarAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor não pode ser vazio.");
        }
        if (!autor.matches("[A-Za-zÀ-ÖØ-öø-ÿ ]+")) {
            throw new IllegalArgumentException("Nome do(a) autor(a) deve conter apenas letras.");
        }
    }

    public static void validarAno(int ano) {
        if (ano < 0) {
            throw new IllegalArgumentException("Ano inválido.");
        }
    }

    public static void validarIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN não pode ser vazio.");
        }
        if (!isbn.matches("\\d+")) {
            throw new IllegalArgumentException("ISBN deve conter apenas números.");
        }
    }
}
