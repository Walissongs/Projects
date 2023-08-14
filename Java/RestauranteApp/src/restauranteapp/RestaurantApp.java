package restauranteapp;

/**
 *
 * @author walis
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

class MenuItem {
    String type;
    String name;

    public MenuItem(String type, String name) {
        this.type = type;
        this.name = name;
    }
}

public class RestaurantApp extends JFrame {

    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private JTextArea cardapioTextArea;
    private JComboBox<String> diaSemanaComboBox;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RestaurantApp app = new RestaurantApp();
            app.setVisible(true);
        });
    }

    public RestaurantApp() {
        setTitle("Restaurante Universitario UFJ");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton loginButton = new JButton("Login");
        JButton verCardapioButton = new JButton("Ver Cardapio");

        loginButton.addActionListener(e -> showLoginScreen());
        verCardapioButton.addActionListener(e -> showCardapio());

        add(loginButton);
        add(verCardapioButton);
    }

    private void showLoginScreen() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 150);
        loginFrame.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Usuario:");
        JLabel passLabel = new JLabel("Senha:");
        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (username.equals("adm") && password.equals("123")) {
                    loginFrame.dispose();
                    showMenuCadastro();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Credenciais incorretas.");
                }
            }
        });

        loginFrame.add(userLabel);
        loginFrame.add(userField);
        loginFrame.add(passLabel);
        loginFrame.add(passField);
        loginFrame.add(loginButton);

        loginFrame.setVisible(true);
    }

    private void showMenuCadastro() {
        JFrame cadastroFrame = new JFrame("Cadastro de Cardapio");
        cadastroFrame.setSize(300, 200);
        cadastroFrame.setLayout(new GridLayout(5, 1));

        JLabel diaSemanaLabel = new JLabel("Dia da Semana:");
        diaSemanaComboBox = new JComboBox<>(new String[]{"Segunda", "Terça", "Quarta", "Quinta", "Sexta"});
        JButton addCardapioButton = new JButton("Adicionar Cardapio");
        JButton excluirCardapioButton = new JButton("Excluir Cardapio");
        JButton sairButton = new JButton("Sair");

        addCardapioButton.addActionListener(e -> showAddCardapioScreen(diaSemanaComboBox.getSelectedItem().toString()));
        excluirCardapioButton.addActionListener(e -> showExcluirCardapioScreen(cadastroFrame));
        sairButton.addActionListener(e -> cadastroFrame.dispose());

        cadastroFrame.add(diaSemanaLabel);
        cadastroFrame.add(diaSemanaComboBox);
        cadastroFrame.add(addCardapioButton);
        cadastroFrame.add(excluirCardapioButton);
        cadastroFrame.add(sairButton);

        cadastroFrame.setVisible(true);
    }

    private void showAddCardapioScreen(String diaSemana) {
        JFrame addCardapioFrame = new JFrame("Adicionar Cardapio");
        addCardapioFrame.setSize(300, 150);
        addCardapioFrame.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Nome do Item:");
        JTextField nameField = new JTextField();
        JButton addButton = new JButton("Adicionar");
        JButton cancelButton = new JButton("Cancelar");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();

                if (!name.isEmpty()) {
                    menuItems.add(new MenuItem(diaSemana, name));
                    JOptionPane.showMessageDialog(addCardapioFrame, "Item adicionado com sucesso.");
                    updateCardapioTextArea();
                    addCardapioFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(addCardapioFrame, "Preencha o nome do item.");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCardapioFrame.dispose();
            }
        });

        addCardapioFrame.add(nameLabel);
        addCardapioFrame.add(nameField);
        addCardapioFrame.add(addButton);
        addCardapioFrame.add(cancelButton);

        addCardapioFrame.setVisible(true);
    }

    private void showExcluirCardapioScreen(JFrame parentFrame) {
        JFrame excluirCardapioFrame = new JFrame("Excluir Cardapio");
        excluirCardapioFrame.setSize(400, 150);
        excluirCardapioFrame.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Nome do Item:");
        JTextField nameField = new JTextField();
        JButton excluirButton = new JButton("Excluir");
        JButton cancelButton = new JButton("Cancelar");

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();

                if (!name.isEmpty()) {
                    menuItems.removeIf(item -> item.name.equals(name));
                    JOptionPane.showMessageDialog(excluirCardapioFrame, "Item excluído com sucesso.");
                    updateCardapioTextArea();
                    excluirCardapioFrame.dispose();
                    parentFrame.dispose();
                    showMenuCadastro();
                } else {
                    JOptionPane.showMessageDialog(excluirCardapioFrame, "Preencha o nome do item a ser excluído.");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirCardapioFrame.dispose();
            }
        });

        excluirCardapioFrame.add(nameLabel);
        excluirCardapioFrame.add(nameField);
        excluirCardapioFrame.add(excluirButton);
        excluirCardapioFrame.add(cancelButton);
        excluirCardapioFrame.setVisible(true);
    }

    private void showCardapio() {
        JFrame cardapioFrame = new JFrame("Cardapio");
        cardapioFrame.setSize(400, 400);

        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel diaSemanaLabel = new JLabel("Dia da Semana:");
        diaSemanaComboBox = new JComboBox<>(new String[]{"Segunda", "Terça", "Quarta", "Quinta", "Sexta"});
        JButton mostrarButton = new JButton("Mostrar Cardapio");

        optionsPanel.add(diaSemanaLabel);
        optionsPanel.add(diaSemanaComboBox);
        optionsPanel.add(mostrarButton);

        cardapioTextArea = new JTextArea(15, 30);
        JScrollPane scrollPane = new JScrollPane(cardapioTextArea);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(e -> cardapioFrame.dispose());
        buttonPanel.add(sairButton);

        mostrarButton.addActionListener(e -> showCardapioPorDia(diaSemanaComboBox.getSelectedItem().toString()));

        cardapioFrame.setLayout(new BorderLayout());
        cardapioFrame.add(optionsPanel, BorderLayout.NORTH);
        cardapioFrame.add(scrollPane, BorderLayout.CENTER);
        cardapioFrame.add(buttonPanel, BorderLayout.SOUTH);

        cardapioFrame.setVisible(true);
    }
    private void showCardapioPorDia(String diaSemana) {
        StringBuilder cardapioDia = new StringBuilder();
        cardapioDia.append("Cardápio para ").append(diaSemana).append(":\n");

        for (MenuItem menuItem : menuItems) {
            if (menuItem.type.equals(diaSemana)) {
                cardapioDia.append(menuItem.name).append("\n");
            }
        }

        cardapioTextArea.setText(cardapioDia.toString());
    }

    private void updateCardapioTextArea() {
        cardapioTextArea.setText("");
        for (MenuItem menuItem : menuItems) {
            cardapioTextArea.append(menuItem.type + ": " + menuItem.name + "\n");
        }
    }

    private void saveCardapioToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showSaveDialog(this);

        if (choice == JFileChooser.APPROVE_OPTION) {
            try (PrintWriter writer = new PrintWriter(fileChooser.getSelectedFile())) {
                for (MenuItem menuItem : menuItems) {
                    writer.println(menuItem.type + "," + menuItem.name);
                }
                JOptionPane.showMessageDialog(this, "Cardapio salvo com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadCardapioFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);

        if (choice == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                String line;
                menuItems.clear();
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        menuItems.add(new MenuItem(parts[0], parts[1]));
                    }
                }
                JOptionPane.showMessageDialog(this, "Cardapio carregado com sucesso.");
                updateCardapioTextArea();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteMenuItem() {
        String selectedItem = JOptionPane.showInputDialog("Digite o nome do item a ser excluído:");
        if (selectedItem != null) {
            menuItems.removeIf(item -> item.name.equals(selectedItem));
            updateCardapioTextArea();
        }
    }
    
}


