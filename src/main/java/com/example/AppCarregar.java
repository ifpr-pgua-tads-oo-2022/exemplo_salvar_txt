package com.example;

import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.Gson;

public class AppCarregar {
    public static void main(String[] args) throws Exception {
        
        Lanchonete lanchonete = new Lanchonete();

        lanchonete.carregarDados();

        System.out.println(lanchonete.getItens());

        System.out.println(lanchonete.getSanduiches());

        

    }
}
