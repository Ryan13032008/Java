package Sis_Biblioteca;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private boolean disponivel;

    public Livro(String titulo, String autor, String isbn, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro \"" + titulo + "\" emprestado com sucesso!");
        } else {
            System.out.println("Livro \"" + titulo + "\" não está disponível!");
        }
    }

    public void devolver() {
        disponivel = true;
        System.out.println("Livro \"" + titulo + "\" devolvido com sucesso!");
    }

    @Override
    public String toString() {
        return "Livro: " + titulo + " | Autor: " + autor + " | ISBN: " + isbn +
                " | Ano: " + anoPublicacao + " | Disponível: " + (disponivel ? "Sim" : "Não");
    }
}