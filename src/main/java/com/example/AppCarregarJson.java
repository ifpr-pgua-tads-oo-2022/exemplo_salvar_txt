package com.example;

import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.Gson;

public class AppCarregarJson {
    public static void main(String[] args) throws Exception {
        
        Lanchonete lanchonete = new Lanchonete();

        lanchonete.carregarJson();

        System.out.println(lanchonete.getItens());

        System.out.println(lanchonete.getSanduiches());




        

    }
}
