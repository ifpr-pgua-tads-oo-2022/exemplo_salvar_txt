package com.example;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class AppSalvarJson 
{
    public static void main( String[] args ) throws Exception
    {
        
        
        Lanchonete lanchonete = new Lanchonete();
        lanchonete.gerarItens();
        lanchonete.gerarSanduiches();

        lanchonete.salvarJson();
        

    }
}
