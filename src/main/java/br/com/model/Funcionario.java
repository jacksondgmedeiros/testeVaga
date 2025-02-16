package br.com.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    @Override
    public String toString() {

        DecimalFormatSymbols simbolo = new DecimalFormatSymbols(new Locale("pt", "BR"));
        simbolo.setGroupingSeparator('.');
        simbolo.setDecimalSeparator(',');
        DecimalFormat salarioFormatado = new DecimalFormat("#,##0.00", simbolo);

        return super.toString() + ", Salário = " + salarioFormatado.format(salario) +
                ", Função = " + funcao;
    }

    public void aumentoSalario10PorCento(){
        salario = salario.add(salario.multiply(new BigDecimal("0.1")));
    }

    public BigDecimal calcularSalarios(BigDecimal salarioMinimo){
        return salario.divide(salarioMinimo,2, RoundingMode.HALF_UP);
    }
}
