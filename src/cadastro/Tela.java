package cadastro;

import java.io.IOException;

/**
 * A classe Tela contém métodos para exibir informações no terminal, como
 * mensagens de introdução, menu principal, opção invalida, titulos e a exibição de informações
 * cadastradas em um banco de dados (Array).
 * Além disso, possui um método para limpar o conteúdo do terminal/tela.
 *
 * @author Rob Silva
 */
public class Tela {

    /**
     * Apresenta uma mensagem de introdução colorida no terminal.
     * Utilizado codigo ANSI para estilização de cores
     */
    public static void intro() {
        System.out.println("\033[48;5;190m                                  "
                + "  \033[0m");
        System.out.println("\033[1;38;5;232m\033[48;5;190m  "
                + "### Bem Vindo ao CadastroApp ###  \033[0m");
        System.out.println("\033[48;5;190m                                "
                + "    \033[0m");
    }

    /**
     * Exibe a mensagem de erro "OPÇÃO INVALIDA"
     * A mensagem é estilizada com cores
     */
    public static void opcaoInvalida() {
        System.out.println("\033[38;5;15m\033[48;5;124m                                   \033[0m");
        System.out.println("\033[1;38;5;15m\033[48;5;124m          OPÇÃO INVALIDA!          \033[0m");
        System.out.print("\033[38;5;15m\033[48;5;124m                                   \033[0m");
    }

    /**
     * Exibe o menu principal do aplicativo CadastroApp.
     */
    public static void menuPrincipal() {
        System.out.println("\n\033[1;38;5;166m" +
                "-------------- MENU ----------------\033[0m");
        System.out.println("[ 1 ] - Cadastrar pessoa");
        System.out.println("[ 2 ] - Cadastrar endereço");
        System.out.println("[ 3 ] - Exibir pessoas cadastradas");
        System.out.println("[ 4 ] - Exibir endereços cadastrados");
        System.out.println("\033[38;5;1m[ 0 ] - Sair\033[0m");
        System.out.print("\033[38;5;215m\nDigite uma opção: \033[0m");
    }

    /**
     * Exibe as pessoas cadastradas em uma tabela.
     * A tabela é estilizada com cores através do codigo ANSI.
     */
    public static void exibirPessoas() {
        Tabela.exibirPessoas(Cadastro.pessoas);
    }

    /**
     * Exibe os endereços cadastradas em uma tabela.
     * A tabela é estilizada com cores através do codigo ANSI.
     */
    public static void exibirEnderecos() {
        Tabela.exibirEnderecos(Cadastro.enderecos);
    }

    /**
     * Exibe um titulo personalizado.
     *
     * @param texto Escreva um titulo para ser exibido na tela.
     */
    public static void titulo(String texto) {
        System.out.printf("\033[1;38;05;231m\033[48;05;243m     %s     \033[0m\n", texto.toUpperCase());
    }

    /**
     * Esse método é utilizado para limpar o conteúdo da tela / terminal.
     *
     * @throws IOException          Exceção caso ocorra algum erro durante a execução
     *                              do metodo Tela.limpar()
     * @throws InterruptedException Exceção caso ocorra algum erro durante a execução
     *                              do metodo Tela.limpar()
     */
    public static void limpar() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
    }
}
