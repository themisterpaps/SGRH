/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Chigumane
 */
public class PagamentoVO {
    String id;
    int horasExtras,faltas,bonus,desconto;
    float salariobruto,salarioLiquido;
    //Salario Bruto é um atributo derivado 

    public PagamentoVO() {
    }

    public PagamentoVO(String id, int horasExtras, int faltas, int bonus, int desconto, float salariobruto, float salarioLiquido) {
        this.id = id;
        this.horasExtras = horasExtras;
        this.faltas = faltas;
        this.bonus = bonus;
        this.desconto = desconto;
        this.salariobruto = salariobruto;
        this.salarioLiquido = salarioLiquido;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public float getSalariobruto() {
        return salariobruto;
    }

    public void setSalariobruto(float salariobruto) {
        this.salariobruto = salariobruto;
    }

    public float getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(float salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }
    
}
