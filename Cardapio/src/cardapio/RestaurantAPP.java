

package cardapio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import cardapio.ItemType.*;

// Classe RestaurantAPP que herda de JFrame para construir a interface gráfica.
public class RestaurantAPP extends JFrame {
    // Atributos da classe para os componentes da interface.
    private Menu menu;
    private JComboBox<String> dayComboBox;
    private JTextArea menuTextArea;
    private JRadioButton comidaRadioButton;
    private JRadioButton bebidaRadioButton;
    private ButtonGroup itemButtonGroup;

    // Construtor da classe RestaurantAPP.
    public RestaurantAPP() {
        // Inicialização do objeto Menu para gerenciar os itens do cardápio.
        menu = new Menu();
        // Inicialização da interface gráfica.
        initializeUI();
    }

    // Método para inicializar a interface gráfica.
    private void initializeUI() {
        // Configurações iniciais da janela.
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

        // Criação dos botões e adição de ouvintes para responder a ações do usuário.

        JButton addButton = new JButton("Adicionar Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ...
                // (O código dentro do ouvinte do botão "Adicionar Item")
                // ...
            }
        });

        JButton showMenuButton = new JButton("Mostrar Cardápio Completo");
        showMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ...
                // (O código dentro do ouvinte do botão "Mostrar Cardápio Completo")
                // ...
            }
        });

        JButton filterComidaButton = new JButton("Filtrar Comidas");
        filterComidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ...
                // (O código dentro do ouvinte do botão "Filtrar Comidas")
                // ...
            }
        });

        JButton filterBebidaButton = new JButton("Filtrar Bebidas");
        filterBebidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ...
                // (O código dentro do ouvinte do botão "Filtrar Bebidas")
                // ...
            }
        });

        // Criação de painéis para organizar os componentes na interface.

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(dayComboBox, BorderLayout.NORTH);
        leftPanel.add(menuTextArea, BorderLayout.CENTER);

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

        // Configurações finais da janela
        pack(); // Ajusta o tamanho da janela para caber todos os componentes.
        setLocationRelativeTo(null); // Centraliza a janela na tela.
        setVisible(true); // Torna a janela visível para o usuário.
    }

    // Métodos para atualizar o texto exibido na área de texto do menu.

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
        // Inicia a aplicação na thread de eventos Swing.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Cria uma nova instância da classe RestaurantAPP para iniciar a interface gráfica.
                new RestaurantAPP();
            }
        });
    }
}
