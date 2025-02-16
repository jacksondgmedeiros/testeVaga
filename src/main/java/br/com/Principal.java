package br.com;

import br.com.model.Funcionario;
import br.com.model.Pessoa;
import br.com.service.Metodos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {

//        CADASTRTO DE FUNCIONÁRIOS
        Funcionario funcionario0 = new Funcionario("Maria", LocalDate.parse("18/10/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                BigDecimal.valueOf(2009.44),"Operador");

        Funcionario funcionario1 = new Funcionario("João", LocalDate.parse("12/05/1990", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                BigDecimal.valueOf(2284.38),"Operador");

        Funcionario funcionario2 = new Funcionario("Caio", LocalDate.parse("02/05/1961", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                BigDecimal.valueOf(9836.14),"Coordenador");

        Funcionario funcionario3 = new Funcionario("Miguel", LocalDate.parse("14/10/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                BigDecimal.valueOf(19119.88),"Diretor");

        Funcionario funcionario4 = new Funcionario("Alice", LocalDate.parse("05/01/1995", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                BigDecimal.valueOf(2234.68),"Recepcionista");

        Funcionario funcionario5 = new Funcionario("Heitor", LocalDate.parse("19/11/1999", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                BigDecimal.valueOf(1582.72),"Operador");

        Funcionario funcionario6 = new Funcionario("Arthur", LocalDate.parse("31/03/1993", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                BigDecimal.valueOf(4071.84),"Contador");

        Funcionario funcionario7 = new Funcionario("Laura", LocalDate.parse("08/07/1994", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                BigDecimal.valueOf(3017.45),"Gerente");

        Funcionario funcionario8 = new Funcionario("Heloísa", LocalDate.parse("24/05/2003", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                BigDecimal.valueOf(1606.85),"Eletricista");

        Funcionario funcionario9 = new Funcionario("Helena", LocalDate.parse("02/09/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                BigDecimal.valueOf(2799.93),"Gerente");


//        Adicionar os funcionários na lista na mesma ordem da tabela
        List<Funcionario> listaDeFuncionarios = new ArrayList<>();

        listaDeFuncionarios.add(funcionario0);
        listaDeFuncionarios.add(funcionario1);
        listaDeFuncionarios.add(funcionario2);
        listaDeFuncionarios.add(funcionario3);
        listaDeFuncionarios.add(funcionario4);
        listaDeFuncionarios.add(funcionario5);
        listaDeFuncionarios.add(funcionario6);
        listaDeFuncionarios.add(funcionario7);
        listaDeFuncionarios.add(funcionario8);
        listaDeFuncionarios.add(funcionario9);

//        Remover João
        listaDeFuncionarios.remove(funcionario1);

//        mostrar todos os funcionários com as informações e com a data dd/mm/aaaa

        System.out.println("""
                
                =================================
                     LISTA DE FUNCIONÁRIOS
                =================================
                
                """);
        for (Funcionario funcionario : listaDeFuncionarios) {
            System.out.println(funcionario);
        }

//        Aumento de 10% para cada funcionário
        System.out.println("""
                
                =================================
                TODOS FUNCIONÁRIOS RECEBEM 10% A+
                =================================
                
                """);

        funcionario0.aumentoSalario10PorCento();
        funcionario1.aumentoSalario10PorCento();
        funcionario2.aumentoSalario10PorCento();
        funcionario3.aumentoSalario10PorCento();
        funcionario4.aumentoSalario10PorCento();
        funcionario5.aumentoSalario10PorCento();
        funcionario6.aumentoSalario10PorCento();
        funcionario7.aumentoSalario10PorCento();
        funcionario8.aumentoSalario10PorCento();
        funcionario9.aumentoSalario10PorCento();

        for (Funcionario funcionario : listaDeFuncionarios) {
            System.out.println(funcionario);
        }


//      AGRUPAR OS FUNCIONÁRIOS POR FUNÇÃO
        
        Map<String, List<Funcionario>> funcionariosPorFuncao = listaDeFuncionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("""
                
                =================================
                IMPRIMIR FUNCIONÁRIOS AGRUPADOS
                =================================
                
                """);
        funcionariosPorFuncao.forEach((funcao, funcionarios) -> {
            System.out.println("Função: " + funcao);
            funcionarios.forEach(System.out::println);
            System.out.println(" ");
        });

        System.out.println("""
                
                =================================
                IMPRIMIR ANIVERSARIANTES DO MÊS 10 E 12,
                =================================
                
                """);

        listaDeFuncionarios.stream()
                .filter(f -> {
                    var mesNascimento = f.getDataNascimento().getMonthValue();
                    return mesNascimento == 10 || mesNascimento == 12;
                }).forEach(System.out::println);

        System.out.println("""
                
                =================================
                IMPRIMIR MAIOR IDADE
                =================================
                """);

        listaDeFuncionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento)).ifPresent(f -> {
                    int idade = Period.between(f.getDataNascimento(), LocalDate.now()).getYears();
                    System.out.println("Nome: " + f.getNome() + ", Idade: " + idade);
                });


        System.out.println("""
                
                =================================
                IMPRIMIR POR ORDEM ALFABETICA,
                =================================
                
                """);

        listaDeFuncionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome)).forEach(System.out::println);


        System.out.println("""
                
                =================================
                IMPRIMIR TOTAL DE SALÁRIOS
                =================================
                
                """);

        listaDeFuncionarios.stream()
                .map(Funcionario::getSalario).reduce(BigDecimal::add).ifPresent(System.out::println);


        System.out.println("""
                
                ====================================
                IMPRIMIR SALÁRIO DE CADA FUNCIONÁRIO
                ====================================
                
                """);

        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        for (Funcionario funcionario : listaDeFuncionarios){
            BigDecimal salarios = funcionario.calcularSalarios(salarioMinimo);
            System.out.println(funcionario.getNome() + " ganha " + salarios + " salarios mínimos.");
        }




    }
}
