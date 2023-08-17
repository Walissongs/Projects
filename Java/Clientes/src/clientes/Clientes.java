/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Clientes {

    static List<Cadastro> clientes = new ArrayList<Cadastro>();
    
    static void inserirClientes(String nome)
    {
        Cadastro c = new Cadastro(nome);
        clientes.add(c);
    }
    
    public static int tamanho(Supplier<Integer> s) 
    {
    return s.get();
    }   
    
    public static void main(String[] args) throws IOException 
    {
                   
        new Interface();      
    }
    
}