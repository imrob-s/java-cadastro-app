package cadastro;

/**
 * Classe utilizada para utilitarios do CadastroApp.
 * @author Rob Silva
 */
public class Utils { 
    /**
     * Verifica se um array de strings está completamente preenchido.
     * 
     * @param pessoas Um array de strings a ser verificado.
     * @return true se todas as strings no array estão preenchidas; false, caso 
     * contrário.
     */
    public static boolean arrayPreenchida(Pessoa[] pessoas) {
        for (String pessoa : pessoas) {
            if (pessoa == null || pessoa.isEmpty()){
                return false;
            }
        }
        return true;
    }
}
