package clientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import java.util.ListIterator;

public class Interface extends JFrame {
    private JPanel mainPanel;
    private JButton addButton;
    private JButton showButton;
    private JButton changeColorButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton nextButton;
    private JButton prevButton;
    private JPanel buttonsPanel;
    private JStatusBar statusBar;

    private ListIterator<Cadastro> clientIterator;
    private List<Cadastro> clientes;

    public Interface() {
        setTitle("Cadastro de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        buttonsPanel = new JPanel();
        addButton = new JButton("Adicionar Cliente");
        showButton = new JButton("Mostrar Clientes");
        changeColorButton = new JButton("Mudar Cor");
        nextButton = new JButton("Próximo");
        prevButton = new JButton("Anterior");
        statusBar = new JStatusBar();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
                if (nome != null && !nome.isEmpty()) {
                    Cadastro cliente = new Cadastro(nome);
                    Cliente.inserirCliente(cliente);
                    statusBar.setMessage("Cliente adicionado: " + cliente.getNome());
                }
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder clientesText = new StringBuilder();
                for (Cadastro cliente : Cliente.getClientes()) {
                    clientesText.append(cliente.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, clientesText.toString());
            }
        });

        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Escolha uma cor", Color.WHITE);
                if (newColor != null) {
                    buttonsPanel.setBackground(newColor);
                }
            }
        });



                nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clientIterator != null && clientIterator.hasNext()) {
                    Cadastro cliente = clientIterator.next();
                    statusBar.setMessage("Cliente atual: " + cliente.getNome());
                } else {
                    statusBar.setMessage("Não há mais clientes.");
                }
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clientIterator != null && clientIterator.hasPrevious()) {
                    Cadastro cliente = clientIterator.previous();
                    statusBar.setMessage("Cliente anterior: " + cliente.getNome());
                } else {
                    statusBar.setMessage("Não há mais clientes.");
                }
            }
        });

        buttonsPanel.add(addButton);
        buttonsPanel.add(showButton);
        buttonsPanel.add(changeColorButton);
        buttonsPanel.add(nextButton);
        buttonsPanel.add(prevButton);

        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        mainPanel.add(statusBar, BorderLayout.SOUTH);
        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interface();
            }
        });
    }
}
