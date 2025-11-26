import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {

    for (Livro l : livros) {
        if (l.getIsbn().equals(livro.getIsbn())) {
            throw new IllegalArgumentException("Livro já cadastrado (ISBN duplicado).\nRetornando ao menu...");
            }
        }

    livros.add(livro);
    }


    public List<Livro> buscarPorTitulo(String titulo) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(livro);
               
            }
        }
        return resultado;
    }

    public List<Livro> buscarPorAutor(String autor) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public List<Livro> buscarPorAno(int ano) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAno() == ano) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public void ordenarPorTitulo() {
        int n = livros.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (livros.get(j).getTitulo()
                        .compareToIgnoreCase(livros.get(j + 1).getTitulo()) > 0) {
                    Livro temp = livros.get(j);
                    livros.set(j, livros.get(j + 1));
                    livros.set(j + 1, temp);
                }
            }
        }
    }

    public void ordenarPorAutor() {
        int n = livros.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (livros.get(j).getAutor()
                        .compareToIgnoreCase(livros.get(j + 1).getAutor()) > 0) {
                    Livro temp = livros.get(j);
                    livros.set(j, livros.get(j + 1));
                    livros.set(j + 1, temp);
                }
            }
        }
    }

    public void ordenarPorAno() {
        int n = livros.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (livros.get(j).getAno() > livros.get(j + 1).getAno()) {
                    Livro temp = livros.get(j);
                    livros.set(j, livros.get(j + 1));
                    livros.set(j + 1, temp);
                }
            }
        }
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("\nNenhum livro cadastrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public boolean removerPorIsbn(String isbn) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getIsbn().equalsIgnoreCase(isbn)) {
                livros.remove(i);
                return true;
            }
        }
        return false;
    }
}