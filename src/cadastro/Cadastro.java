package cadastro;

import java.util.Scanner;

/**
 *
 * @author imrob
 */
public class Cadastro {
    private static Scanner sc = new Scanner(System.in);
    private static final int capacidade = 10;
    private static String pessoas[][] = new String[capacidade][5];
    
    private static int contador = 0;
    
    public static void add(){
        if (contador < capacidade){
            System.out.println("Nome: ");
            pessoas[contador][0] = sc.next();
            System.out.println("Idade: ");
            pessoas[contador][1] = sc.next();
            System.out.println("Sexo: ");
            pessoas[contador][2] = sc.next();
            System.out.println("Altura");
            pessoas[contador][3] = sc.next();
            System.out.println("Cidade");
            pessoas[contador][4] = sc.next();
            contador++;
        } else {
            contador = 0;
            add();
        }
    }

    public static void listaPessoas() {
    System.out.println("Pessoas cadastradas:");

    for (int i = 0; i < pessoas.length; i++) {
    if (pessoas[i][0] != null
            && pessoas[i][1] != null
            && pessoas[i][2] != null
            && pessoas[i][3] != null
            && pessoas[i][4] != null) {
        System.out.println("-------------------\nNome: " + pessoas[i][0] +
            ", Idade: " + pessoas[i][1] + ", Sexo: " + pessoas[i][2] +
            ", Altura: " + pessoas[i][3] + ", Cidade: " + pessoas[i][4] +
            "\n-----------------------"
        );
    }
}

    }
}
