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
                case 0: 
                    System.out.println("Saindo do programa...");
                    break;
                case 1:
                    Tela.limpar();
                    Cadastro.add();
                    break;
                case 2:
                    Tela.limpar();
                    Tela.exibirCadastrados();
                    break;
            }
            
            
        } while (opcao != 0);
        
        
        sc.close();
    }
    
}
