
package cardapio;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private Map<String, List<MenuItem>> menuItems;

    public Menu() {
        menuItems = new HashMap<>();
        for (int i = 2; i <= 6; i++) {
            menuItems.put(getDayName(i), new ArrayList<>());
        }
    }

    public void addMenuItem(int day, MenuItem item) {
        menuItems.get(getDayName(day)).add(item);
    }

    public List<MenuItem> getMenuItems(int day) {
        return menuItems.get(getDayName(day));
    }
    
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
