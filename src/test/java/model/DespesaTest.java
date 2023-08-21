package model;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.will.despesas.model.Categoria;
import br.com.will.despesas.model.Despesa;

public class DespesaTest {
    @Test
    public void deveCriarUmaDespesaCorretamente() {
        Despesa despesa = new Despesa(null, "Feira do mês", LocalDate.of(2023, 8, 23), 1500, Categoria.ALIMENTACAO);

        Assertions.assertEquals("Feira do mês", despesa.getDescricao());
        Assertions.assertEquals(LocalDate.of(2023, 8, 23), despesa.getData());
        Assertions.assertEquals(1500, despesa.getValor());
        Assertions.assertEquals(Categoria.ALIMENTACAO, despesa.getCategoria());
    }
}
