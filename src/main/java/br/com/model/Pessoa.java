package br.com.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome = " + nome +
                ", Data de Nascimento = " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }



}
