package cadastro;

import static cadastro.Cadastro.pessoas;
import java.io.IOException;

/**
 * A classe Tela contém métodos para exibir informações no terminal, como
 * mensagens de introdução, menu principal e a exibição de pessoas
 * cadastradas em um banco de dados (Array).
 * Além disso, possui um método para limpar o conteúdo do terminal.
 * 
 * @author Rob Silva
 */
public class Tela {
    
    /**
    * Apresenta uma mensagem de introdução colorida no terminal.
    * Utilizado codigo ANSI para estilização de cores
    */
    public static void intro(){
        System.out.println("\033[48;5;190m                                  "
                + "  \033[0m");
        System.out.println("\033[1;38;5;232m\033[48;5;190m  "
                + "### Bem Vindo ao CadastroApp ###  \033[0m");
        System.out.println("\033[48;5;190m                                "
                + "    \033[0m");
    }
    
    /**
     * Exibe o menu principal no terminal.
     */
    public static void menuPrincipal(){
        System.out.println("\n\033[1;38;5;166m" +
                "-------------- MENU ----------------\033[0m");
        System.out.println("[ 1 ] - Cadastrar pessoa");
        System.out.println("[ 2 ] - Exibir pessoas cadastradas");
        System.out.println("\033[38;5;1m[ 0 ] - Sair\033[0m");
        System.out.print("\033[38;5;215m\nDigite uma opção: \033[0m");      
    }
    
    /**
     * Exibe as pessoas cadastradas em uma tabela.
     * A tabela é estilizada com cores através do codigo ANSI.
     */
    public static void exibirCadastrados(){
        final String[] colunas = {"Nome", "Idade", "Sexo", "Altura", "Cidade"};
        int[] larguras = new int[colunas.length];
        
        /* 
         * Calcula a largura da coluna da tabela
         * Se a string contida naquela posição do array
         * for maior que o tamanho do titulo da coluna
         * a largura dessa coluna terá o tamanho da
         * string desse array.
        */
        for (int i = 0; i < colunas.length; i++) {
            larguras[i] = colunas[i].length();
            for (String[] pessoa : pessoas) {
                if (Utils.arrayPreenchida(pessoa)) {
                    if (pessoa[i].length() > larguras[i]) {
                    larguras[i] = pessoa[i].length();
                    }
                } else {
                    break;
                }
            }
        }
        // Mostrando o titulo de cada coluna
        for (int i = 0; i < colunas.length; i++) {
            System.out.printf("\033[1;38;05;231m\033[48;05;243m%-" +
                    (larguras[i] + 2) + "s\033[0m", colunas[i]);
        }
        System.out.println();
        
        /* Pra cada linha da minha tabela, verifica se possui alguma informação
        se tiver alguem cadastrado a informação é exibida caso contrario
        a linha é pulada e não é exibida.
        */
        for (String[] pessoa : pessoas) {
            if (Utils.arrayPreenchida(pessoa)) {
                for (int i = 0; i < pessoa.length; i++) {
                    System.out.printf("\033[38;05;234m\033[48;05;15m%-" + (larguras[i] + 2) + "s\033[0m", pessoa[i]);
                }
                System.out.println();
            }
        }
        
    }
    
    /**
     * Esse método é utilizado para limpar o conteúdo da tela / terminal.
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void limpar() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
    }
}
