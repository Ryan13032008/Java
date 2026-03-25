package Sis_Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> acervo;
    private List<Usuario> usuarios;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.acervo = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        acervo.add(livro);
        System.out.println("Livro \"" + livro.getTitulo() + "\" adicionado ao acervo!");
    }

    public void removerLivro(String isbn) {
        Livro livroRemover = null;
        for (Livro livro : acervo) {
            if (livro.getIsbn().equals(isbn)) {
                livroRemover = livro;
                break;
            }
        }

        if (livroRemover != null) {
            acervo.remove(livroRemover);
            System.out.println("Livro \"" + livroRemover.getTitulo() + "\" removido do acervo!");
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário \"" + usuario.getNome() + "\" cadastrado com sucesso!");
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public List<Livro> buscarLivrosPorAutor(String autor) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public void listarTodosLivros() {
        if (acervo.isEmpty()) {
            System.out.println("Acervo vazio!");
        } else {
            System.out.println("=== ACERVO DA BIBLIOTECA " + nome.toUpperCase() + " ===");
            for (Livro livro : acervo) {
                System.out.println(livro);
            }
        }
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado!");
        } else {
            System.out.println("=== USUÁRIOS CADASTRADOS ===");
            for (Usuario usuario : usuarios) {
                System.out.println("ID: " + usuario.getId() + " | Nome: " + usuario.getNome());
                usuario.listarLivrosEmprestados();
            }
        }
    }

    public Usuario[] usuario() {
        throw new UnsupportedOperationException("Unimplemented method 'usuario'");
    }
}