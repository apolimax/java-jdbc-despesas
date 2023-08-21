package br.com.will.despesas.model;

import java.time.LocalDate;

public class Despesa {
    private Long id;
    private String descricao;
    private LocalDate data;
    private double valor;
    private Categoria categoria;

    public Despesa(Long id, String descricao, LocalDate data, double valor, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Despesa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Despesa other = (Despesa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Despesa [id=" + id + ", descricao=" + descricao + ", data=" + data + ", valor=" + valor + ", categoria="
                + categoria + "]";
    }
}
