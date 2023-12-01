package cadastro;

import cadastro.entities.Endereco;
import cadastro.entities.Pessoa;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/**
 * A classe ConsoleUI fornece métodos para interação com o usuário por meio do console.
 */
public class ConsoleUI {
    private static final int CADASTRO_PESSOA = 1, NOVO = 1;
    private static final int CADASTRO_ENDERECO = 2, ATUALIZAR = 2;
    private static final int EXIBIR_PESSOAS = 3, APAGAR = 3;
    private static final int EXIBIR_ENDERECOS = 4;
    private static final int SAIR = 0, VOLTAR = 0;
    private static final Scanner sc = new Scanner(System.in).useLocale(Locale.US).useDelimiter("\n");
    /**
     * Inicia a interface do console para interação com o usuário.
     *
     * @return True se o usuário escolher sair, False caso contrário.
     * @throws IOException            Exceção lançada em caso de erro durante a interação.
     * @throws InterruptedException   Exceção lançada em caso de erro durante a interação.
     */
    public static boolean iniciar() throws IOException, InterruptedException {
        Menu.principal();
        int opcao = validarInt(sc);
        switch (opcao) {
            case CADASTRO_PESSOA:
                limpar();
                cadastrarPessoa();
                break;
            case CADASTRO_ENDERECO:
                limpar();
                cadastrarEndereco();
                break;
            case EXIBIR_PESSOAS:
                while (opcao != VOLTAR) {
                    limpar();
                    TabelaPrinter.exibirPessoas(CadastroManager.getPessoas());
                    Menu.menuCRUD();
                    opcao = validarInt(sc);
                    switch (opcao) {
                        case NOVO:
                            cadastrarPessoa();
                            break;
                        case ATUALIZAR:
                            updatePessoa();
                            break;
                        case APAGAR:
                            deletePessoa();
                            break;
                        case VOLTAR:
                            break;
                        default:
                            Menu.opcaoInvalida();
                            Thread.sleep(2000);
                            break;
                    }
                }
                break;
            case EXIBIR_ENDERECOS:
                while (opcao != VOLTAR) {
                    limpar();
                    TabelaPrinter.exibirEnderecos(CadastroManager.getEnderecos());
                    Menu.menuCRUD();
                    opcao = sc.nextInt();
                    switch (opcao) {
                        case NOVO:
                            cadastrarEndereco();
                            break;
                        case ATUALIZAR:
                            updateEndereco();
                            break;
                        case APAGAR:
                            deleteEndereco();
                            break;
                        case VOLTAR:
                            break;
                        default:
                            Menu.opcaoInvalida();
                            Thread.sleep(2000);
                            break;
                    }
                }
                break;
            case SAIR:
                System.out.println("Saindo do programa...");
                return true;
            default:
                Menu.opcaoInvalida();
                Thread.sleep(2000);
                limpar();
        }
        return false;
    }
    /**
     * Realiza o cadastro de uma nova pessoa com base nas informações fornecidas pelo usuário.
     */
    public static void cadastrarPessoa() {
        Menu.titulo("cadastro de pessoas");
        System.out.print("Digite o nome: ");
        String nome = validarString(sc);
        System.out.print("Digite a idade: ");
        Integer idade = validarInt(sc);
        System.out.print("Digite o sexo: ");
        Character sexo = validarSexo(sc);
        System.out.print("Digite a altura: ");
        Double altura = validarDouble(sc);

        CadastroManager.addPessoa(nome, idade, sexo, altura);
    }
    /**
     * Realiza o cadastro de um novo endereço com base nas informações fornecidas pelo usuário.
     */
    public static void cadastrarEndereco() {
        Menu.titulo("cadastro de enderecos");
        System.out.print("Digite a rua: ");
        String rua = validarString(sc);
        System.out.print("Digite o numero: ");
        Integer numero = validarInt(sc);
        System.out.print("Digite o cep: ");
        String cep = validarString(sc);
        System.out.print("Digite a cidade: ");
        String cidade = validarString(sc);
        System.out.print("Digite o estado: ");
        String estado = validarString(sc);
        System.out.print("Digite o pais: ");
        String pais = validarString(sc);

        if (rua.isEmpty() || cep.isEmpty() || cidade.isEmpty() || pais.isEmpty()) {
            System.out.println("TODOS OS CAMPOS PRECISAM SER PREENCHIDOS!");
            System.out.println("PREENCHA O CADASTRO NOVAMENTE\n");
            cadastrarEndereco();
        }
        CadastroManager.addEndereco(rua, numero, cep, cidade, estado, pais);
    }
    /**
     * Atualiza informações de uma pessoa no cadastro com base no ID fornecido pelo usuário.
     *
     * @throws IOException          Exceção lançada em caso de erro durante a interação.
     * @throws InterruptedException Exceção lançada em caso de erro durante a interação.
     */
    public static void updatePessoa() throws IOException, InterruptedException {
        System.out.print("Digite o ID do cadastro: ");
        int id = validarInt(sc);

        if (validarID(id, CadastroManager.getPessoas())) {
            System.out.print("Qual campo gostaria de atualizar? (Nome, Idade, Sexo, Altura): ");
            String campo = validarString(sc).toLowerCase();

            switch (campo) {
                case "nome" -> {
                    System.out.print("Digite o novo valor: ");
                    String novoValor = validarString(sc);
                    ConsoleUI.limpar();
                    CadastroManager.updatePessoa(id, campo, novoValor);
                    Menu.sucesso("Atualização feita com sucesso!");
                }
                case "sexo" -> {
                    System.out.print("Digite o novo valor: ");
                    String novoValor = String.valueOf(validarSexo(sc));
                    ConsoleUI.limpar();
                    CadastroManager.updatePessoa(id, campo, novoValor);
                    Menu.sucesso("Atualização feita com sucesso!");
                }
                case "idade" -> {
                    System.out.print("Digite o novo valor: ");
                    int novoValor = validarInt(sc);
                    ConsoleUI.limpar();
                    CadastroManager.updatePessoa(id, campo, Integer.toString(novoValor));
                    Menu.sucesso("Atualização feita com sucesso!");
                }
                case "altura" -> {
                    System.out.print("Digite o novo valor: ");
                    double novoValor = validarDouble(sc);
                    ConsoleUI.limpar();
                    CadastroManager.updatePessoa(id, campo, Double.toString(novoValor));
                    Menu.sucesso("Atualização feita com sucesso!");
                }
                default -> {
                    Menu.erro("Campo inválido!");
                    Thread.sleep(2000);
                }
            }
        } else {
            Menu.erro("ID não encontrado");
            Thread.sleep(2000);
        }
    }
    /**
     * Atualiza informações de um endereço no cadastro com base no ID fornecido pelo usuário.
     *
     * @throws IOException          Exceção lançada em caso de erro durante a interação.
     * @throws InterruptedException Exceção lançada em caso de erro durante a interação.
     */
    public static void updateEndereco() throws IOException, InterruptedException {
        limpar();
        TabelaPrinter.exibirEnderecos(CadastroManager.getEnderecos());
        System.out.print("\nDigite o ID do cadastro: ");
        int id = validarInt(sc);

        if (validarID(id, CadastroManager.getEnderecos())) {

            System.out.print("Qual campo gostaria de atualizar? (Rua, Numero, CEP, Cidade, Estado, Pais): ");
            String campo = validarString(sc).toLowerCase();

            switch (campo) {
                case "rua", "cep", "cidade", "estado", "pais" -> {
                    System.out.print("Digite o novo valor: ");
                    String novoValor = validarString(sc);
                    ConsoleUI.limpar();
                    CadastroManager.updateEndereco(id, campo, novoValor);
                    Menu.sucesso("Atualização feita com sucesso!");
                }
                case "numero" -> {
                    System.out.print("Digite o novo valor: ");
                    int novoValor = validarInt(sc);
                    ConsoleUI.limpar();
                    CadastroManager.updateEndereco(id, campo, Integer.toString(novoValor));
                    Menu.sucesso("Atualização feita com sucesso!");
                }
                default -> {
                    Menu.erro("Campo inválido!");
                    Thread.sleep(2000);
                }
            }
        } else {
            Menu.erro("ID não encontrado");
            Thread.sleep(2000);
        }
    }
    /**
     * Exclui uma pessoa do cadastro com base no ID fornecido pelo usuário.
     *
     * @throws InterruptedException Exceção lançada em caso de erro durante a interação.
     */
    public static void deletePessoa() throws InterruptedException {
        System.out.print("Digite o ID do cadastro: ");
        int id = validarInt(sc);
        if (!validarID(id, CadastroManager.getPessoas())) {
            Menu.erro("ID não encontrado");
            Thread.sleep(2000);
            return;
        }
        CadastroManager.deletePessoa(id);
        Menu.sucesso("Cadastro apagado com sucesso!");
        Thread.sleep(2000);
    }
    /**
     * Exclui um endereço do cadastro com base no ID fornecido pelo usuário.
     *
     * @throws InterruptedException Exceção lançada em caso de erro durante a interação.
     */
    public static void deleteEndereco() throws InterruptedException {
        System.out.println("Digite o ID do cadastro: ");
        int id = validarInt(sc);
        if (!validarID(id, CadastroManager.getEnderecos())) {
            Menu.erro("ID não encontrado");
            Thread.sleep(2000);
            return;
        }
        CadastroManager.deleteEndereco(id);
        Menu.sucesso("Cadastro apagado com sucesso!");
        Thread.sleep(2000);
    }

    /**
     * Limpa o conteúdo da tela/terminal.
     *
     * @throws IOException          Exceção lançada em caso de erro durante a execução do método.
     * @throws InterruptedException Exceção lançada em caso de erro durante a execução do método.
     */
    public static void limpar() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
    }
    /**
     * Valida e obtém um número inteiro da entrada do usuário.
     *
     * @param sc O Scanner utilizado para obter a entrada do usuário.
     * @return O número inteiro validado.
     */
    public static int validarInt(Scanner sc) {
        int numero = 0;
        boolean numInteiro = false;

        while (!numInteiro) {
            try {
                if (sc.hasNextInt()) {
                    numero = sc.nextInt();
                    sc.nextLine();
                    numInteiro = true;
                } else {
                    Menu.erro("Entrada inválida. Digite um numero válido: ");
                    sc.nextLine();
                }
            } catch (InputMismatchException e) {
                Menu.erro("InputMismatch: Entrada inválida. Digite um numero válido: ");
                sc.nextLine();
            }
        }
        return numero;
    }
    /**
     * Valida e obtém um número double/float da entrada do usuário.
     *
     * @param sc O Scanner utilizado para obter a entrada do usuário.
     * @return O número decimal validado.
     */
    public static double validarDouble(Scanner sc) {
        double numero = 0d;
        boolean numDouble = false;

        while (!numDouble) {
            try {
                if (sc.hasNextDouble()) {
                    numero = sc.nextDouble();
                    numDouble = true;
                } else {
                    Menu.erro("Entrada inválida. Digite um numero válido: ");
                    sc.nextLine();
                }
            } catch (InputMismatchException e) {
                Menu.erro("InputMismatch: Entrada inválida. Digite um numero válido: ");
            }
        }
        return numero;
    }
    /**
     * Valida e obtém o sexo da entrada do usuário.
     *
     * @param sc O Scanner utilizado para obter a entrada do usuário.
     * @return O sexo validado ('M' ou 'F').
     */
    public static char validarSexo(Scanner sc) {
        boolean sexoValido = false;
        char sexo = ' ';

        while (!sexoValido) {
            sexo = sc.next().toUpperCase().charAt(0);
            if (sexo == 'M' || sexo == 'F') {
                sexoValido = true;
            } else {
                Menu.erro("Erro: Sexo da pessoa inválido. Digite novamente.");
            }
        }
        return sexo;
    }
    /**
     * Valida e obtém uma string não vazia da entrada do usuário.
     *
     * @param sc O Scanner utilizado para obter a entrada do usuário.
     * @return A string validada.
     */
    public static String validarString(Scanner sc) {
        boolean stringValida = false;
        String texto = "";
        while (!stringValida) {
            texto = sc.next();
            if (texto.isEmpty()) {
                Menu.erro("ERRO: Nenhum dado foi inserido. Tente novamente.");
            } else {
                stringValida = true;
            }
        }
        return texto;
    }
    /**
     * Valida se o ID fornecido pelo usuário está presente no array especificado.
     *
     * @param id    O ID fornecido pelo usuário.
     * @param array O array no qual procurar o ID.
     * @return True se o ID estiver presente, False caso contrário.
     */
    public static boolean validarID(Integer id, Object[] array) {
        for (Object obj : array) {
            if (obj != null) {
                if ((obj instanceof Pessoa pessoa && pessoa.getId().equals(id)) ||
                        (obj instanceof Endereco endereco && endereco.getId().equals(id))) {
                    return true;
                }
            }
        }
        return false;
    }
}
