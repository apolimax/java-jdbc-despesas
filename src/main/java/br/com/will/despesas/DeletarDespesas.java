package br.com.will.despesas;

import br.com.will.despesas.dao.DespesaDAO;

public class DeletarDespesas {
    public static void main(String[] args) {
        DespesaDAO despesaDAO = new DespesaDAO();

        despesaDAO.deleteById(1L);
        despesaDAO.deleteById(1L);
    }
}