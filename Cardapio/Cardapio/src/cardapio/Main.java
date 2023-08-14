package cardapio;

import javax.swing.SwingUtilities;
import cardapio.RestaurantAPP;

public class Main {
    public static void main(String[] args) {
           SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RestaurantAPP();
            }
        });
    }
}
