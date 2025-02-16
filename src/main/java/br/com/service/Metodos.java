package br.com.service;

import br.com.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Metodos {
    public List<Pessoa> adicionar(List<Pessoa> pessoa){
        List<Pessoa> lista = new ArrayList<>();
        lista.add((Pessoa) pessoa);
        return lista;
    }
}
