
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Biblioteca {
    private List<Livro> livros;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int ano) {
        Livro livro = new Livro(titulo, autor, ano);
        livros.add(livro);
    }

    public void realizarEmprestimo(Usuario usuario, String tituloLivro) {
        Optional<Livro> livroEncontrado = buscarLivroDisponivel(tituloLivro);

        if (livroEncontrado.isPresent()) {
            Livro livro = livroEncontrado.get();
            criarEmprestimo(usuario, livro);
            notificarEmprestimoRealizado(usuario, livro);
        } else {
            notificarLivroIndisponivel();
        }
    }

    private Optional<Livro> buscarLivroDisponivel(String titulo) {
        return livros.stream()
                .filter(l -> l.getTitulo().equals(titulo) && l.isDisponivel())
                .findFirst();
    }

    private void criarEmprestimo(Usuario usuario, Livro livro) {
        Emprestimo emprestimo = new Emprestimo(usuario, livro);
        emprestimos.add(emprestimo);
        livro.setDisponivel(false);
    }

    private void notificarEmprestimoRealizado(Usuario usuario, Livro livro) {
        System.out.println("Emprestimo Realizado: " + usuario.getNome() + 
                          " pegou " + livro.getTitulo());
    }

    private void notificarLivroIndisponivel() {
        System.out.println("Livro nao disponivel");
    }

    public void listarEmprestimos() {
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("Usuario: " + emprestimo.getUsuario().getNome() + 
                             " - Livro: " + emprestimo.getLivro().getTitulo() + 
                             " - Data: " + emprestimo.getDataFormatada());
        }
    }

    public void relatorioLivros() {
        for (Livro livro : livros) {
            System.out.println(livro.toString());
        }
    }
}