package cadastro;

import cadastro.entities.Endereco;
import cadastro.entities.Pessoa;

/**
 * Esta classe formata um vetor com informações para ser exibido como uma tabela estilizada
 * no terminal.
 * A largura das colunas é calculada a partir da string mais larga de uma posição do vetor.
 */
public class TabelaPrinter {
    /**
     * Vetor que armazena a largura das colunas para o tipo de dado Pessoa.
     */
    public static int[] larguraColPessoa = new int[Pessoa.COLUNAS.length];
    /**
     * Vetor que armazena a largura das colunas para o tipo de dado Endereco.
     */
    public static int[] larguraColEndereco = new int[Endereco.COLUNAS.length];
    /**
     * Espaçamento entre as colunas na tabela.
     */
    private static final int ESPACAMENTO = 2;
    /*
     * Códigos ANSI para cor do texto e do fundo.
     */
    private static final String COR_TEXTO = "\033[1;38;05;231m"; // Branco
    private static final String COR_FUNDO = "\033[48;05;243m"; // Cinza
    private static final String RESET_COR = "\033[0m";

    /**
     * Exibe na tela uma tabela com as informações de um array do tipo Pessoa.
     *
     * @param pessoas Um array do tipo Pessoa.
     */
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
            larguraColPessoa[i] = colunas[i].length();
        }
        for (Pessoa pessoa : pessoas) {
            for (int i = 0; i < colunas.length; i++) {
                if (pessoa != null) {
                    pessoa.larguras[1] = pessoa.getNome().length();
                    if (pessoa.larguras[i] > larguraColPessoa[i]) {
                        larguraColPessoa[i] = pessoa.larguras[i];
                    }
                } else {
                    break;
                }
            }
        }
        // Mostrando o titulo de cada coluna
        for (int i = 0; i < colunas.length; i++) {
            System.out.printf("%s%s%-" + (larguraColPessoa[i] + ESPACAMENTO) + "s%s", COR_TEXTO, COR_FUNDO,
                    colunas[i], RESET_COR);
        }
        System.out.println();

        /* Pra cada linha da tabela, verifica se possui alguma informação
        se tiver algum cadastro a informação é exibida caso contrario
        a linha é pulada e não é exibida.
        Se não houver nenhuma informação para ser exibida será mostrado a mensagem "SEM CADASTROS"
        */
        int qntCadastros = 0;
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                qntCadastros++;
                pessoa.mostrar();
                System.out.println();
            }
        }
        if (qntCadastros == 0) Menu.erro("SEM CADASTROS");
    }

    /**
     * Exibe na tela uma tabela com as informações de um array do tipo Endereco.
     *
     * @param enderecos Um array do tipo Endereco.
     */
    public static void exibirEnderecos(Endereco[] enderecos) {
        final String[] colunas = Endereco.COLUNAS;

        /*
         * Calcula a largura da coluna da tabela
         * Se a string contida naquela posição do array
         * for maior que o tamanho do titulo da coluna
         * a largura dessa coluna terá o tamanho da
         * string desse array.
         */
        for (int i = 0; i < colunas.length; i++) {
            larguraColEndereco[i] = colunas[i].length();
        }
        for (Endereco endereco : enderecos) {
            for (int i = 0; i < colunas.length; i++) {
                if (endereco != null) {
                    endereco.larguras[1] = endereco.getRua().length();
                    endereco.larguras[4] = endereco.getCidade().length();
                    endereco.larguras[5] = endereco.getEstado().length();
                    endereco.larguras[6] = endereco.getPais().length();
                    if (endereco.larguras[i] > larguraColEndereco[i]) {
                        larguraColEndereco[i] = endereco.larguras[i];
                    }
                } else {
                    break;
                }
            }
        }
        // Mostrando o titulo de cada coluna
        for (int i = 0; i < colunas.length; i++) {
            System.out.printf("%s%s%-" + (larguraColEndereco[i] + ESPACAMENTO) + "s%s",
                    COR_TEXTO, COR_FUNDO, colunas[i], RESET_COR);
        }
        System.out.println();

        /* Pra cada linha da tabela, verifica se possui alguma informação
        se tiver algum cadastro a informação é exibida caso contrario
        a linha é pulada e não é exibida.
        Se não houver nenhuma informação para ser exibida será mostrado a mensagem "SEM CADASTROS"
        */
        int qntCadastros = 0;
        for (Endereco endereco : enderecos) {
            if (endereco != null) {
                qntCadastros++;
                endereco.mostrar();
                System.out.println();
            }
        }
        if (qntCadastros == 0) Menu.erro("SEM CADASTROS");
    }
}
