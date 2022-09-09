package com.example;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class AppSalvar 
{
    private static ArrayList<Item> gerarItens(){
        ArrayList<Item> itens = new ArrayList<>();



        return itens;
    }



    public static void main( String[] args )
    {
        
        
        Lanchonete lanchonete = new Lanchonete();
        lanchonete.gerarItens();
        lanchonete.gerarSanduiches();

        lanchonete.salvarDados();
        

        

    }
}
