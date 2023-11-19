package cadastro;

import java.io.IOException;
import java.util.Scanner;

/**
 * A classe Main é responsável por iniciar o programa de cadastro de pessoas.
 * O programa oferece um menu principal com opções para adicionar pessoas ao cadastro
 * e exibir as pessoas cadastradas em uma tabela.
 * @author Rob Silva
 */
public class Main {
    private static final int CADASTRO_PESSOA = 1;
    private static final int CADASTRO_ENDERECO = 1;
    private static final int EXIBIR_PESSOAS = 1;
    private static final int EXIBIR_ENDERECOS = 1;
    private static final int SAIR = 1;
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
                    
                case CADASTRO_ENDERECO:
                    Tela.limpar();
                    Cadastro.add();
                    break;
                case EXIBIR_PESSOAS:
                    Tela.limpar();
                    Tela.exibirCadastrados();
                    break;
                case EXIBIR_ENDERECOS:
                    Tela.limpar();
                    Tela.exibirCadastrados();
                    break;
                case SAIR:
                    System.out.println("Saindo do programa...");
                    break;
            }
            
            
        } while (opcao != 0);
        
        
        sc.close();
    }
    
}
