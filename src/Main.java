
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro("O Senhor dos Aneis", "J. R. R. Tolkien", 1954);
        biblioteca.adicionarLivro("Refatoracao", "Martin Fowler", 2020);

        Usuario usuario = new Usuario("Maria", 21, "maria@gmail.com");

        biblioteca.realizarEmprestimo(usuario, "O Senhor dos Aneis");
        biblioteca.realizarEmprestimo(usuario, "Refatoracao");

        biblioteca.listarEmprestimos();
    }
}