package com.devKaua.cadastroAPIrest;

import jakarta.persistence.*;

// Ele transforma uma class em uma entidade para o banco de dados
@Entity
@Table(name = "tb_pet")
public class PetModel {
    // Gera ID de forma sequencial
    // 1 2 3 e etc...
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private int peso;

    public PetModel() {
    }

    public PetModel(String nome, int idade, int peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
