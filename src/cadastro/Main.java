package cadastro;

import java.io.IOException;
import java.util.Scanner;

/**
 * A classe Main é responsável por iniciar o programa de cadastro de pessoas.
 * O programa oferece um menu principal com opções para adicionar pessoas e endereços ao cadastro
 * e exibir as informações cadastradas em uma tabela.
 * @author Rob Silva
 * @version 1.1
 * @since 2023-11-11
 */
public class Main {
    private static final int CADASTRO_PESSOA = 1;
    private static final int CADASTRO_ENDERECO = 2;
    private static final int EXIBIR_PESSOAS = 3;
    private static final int EXIBIR_ENDERECOS = 4;
    private static final int SAIR = 0;
    /**
     * Esse é o metodo principal que inicia o programa CadastroApp
     * 
     * @param args (não utilizado nesse programa)
     * @throws IOException Exceção caso ocorra algum erro durante a execução 
     * do metodo Tela.limpar()
     * @throws InterruptedException Exceção caso ocorra algum erro durante a execução 
     * do metodo Tela.limpar()
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner (System.in);
        int opcao = 0;
        
        Tela.limpar();
        Tela.intro();

        do {
            Tela.menuPrincipal();
            opcao = sc.nextInt();
            switch(opcao){
                case CADASTRO_PESSOA:
                    Tela.limpar();
                    Tela.titulo("cadastro de pessoas");
                    Cadastro.addPessoa();
                    break;
                case CADASTRO_ENDERECO:
                    Tela.limpar();
                    Tela.titulo("cadastro de enderecos");
                    Cadastro.addEndereco();
                    break;
                case EXIBIR_PESSOAS:
                    Tela.limpar();
                    Tela.exibirPessoas();
                    break;
                case EXIBIR_ENDERECOS:
                    Tela.limpar();
                    Tela.exibirEnderecos();
                    break;
                case SAIR:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    Tela.limpar();
                    Tela.opcaoInvalida();
                    Thread.sleep(2000);
            }
        } while (opcao != 0);
        sc.close();
    }
}
