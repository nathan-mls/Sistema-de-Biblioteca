import java.util.List;
import java.util.Scanner;

public class Main {

    private static void pausa() {
        try {
            Thread.sleep(3000); // 3 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch"})
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n=== Sistema de Biblioteca ===\n");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Buscar livro por título");
            System.out.println("3. Buscar livro por autor(a)");
            System.out.println("4. Buscar livro por ano");
            System.out.println("5. Listar livros ordenados por título");
            System.out.println("6. Listar livros ordenados por autor(a)");
            System.out.println("7. Listar livros ordenados por ano");
            System.out.println("8. Listar todos os livros");
            System.out.println("9. Remover livro por ISBN");
            System.out.println("0. Sair");
            System.out.print("\nEscolha: ");

            String opcaoStr = sc.nextLine();
            try {
                opcao = Integer.parseInt(opcaoStr.trim());
            } catch (NumberFormatException e) {
                System.out.println("\nOpção inválida. Digite um número de 0 a 9!\n");
                pausa();
                continue;
            }

            switch (opcao) {

                // ============================
                // 1. CADASTRAR LIVRO
                // ============================
                case 1 -> {
                    try {
                    System.out.print("\nTítulo: ");
                    String titulo = sc.nextLine();
                    Validador.validarTitulo(titulo);

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    Validador.validarAutor(autor);

                    System.out.print("Ano: ");
                    int ano = Integer.parseInt(sc.nextLine());
                    Validador.validarAno(ano);

                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    Validador.validarIsbn(isbn);

                    Livro livro = new Livro(titulo, autor, ano, isbn);
                    biblioteca.adicionarLivro(livro);

                    System.out.println("\nLivro cadastrado!");
             
                    }  catch (Exception e) {
                    System.out.println("\nErro: " + e.getMessage());
                    }
                     pausa();
                }
                // ============================
                // 2. BUSCAR POR TÍTULO
                // ============================
                case 2 -> {
                    System.out.print("\nDigite o título: ");
                    String tituloStr = sc.nextLine().trim();

                    List<Livro> resultados = biblioteca.buscarPorTitulo(tituloStr);

                    if (resultados.isEmpty()) {
                        System.out.println("\nNenhum livro encontrado.\n");
                    } else {
                        resultados.forEach(System.out::println);
                    }
                    pausa();
                }

                // ============================
                // 3. BUSCAR POR AUTOR
                // ============================
                case 3 -> {
                    System.out.print("\nDigite o(a) autor(a): ");
                    String autorStr = sc.nextLine().trim();

                    try {
                         Validador.validarAutor(autorStr); // <── validação acrescentada
                    } catch (Exception e) {
                         System.out.println("\n" + e.getMessage() + "\n");
                         pausa();
                         break;
                    }

                    List<Livro> resultados = biblioteca.buscarPorAutor(autorStr);

                    if (resultados.isEmpty()) {
                        System.out.println("\nNenhum livro encontrado.\n");
                    } else {
                        resultados.forEach(System.out::println);
                    }
                    pausa();
                }

                // ============================
                // 4. BUSCAR POR ANO
                // ============================
                case 4 -> {
                    System.out.print("\nDigite o ano: ");
                    String anoStrBusca = sc.nextLine();

                    try {
                        int buscaAno = Integer.parseInt(anoStrBusca.trim());
                        List<Livro> resultados = biblioteca.buscarPorAno(buscaAno);

                        if (resultados.isEmpty()) {
                            System.out.println("\nNenhum livro encontrado.\n");
                        } else {
                            resultados.forEach(System.out::println);
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage() + "\n");
                    }

                    pausa();
                }

                // ============================
                // 5. ORDENAR POR TÍTULO
                // ============================
                case 5 -> {
                    biblioteca.ordenarPorTitulo();
                    biblioteca.listarLivros();
                    pausa();
                }

                // ============================
                // 6. ORDENAR POR AUTOR
                // ============================
                case 6 -> {
                    biblioteca.ordenarPorAutor();
                    biblioteca.listarLivros();
                    pausa();
                }

                // ============================
                // 7. ORDENAR POR ANO
                // ============================
                case 7 -> {
                    biblioteca.ordenarPorAno();
                    biblioteca.listarLivros();
                    pausa();
                }

                // ============================
                // 8. LISTAR TODOS
                // ============================
                case 8 -> {
                    biblioteca.listarLivros();
                    pausa();
                }

                // ============================
                // 9. REMOVER POR ISBN
                // ============================
                case 9 -> {
                    System.out.print("\nDigite o ISBN do livro a remover: ");
                    String isbnRemover = sc.nextLine().trim();

                    boolean removido = biblioteca.removerPorIsbn(isbnRemover);

                    if (removido) {
                        System.out.println("\nLivro removido com sucesso!");
                    } else {
                        System.out.println("\nLivro não encontrado.");
                    }
                    pausa();
                }

                // ============================
                // 0. SAIR
                // ============================
                case 0 -> {
                    System.out.println("\nEncerrando...");
                }

                // ============================
                // OPÇÃO INVÁLIDA
                // ============================
                default -> {
                    System.out.println("\nOpção inválida. Digite um número de 0 a 9!");
                    pausa();
                }
            }

        } while (opcao != 0);

        sc.close();
    }
}
