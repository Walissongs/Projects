/*
 * Pacote onde a classe Main está localizada.
 */
package cardapio;
import cardapio.RestaurantAPP;

// Importação da classe SwingUtilities para trabalhar com a interface gráfica.
import javax.swing.SwingUtilities;

// Classe Main contendo o método main que inicia a aplicação.
public class Main {
    public static void main(String[] args) {
        // O método SwingUtilities.invokeLater é usado para garantir que a criação da interface gráfica ocorra na thread de eventos Swing.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Cria uma nova instância da classe RestaurantAPP, iniciando a aplicação.
                new RestaurantAPP();
            }
        });
    }
}
