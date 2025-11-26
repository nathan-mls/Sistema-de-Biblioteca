import java.util.List;
import java.util.Scanner;

public class Main {

    private static void pausa() {
        try {
            Thread.sleep(2000); 
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

               
                case 1 -> {
                    try {
                    System.out.print("\nTítulo: ");
                    String titulo = sc.nextLine();
                    Validador.validarTitulo(titulo);

                    System.out.print("Autor(a):");
                    String autorStr = sc.nextLine().trim().replaceAll("\\s+", " ");
                    Validador.validarAutor(autorStr);

                    System.out.print("Ano: ");
                    String anoDigitado = sc.nextLine();
                    int ano = Validador.validarAno(anoDigitado);


                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    Validador.validarIsbn(isbn);

                    Livro livro = new Livro(titulo, autorStr, ano, isbn);
                    biblioteca.adicionarLivro(livro);

                    System.out.println("\nLivro cadastrado!");
             
                    }  catch (Exception e) {
                    System.out.println("\nErro: " + e.getMessage());
                    }
                     pausa();
                }
              

                case 2 -> {
                    System.out.print("\nDigite o título: ");
                    String tituloStr = sc.nextLine().trim();

                    List<Livro> resultados = biblioteca.buscarPorTitulo(tituloStr);

                    if (resultados.isEmpty()) {
                        System.out.println("\nNenhum livro encontrado.\nRetornando ao menu...\n");
                    } else {
                        resultados.forEach(System.out::println);
                    }
                    pausa();
                }

                
                case 3 -> {
                    System.out.print("\nDigite o(a) autor(a):");
                    String autorStr = sc.nextLine().trim().replaceAll("\\s+", " ");

                    try {
                         Validador.validarAutor(autorStr); 
                    } catch (Exception e) {
                         System.out.println("\n" + e.getMessage() + "\n");
                         pausa();
                         break;
                    }

                    List<Livro> resultados = biblioteca.buscarPorAutor(autorStr);

                    if (resultados.isEmpty()) {
                        System.out.println("\nNenhum livro encontrado.\nRetornando ao menu...\n");
                    } else {
                        resultados.forEach(System.out::println);
                    }
                    pausa();
                }

                
               case 4 -> {
                   System.out.print("\nDigite o ano: ");
                 String anoStrBusca = sc.nextLine();

                    try {
                   // Validação centralizada
                         int buscaAno = Validador.validarAno(anoStrBusca);

                        List<Livro> resultados = biblioteca.buscarPorAno(buscaAno);

                    if (resultados.isEmpty()) {
                         System.out.println("\nNenhum livro encontrado.\nRetornando ao menu...\n");
                    } else {
                          resultados.forEach(System.out::println);
                    }

                    } catch (IllegalArgumentException e) {
                      System.out.println("\n" + e.getMessage() + "\n");
                    }

                    pausa();
                }

                
                case 5 -> {
                    biblioteca.ordenarPorTitulo();
                    biblioteca.listarLivros();
                    pausa();
                }

               
                case 6 -> {
                    biblioteca.ordenarPorAutor();
                    biblioteca.listarLivros();
                    pausa();
                }


                case 7 -> {
                    biblioteca.ordenarPorAno();
                    biblioteca.listarLivros();
                    pausa();
                }

        
                case 8 -> {
                    biblioteca.listarLivros();
                    pausa();
                }


                case 9 -> {
                    System.out.print("\nDigite o ISBN do livro a remover: ");
                    String isbnRemover = sc.nextLine().trim();

                    boolean removido = biblioteca.removerPorIsbn(isbnRemover);

                    if (removido) {
                        System.out.println("\nLivro removido com sucesso!");
                    } else {
                        System.out.println("\nLivro não encontrado.\nRetornando ao menu...\n");
                    }
                    pausa();
                }

                
                case 0 -> {
                    System.out.println("\nEncerrando...");
                }

               
                default -> {
                    System.out.println("\nOpção inválida. Digite um número de 0 a 9!");
                    pausa();
                }
            }

        } while (opcao != 0);

        sc.close();
    }
}
