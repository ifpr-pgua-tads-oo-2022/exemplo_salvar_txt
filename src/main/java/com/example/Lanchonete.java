package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Lanchonete {
    private ArrayList<Item> itens;
    private ArrayList<Sanduiche> sanduiches;

    public Lanchonete() {
        itens = new ArrayList<>();
        sanduiches = new ArrayList<>();
    }

    public void gerarItens() {
        itens.add(new Item(1, "Pão", 1.0));
        itens.add(new Item(2, "Queijo", 2.0));
        itens.add(new Item(3, "Presunto", 3.0));
        itens.add(new Item(4, "Tomate", 4.0));
        itens.add(new Item(5, "Alface", 5.0));
    }

    public void gerarSanduiches() {
        Sanduiche sanduiche1 = new Sanduiche(1);
        sanduiche1.adicionar(itens.get(0));
        sanduiche1.adicionar(itens.get(1));
        sanduiche1.adicionar(itens.get(2));

        sanduiches.add(sanduiche1);

        Sanduiche sanduiche2 = new Sanduiche(2);
        sanduiche2.adicionar(itens.get(0));
        sanduiche2.adicionar(itens.get(3));
        sanduiche2.adicionar(itens.get(4));

        sanduiches.add(sanduiche2);
    }

    public Item buscaItem(int id){
        for(Item item:itens){
            if(item.getId()==id){
                return item;
            }
        }
        return null;
    }

    public void salvarDados() {
        try (FileWriter fout = new FileWriter("itens.txt");
                BufferedWriter bout = new BufferedWriter(fout)) {

            for (Item item : itens) {
                bout.write(item.getId() + ";" + item.getNome() + ";" + item.getValor());
                bout.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar itens");
        }
        try (FileWriter fout = new FileWriter("sanduiches.txt");
                BufferedWriter bout = new BufferedWriter(fout)) {

            for (Sanduiche sanduiche : sanduiches) {
                bout.write(sanduiche.getId() + ";");
                for(Item item:sanduiche.getItens()){
                    bout.write(item.getId()+",");
                }
                bout.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar sanduiches");
        }

    }

    public void salvarJson(){
        Gson gson = new Gson();

        String json = gson.toJson(this);

        try(FileWriter out = new FileWriter("lanchonete.json")){
            out.write(json);
            out.close();
        }catch(IOException e){
            System.out.println("Erro ao salvar json");
        }

    }

    public void carregarJson(){
        Gson gson = new Gson();

        
        try(FileReader in=new FileReader("lanchonete.json");
            BufferedReader bin = new BufferedReader(in)) {
            
            String json =bin.readLine();
            Lanchonete temp = gson.fromJson(json, Lanchonete.class);
            
            this.itens = temp.getItens();
            this.sanduiches = temp.getSanduiches();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        
    }


    public void carregarDados(){
        try (FileReader fin = new FileReader("itens.txt");
                BufferedReader bin = new BufferedReader(fin)) {
            
            String linha = bin.readLine();
            while(linha != null){
                String[] tokens = linha.split(";");
                int id = Integer.valueOf(tokens[0]);
                String nome = tokens[1];
                double valor = Double.valueOf(tokens[2]);
                Item item = new Item(id, nome, valor);

                itens.add(item);

                linha = bin.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar itens");
        }
        try (FileReader fin = new FileReader("sanduiches.txt");
                BufferedReader bin = new BufferedReader(fin)) {

            String linha = bin.readLine();
            while(linha!=null){
                String[] tokens = linha.split(";");
                int id = Integer.valueOf(tokens[0]);

                Sanduiche sanduiche = new Sanduiche(id);


                String[] idItens = tokens[1].split(",");
                for(String sid:idItens){
                    Item item = buscaItem(Integer.valueOf(sid));
                    sanduiche.adicionar(item);
                }

                sanduiches.add(sanduiche);

                linha = bin.readLine();
            }
            
        } catch (IOException e) {
            System.out.println("Erro ao carregar sanduiches");
        }

    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    

    public ArrayList<Sanduiche> getSanduiches() {
        return sanduiches;
    }

    @Override
    public String toString() {
        return "Lanchonete [itens=" + itens + ", sanduiches=" + sanduiches + "]";
    }

    
}
