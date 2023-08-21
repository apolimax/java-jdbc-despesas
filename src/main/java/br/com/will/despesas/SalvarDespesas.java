package br.com.will.despesas;

import java.time.LocalDate;

import br.com.will.despesas.dao.DespesaDAO;
import br.com.will.despesas.model.Categoria;
import br.com.will.despesas.model.Despesa;

public class SalvarDespesas {
    public static void main(String[] args) {
        DespesaDAO despesaDAO = new DespesaDAO();

        /*
         * System.out.println("--- Save Despesa ---");
         * Despesa despesa = new Despesa(null, "Feira do mês", LocalDate.of(2023, 9,
         * 11), 1000, Categoria.ALIMENTACAO);
         * 
         * despesaDAO.save(despesa);
         * System.out.println("Despesa inserida id = " + despesa.getId());
         */

        System.out.println("--- Update Despesa ---");
        Despesa updateDespesa = despesaDAO.findById(4L).get();
        updateDespesa.setValor(100);

        despesaDAO.update(updateDespesa);
    }
}