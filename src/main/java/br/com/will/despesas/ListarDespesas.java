package br.com.will.despesas;

import java.util.List;
import java.util.Optional;

import br.com.will.despesas.dao.DespesaDAO;
import br.com.will.despesas.model.Categoria;
import br.com.will.despesas.model.Despesa;

public class ListarDespesas {
    public static void main(String[] args) {
        DespesaDAO despesaDAO = new DespesaDAO();

        List<Despesa> despesas = despesaDAO.findAll();

        System.out.println("--- FindAll Despesas ---");
        for (Despesa despesa : despesas) {
            System.out.println("id = " + despesa.getId());
            System.out.println("descricao = " + despesa.getDescricao());
            System.out.println("valor = " + despesa.getValor());
            System.out.println("Data = " + despesa.getData());
            System.out.println("Categoria = " + despesa.getCategoria());
            System.out.println("##################");
        }

        Optional<Despesa> despesaOptional = despesaDAO.findById(1L);
        System.out.println("--- Despesa by Id ---");
        despesaOptional.ifPresent(despesa -> {
            System.out.println("id = " + despesa.getId());
            System.out.println("descricao = " + despesa.getDescricao());
            System.out.println("valor = " + despesa.getValor());
            System.out.println("Data = " + despesa.getData());
            System.out.println("Categoria = " + despesa.getCategoria());
            System.out.println("##################");
        });

        List<Despesa> despesasAlimentacao = despesaDAO.findByCategoria(Categoria.ALIMENTACAO);

        System.out.println("--- Despesas by Categoria ---");
        for (Despesa despesa : despesasAlimentacao) {
            System.out.println("id = " + despesa.getId());
            System.out.println("descricao = " + despesa.getDescricao());
            System.out.println("valor = " + despesa.getValor());
            System.out.println("Data = " + despesa.getData());
            System.out.println("Categoria = " + despesa.getCategoria());
            System.out.println("##################");
        }
    }
}