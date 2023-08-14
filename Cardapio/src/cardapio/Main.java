// Arquivo: Main.java
// Este é o ponto de entrada da aplicação.

// Importa a classe SwingUtilities, que fornece utilitários para trabalhar com a interface gráfica Swing.
import javax.swing.SwingUtilities;

// Importa a classe RestaurantAPP do pacote cardapio.
import cardapio.RestaurantAPP;

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
