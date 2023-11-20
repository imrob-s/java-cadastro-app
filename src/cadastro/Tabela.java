package cadastro;

import cadastro.entities.Endereco;
import cadastro.entities.Pessoa;

public class Tabela {
    public static int[] largurasPessoas = new int[Pessoa.COLUNAS.length];
    public static int[] largurasEnderecos = new int[Endereco.COLUNAS.length];
    private static final int ESPACAMENTO = 2;
    public static void exibirPessoas(Pessoa[] pessoas) {
        final String[] colunas = Pessoa.COLUNAS;

        /*
         * Calcula a largura da coluna da tabela
         * Se a string contida naquela posição do array
         * for maior que o tamanho do titulo da coluna
         * a largura dessa coluna terá o tamanho da
         * string desse array.
         */
        for (int i = 0; i < colunas.length; i++) {
            largurasPessoas[i] = colunas[i].length();
        }
        for (Pessoa pessoa : pessoas) {
            for (int i = 0; i < colunas.length; i++) {
                if (pessoa != null) {
                    if (pessoa.larguras[i] > largurasPessoas[i]) {
                        largurasPessoas[i] = pessoa.larguras[i];
                    }
                } else {
                    break;
                }
            }
        }
        // Mostrando o titulo de cada coluna
        for (int i = 0; i < colunas.length; i++) {
            System.out.printf("\033[1;38;05;231m\033[48;05;243m%-" +
                    (largurasPessoas[i] + ESPACAMENTO) + "s\033[0m", colunas[i]);
        }
        System.out.println();

        /* Pra cada linha da tabela, verifica se possui alguma informação
        se tiver algum cadastro a informação é exibida caso contrario
        a linha é pulada e não é exibida.
        */
        for (Pessoa pessoa: pessoas) {
            if (pessoas[0] == null) {
                System.out.println("\033[38;05;9m\033[48;5;16m      SEM CADASTROS    \033[0m");
                break;
            } else if (pessoa != null) {
                pessoa.mostrar();
                System.out.println();
            }
        }
    }public static void exibirEnderecos(Endereco[] enderecos) {
        final String[] colunas = Endereco.COLUNAS;

        /*
         * Calcula a largura da coluna da tabela
         * Se a string contida naquela posição do array
         * for maior que o tamanho do titulo da coluna
         * a largura dessa coluna terá o tamanho da
         * string desse array.
         */
        for (int i = 0; i < colunas.length; i++) {
            largurasEnderecos[i] = colunas[i].length();
        }
        for (Endereco endereco : enderecos) {
            for (int i = 0; i < colunas.length; i++) {
                if (endereco != null) {
                    if (endereco.larguras[i] > largurasEnderecos[i]) {
                        largurasEnderecos[i] = endereco.larguras[i];
                    }
                } else {
                    break;
                }
            }
        }
        // Mostrando o titulo de cada coluna
        for (int i = 0; i < colunas.length; i++) {
            System.out.printf("\033[1;38;05;231m\033[48;05;243m%-" +
                    (largurasEnderecos[i] + ESPACAMENTO) + "s\033[0m", colunas[i]);
        }
        System.out.println();

        /* Pra cada linha da tabela, verifica se possui alguma informação
        se tiver algum cadastro a informação é exibida caso contrario
        a linha é pulada e não é exibida.
        */
        for (Endereco endereco: enderecos) {
            if (enderecos[0] == null) {
                System.out.println("\033[38;05;9m\033[48;5;16m       SEM CADASTROS        \033[0m");
                break;
            } else if (endereco != null) {
                endereco.mostrar();
                System.out.println();
            }
        }
    }
}
