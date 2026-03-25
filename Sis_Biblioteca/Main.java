package Sis_Biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA ===");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar todos os livros");
            System.out.println("3 - Buscar livro por título");
            System.out.println("4 - Buscar livros por autor");
            System.out.println("5 - Cadastrar usuário");
            System.out.println("6 - Usuário pegar livro");
            System.out.println("7 - Usuário devolver livro");
            System.out.println("8 - Listar usuários");
            System.out.println("9 - Remover livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Ano de publicação: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    Livro livro = new Livro(titulo, autor, isbn, ano);
                    biblioteca.adicionarLivro(livro);
                    break;

                case 2:
                    biblioteca.listarTodosLivros();
                    break;

                case 3:
                    System.out.print("Título do livro: ");
                    String tituloBusca = scanner.nextLine();
                    Livro livroEncontrado = biblioteca.buscarLivroPorTitulo(tituloBusca);
                    if (livroEncontrado != null) {
                        System.out.println(livroEncontrado);
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    break;

                case 4:
                    System.out.print("Autor: ");
                    String autorBusca = scanner.nextLine();
                    var livrosPorAutor = biblioteca.buscarLivrosPorAutor(autorBusca);
                    if (livrosPorAutor.isEmpty()) {
                        System.out.println("Nenhum livro encontrado para este autor!");
                    } else {
                        for (Livro l : livrosPorAutor) {
                            System.out.println(l);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("ID do usuário: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Usuario usuario = new Usuario(nome, id);
                    biblioteca.cadastrarUsuario(usuario);
                    break;

                case 6:
                    System.out.print("ID do usuário: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título do livro: ");
                    String tituloLivro = scanner.nextLine();

                    Usuario usuarioEncontrado = null;
                    for (Usuario u : biblioteca.usuario()) {
                        if (u.getId() == idUsuario) {
                            usuarioEncontrado = u;
                            break;
                        }
                    }

                    Livro livroParaPegar = biblioteca.buscarLivroPorTitulo(tituloLivro);

                    if (usuarioEncontrado != null && livroParaPegar != null) {
                        usuarioEncontrado.pegarLivro(livroParaPegar);
                    } else {
                        System.out.println("Usuário ou livro não encontrado!");
                    }
                    break;

                case 7:
                    System.out.print("ID do usuário: ");
                    int idDevolucao = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título do livro: ");
                    String tituloDevolucao = scanner.nextLine();

                    Usuario usuarioDevolucao = null;
                    for (Usuario u : biblioteca.usuario()) {
                        if (u.getId() == idDevolucao) {
                            usuarioDevolucao = u;
                            break;
                        }
                    }

                    Livro livroDevolver = biblioteca.buscarLivroPorTitulo(tituloDevolucao);

                    if (usuarioDevolucao != null && livroDevolver != null) {
                        usuarioDevolucao.devolverLivro(livroDevolver);
                    } else {
                        System.out.println("Usuário ou livro não encontrado!");
                    }
                    break;

                case 8:
                    biblioteca.listarUsuarios();
                    break;

                case 9:
                    System.out.print("ISBN do livro: ");
                    String isbnRemover = scanner.nextLine();
                    biblioteca.removerLivro(isbnRemover);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}