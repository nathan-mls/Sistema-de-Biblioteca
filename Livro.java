public class Livro {
    private final String titulo;
    private final String autor;
    private final int ano;
    private final String isbn;

    public Livro(String titulo, String autor, int ano, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + " | Autor: " + autor +
               " | Ano: " + ano + " | ISBN: " + isbn;
    }
}
