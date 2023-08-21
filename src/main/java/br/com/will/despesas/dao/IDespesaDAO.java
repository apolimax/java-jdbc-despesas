package br.com.will.despesas.dao;

import java.util.List;
import java.util.Optional;

import br.com.will.despesas.model.Categoria;
import br.com.will.despesas.model.Despesa;

public interface IDespesaDAO {
    Despesa save(Despesa despesa);

    Despesa update(Despesa despesa);

    void deleteById(Long id);

    List<Despesa> findAll();

    Optional<Despesa> findById(Long id);

    List<Despesa> findByCategoria(Categoria categoria);
}
