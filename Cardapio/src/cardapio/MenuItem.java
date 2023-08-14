// Arquivo: MenuItem.java
// Esta classe representa um item individual no menu.

package cardapio;

public class MenuItem {
    // Atributos privados para o nome e o tipo do item.
    private String name;
    private ItemType type;

    // Construtor da classe MenuItem.
    public MenuItem(String name, ItemType type) {
        this.name = name;
        this.type = type;
    }

    // Método para obter o nome do item.
    public String getName() {
        return name;
    }

    // Método para obter o tipo do item.
    public ItemType getType() {
        return type;
    }

    // Sobrescrita do método toString para retornar o nome do item.
    @Override
    public String toString() {
        return name;
    }
}
