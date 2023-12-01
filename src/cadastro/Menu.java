package cadastro;

import java.io.IOException;

/**
 * A classe Menu contém métodos para exibir informações no terminal, como
 * mensagens de introdução, menu principal, opção invalida e titulos.
 * Além disso, possui um método para limpar o conteúdo do terminal/tela.
 *
 * @author Rob Silva
 */
public class Menu {
    private static final String CT_PRETO = "\033[1;38;5;232m"; // Cor Texto Preto
    // private static final String CT_BRANCO = "\033[1;38;5;15m"; // Cor Texto Branco
    private static final String CT_BRANCO = "\033[1;38;05;231m"; // Cor Texto Branco
    private static final String CF_CINZA = "\033[48;05;243m"; // Cor Fundo Cinza
    private static final String CT_LARANJA = "\033[1;38;5;166m"; // Cor Texto Laranja
    private static final String CT_LARANJA_CLARO = "\033[38;5;215m"; // Cor Texto Laranja Claro
    private static final String CT_VERMELHO = "\033[38;5;1m"; // Cor Texto Vermelho
    private static final String CF_AMARELO = "\033[48;5;190m"; // Cor Fundo Amarelo
    private static final String CF_VERMELHO = "\033[48;5;124m"; // Cor Fundo Amarelo
    private static final String COR_ERRO = "\033[38;05;9m\033[48;5;16m"; // Cor para erros apresentado no terminal
    private static final String COR_SUCESSO = "\033[38;05;10m\033[48;5;16m"; // Cor para sucessos apresentado no terminal
    private static final String RESET_COR = "\033[0m";
    /**
     * Apresenta uma mensagem de introdução colorida no terminal.
     * Utilizado codigo ANSI para estilização de cores
     */
    public static void intro() {
        System.out.printf("%s                                    %s\n", CF_AMARELO, RESET_COR);
        System.out.printf("%s%s  ### Bem Vindo ao CadastroApp ###  %s\n", CF_AMARELO, CT_PRETO, RESET_COR);
        System.out.printf("%s                                    %s\n", CF_AMARELO, RESET_COR);
    }
    /**
     * Exibe a mensagem de erro "OPÇÃO INVALIDA"
     * A mensagem é estilizada com cores
     */
    public static void opcaoInvalida() {
        System.out.printf("%s%s          OPÇÃO INVALIDA!          %s", CT_BRANCO, CF_VERMELHO, RESET_COR);
    }
    /**
     * Exibe o menu principal do aplicativo CadastroApp.
     */
    public static void principal() throws IOException, InterruptedException {
        ConsoleUI.limpar();
        intro();
        System.out.printf("\n%s------ MENU PRINCIPAL ------%s\n", CT_LARANJA, RESET_COR);
        System.out.println("[ 1 ] - Cadastrar pessoa");
        System.out.println("[ 2 ] - Cadastrar endereço");
        System.out.println("[ 3 ] - Exibir pessoas cadastradas");
        System.out.println("[ 4 ] - Exibir endereços cadastrados");
        System.out.printf("%s[ 0 ] - Sair%s", CT_VERMELHO, RESET_COR);
        System.out.printf("%s\n\nDigite uma opção: %s", CT_LARANJA_CLARO, RESET_COR);
    }
    public static void menuCRUD(){
        System.out.println("\n\033[1;38;5;166m" +
                "---------- MENU CADASTRO --------\033[0m");
        System.out.println("[ 1 ] - Novo cadastro");
        System.out.println("[ 2 ] - Atualizar cadastro");
        System.out.println("[ 3 ] - Apagar cadastro");
        System.out.printf("%s[ 0 ] - Voltar%s\n", CT_VERMELHO, RESET_COR);
        System.out.printf("%s\nDigite uma opção: %s", CT_LARANJA_CLARO, RESET_COR);
    }
    /**
     * Exibe um titulo personalizado.
     *
     * @param texto Escreva um titulo para ser exibido na tela.
     */
    public static void titulo(String texto) {
        System.out.printf("%s%s     %s     %s\n",CT_BRANCO, CF_CINZA, texto.toUpperCase(), RESET_COR);
    }
    public static void erro(String texto) {
        System.out.printf("%s     %s      %s\n", COR_ERRO, texto.toUpperCase(), RESET_COR);
    }
    public static void sucesso(String texto) {
        System.out.printf("%s     %s     %s\n", COR_SUCESSO, texto.toUpperCase(), RESET_COR);
    }

}
