package com.example;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class AppSalvar 
{
    public static void main( String[] args ) throws Exception
    {
        
        
        Lanchonete lanchonete = new Lanchonete();
        lanchonete.gerarItens();
        lanchonete.gerarSanduiches();

        //lanchonete.salvarDados();
        
        Gson gson = new Gson();

        String json = gson.toJson(lanchonete);

        FileWriter out = new FileWriter("lanchonte.json");

        out.write(json);
        out.close();
        

    }
}
