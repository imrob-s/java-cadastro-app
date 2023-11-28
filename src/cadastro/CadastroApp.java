package cadastro;

import java.io.IOException;

/**
 * A classe CadastroApp é responsável por iniciar o programa de cadastro de pessoas.
 * O programa oferece um menu principal com opções para adicionar pessoas e endereços ao cadastro
 * e exibir as informações cadastradas em uma tabela.
 *
 * @author Rob Silva
 * @version 1.1
 * @since 2023-11-11
 */
public class CadastroApp {
    /**
     * Esse é o metodo principal que inicia o programa CadastroApp
     *
     * @param args (não utilizado nesse programa)
     * @throws IOException          Exceção caso ocorra algum erro durante a execução
     *                              do metodo ConsoleUI.limpar()
     * @throws InterruptedException Exceção caso ocorra algum erro durante a execução
     *                              do metodo ConsoleUI.limpar()
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        boolean sair;
        ConsoleUI.limpar();
        Menu.intro();

        do {
            sair = ConsoleUI.iniciar();
        } while (!sair);
    }
}
