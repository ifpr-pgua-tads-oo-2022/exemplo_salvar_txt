package com.example;

import java.util.ArrayList;
import java.util.List;

public class Sanduiche {
    private int id;
    private List<Item> itens;

    public Sanduiche(int id){
        this.id = id;
        itens = new ArrayList<>();
    }

    public void adicionar(Item item){
        this.itens.add(item);
    }



    public int getId() {
        return id;
    }

    public List<Item> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "Sanduiche [id=" + id + ", itens=" + itens + "]";
    }
    

    
}
