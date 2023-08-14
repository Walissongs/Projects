package cardapio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import cardapio.ItemType.*;

public class RestaurantAPP extends JFrame {
    private Menu menu;
    private JComboBox<String> dayComboBox;
    private JTextArea menuTextArea;
    private JRadioButton comidaRadioButton;
    private JRadioButton bebidaRadioButton;
    private ButtonGroup itemButtonGroup;

    public RestaurantAPP() {
        menu = new Menu();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Restaurante Universitário");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        dayComboBox = new JComboBox<>(new String[]{"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira"});
        menuTextArea = new JTextArea(10, 30);
        menuTextArea.setEditable(false);

        comidaRadioButton = new JRadioButton("Comida");
        bebidaRadioButton = new JRadioButton("Bebida");
        itemButtonGroup = new ButtonGroup();
        itemButtonGroup.add(comidaRadioButton);
        itemButtonGroup.add(bebidaRadioButton);

        JButton addButton = new JButton("Adicionar Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedDay = dayComboBox.getSelectedIndex() + 2;
                String itemName = JOptionPane.showInputDialog("Nome do item:");

                ItemType itemType = null;
                if (comidaRadioButton.isSelected()) {
                    itemType = ItemType.COMIDA;
                } else if (bebidaRadioButton.isSelected()) {
                    itemType = ItemType.BEBIDA;
                }

                MenuItem newItem = new MenuItem(itemName, itemType);
                menu.addMenuItem(selectedDay, newItem);
                updateMenuText(selectedDay);
            }
        });

        JButton showMenuButton = new JButton("Mostrar Cardápio Completo");
        showMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedDay = dayComboBox.getSelectedIndex() + 2;
                List<MenuItem> menuItems = menu.getMenuItems(selectedDay);
                updateMenuText(menuItems);
            }
        });

        JButton filterComidaButton = new JButton("Filtrar Comidas");
        filterComidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedDay = dayComboBox.getSelectedIndex() + 2;
                List<MenuItem> comidas = menu.getMenuItems(selectedDay).stream()
                                        .filter(item -> item.getType() == ItemType.COMIDA)
                                        .collect(Collectors.toList());
                updateMenuText(comidas);
            }
        });

        JButton filterBebidaButton = new JButton("Filtrar Bebidas");
        filterBebidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedDay = dayComboBox.getSelectedIndex() + 2;
                List<MenuItem> bebidas = menu.getMenuItems(selectedDay).stream()
                                        .filter(item -> item.getType() == ItemType.BEBIDA)
                                        .collect(Collectors.toList());
                updateMenuText(bebidas);
            }
        });

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());


        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rightPanel.add(comidaRadioButton);
        rightPanel.add(bebidaRadioButton);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addButton);
        buttonPanel.add(showMenuButton);
        buttonPanel.add(filterComidaButton);
        buttonPanel.add(filterBebidaButton);

        // Adicione os painéis à janela principal
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(dayComboBox, BorderLayout.NORTH);
        add(menuTextArea, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateMenuText(int day) {
        List<MenuItem> items = menu.getMenuItems(day);
        updateMenuText(items);
    }

    private void updateMenuText(List<MenuItem> items) {
        StringBuilder menuText = new StringBuilder();
        for (MenuItem item : items) {
            menuText.append(item.toString()).append("\n");
        }
        menuTextArea.setText(menuText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RestaurantAPP();
            }
        });
    }
}
