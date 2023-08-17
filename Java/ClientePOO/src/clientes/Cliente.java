package clientes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static List<Cadastro> clientes = new ArrayList<>();

    public static void inserirCliente(Cadastro cliente) {
        clientes.add(cliente);
    }

    public static List<Cadastro> getClientes() {
        return clientes;
    }
}
