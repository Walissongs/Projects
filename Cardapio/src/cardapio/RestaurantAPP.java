/ Arquivo: RestauranteAPP.java
// Esta classe representa a aplicação da interface gráfica do restaurante.

package cardapio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

// Classe RestaurantAPP que herda de JFrame para construir a interface gráfica.
public class RestaurantAPP extends JFrame {
    private Menu menu;
    private JComboBox<String> dayComboBox;
    private JTextArea menuTextArea;
    private JRadioButton comidaRadioButton;
    private JRadioButton bebidaRadioButton;
    private ButtonGroup itemButtonGroup;

    // Construtor da classe RestaurantAPP.
    public RestaurantAPP() {
        menu = new Menu();
        initializeUI();
    }

    // Método para inicializar a interface gráfica.
    private void initializeUI() {
        setTitle("Restaurante Universitário");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Criação dos componentes da interface.
        dayComboBox = new JComboBox<>(new String[]{"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira"});
        menuTextArea = new JTextArea(10, 30);
        menuTextArea.setEditable(false);

        comidaRadioButton = new JRadioButton("Comida");
        bebidaRadioButton = new JRadioButton("Bebida");
        itemButtonGroup = new ButtonGroup();
        itemButtonGroup.add(comidaRadioButton);
        itemButtonGroup.add(bebidaRadioButton);

        // Criação dos botões e adição de ouvintes.
        JButton addButton = new JButton("Adicionar Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ...
            }
        });

        JButton showMenuButton = new JButton("Mostrar Cardápio Completo");
        showMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ...
            }
        });

        // ... (mesmo padrão para os botões de filtragem)

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rightPanel.add(comidaRadioButton);
        rightPanel.add(bebidaRadioButton);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Adicione os botões ao painel de botões.

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

    // Métodos para atualizar o texto do menu.

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
// Ponto de entrada da aplicação.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RestaurantAPP();
            }
        });
    }
}
