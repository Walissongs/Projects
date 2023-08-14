
/*
 * Pacote onde a classe Menu está localizada.
 */
package cardapio;

// Importações de classes necessárias.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe Menu representa o cardápio diário do restaurante.
 * Ela gerencia os itens do menu para cada dia da semana.
 */
public class Menu {
    // Mapa que associa cada dia da semana a uma lista de itens do menu.
    private Map<String, List<MenuItem>> menuItems;

    // Construtor da classe Menu.
    public Menu() {
        // Inicializa o mapa e preenche com listas vazias para cada dia da semana.
        menuItems = new HashMap<>();
        for (int i = 2; i <= 6; i++) {
            menuItems.put(getDayName(i), new ArrayList<>());
        }
    }

    // Adiciona um item ao menu de um determinado dia.
    public void addMenuItem(int day, MenuItem item) {
        menuItems.get(getDayName(day)).add(item);
    }

    // Obtém a lista de itens do menu para um determinado dia.
    public List<MenuItem> getMenuItems(int day) {
        return menuItems.get(getDayName(day));
    }

    // Retorna o nome do dia da semana com base no número do dia.
    private String getDayName(int day) {
        switch (day) {
            case 2: return "Segunda-feira";
            case 3: return "Terça-feira";
            case 4: return "Quarta-feira";
            case 5: return "Quinta-feira";
            case 6: return "Sexta-feira";
            default: return "";
        }
    }
}
