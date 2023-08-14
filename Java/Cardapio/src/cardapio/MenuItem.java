
package cardapio;

public class MenuItem {
    
    private String name;
    private ItemType type;

    public MenuItem(String name, ItemType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}


