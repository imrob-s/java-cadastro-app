package cadastro;

import java.util.Scanner;

/**
 *
 * @author imrob
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int opcao = 0;
        int contador = 0;
        
        Tela.intro();
        
        do {
            Tela.menu();
            opcao = sc.nextInt();
            switch(opcao){
                case 0: 
                    System.out.println("Saindo do programa...");
                    break;
                case 1: 
                    Cadastro.add();
                    break;
                case 2: 
                    Cadastro.listaPessoas();
                    break;
            }
            
            
        } while (opcao != 0);
        
        
        sc.close();
    }
    
}
