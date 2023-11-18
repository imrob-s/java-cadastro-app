package cadastro;

import java.util.Scanner;

/**
 * A classe Cadastro é responsável por gerenciar um cadastro de pessoas.
 */
public class Cadastro {
    private static Scanner sc = new Scanner(System.in);
    private static final int capacidade = 10;
    public static String pessoas[][] = new String[capacidade][5];
    private static int contador = 0;

    /**
     * Adiciona uma nova pessoa ao cadastro.
     * Solicita ao usuário informações como nome, idade, sexo, altura e cidade.
     * Verifica se todos os campos sejam preenchidos antes de adicionar a pessoa.
     * Se a capacidade máxima for atingida, reinicia o contador para permitir
     * novos cadastros.
     */
    public static void add() {
        if (contador < capacidade) {
            System.out.print("Digite o nome: ");
            pessoas[contador][0] = sc.next();
            System.out.print("Digite a idade: ");
            pessoas[contador][1] = sc.next();
            System.out.print("Digite o sexo: ");
            pessoas[contador][2] = sc.next();
            System.out.print("Digite a altura: ");
            pessoas[contador][3] = sc.next();
            System.out.print("Digite a cidade: ");
            pessoas[contador][4] = sc.next();
            if (!Utils.arrayPreenchida(pessoas[contador])) {
                System.out.println("TODOS OS CAMPOS PRECISAM SER PREENCHIDOS!");
                System.out.println("PREENCHA O CADASTRO NOVAMENTE\n");
                add();
            }
            contador++;
        } else {
            contador = 0;
            add();
        }
    }
}
