package com.example;

public class AppCarregar {
    public static void main(String[] args) {
        
        Lanchonete lanchonete = new Lanchonete();

        lanchonete.carregarDados();

        System.out.println(lanchonete.getItens());

        System.out.println(lanchonete.getSanduiches());
        

    }
}
