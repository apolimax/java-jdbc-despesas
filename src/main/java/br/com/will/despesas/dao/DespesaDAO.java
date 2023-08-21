package br.com.will.despesas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.will.despesas.infra.ConnectionFactory;
import br.com.will.despesas.model.Categoria;
import br.com.will.despesas.model.Despesa;

public class DespesaDAO implements IDespesaDAO {

    @Override
    public Despesa save(Despesa despesa) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO despesas (descricao, data, valor, categoria) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, despesa.getDescricao());
            preparedStatement.setDate(2, java.sql.Date.valueOf(despesa.getData()));
            preparedStatement.setDouble(3, despesa.getValor());
            preparedStatement.setString(4, despesa.getCategoria().toString());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            Long generatedId = resultSet.getLong("id");
            despesa.setId(generatedId);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return despesa;
    }

    @Override
    public Despesa update(Despesa despesa) {
        String sql = "UPDATE despesas SET descricao = ?, data = ?, valor = ?, categoria = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, despesa.getDescricao());
            preparedStatement.setDate(2, java.sql.Date.valueOf(despesa.getData()));
            preparedStatement.setDouble(3, despesa.getValor());
            preparedStatement.setString(4, despesa.getCategoria().toString());
            preparedStatement.setLong(5, despesa.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return despesa;
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM despesas WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Despesa> findAll() {
        List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT * FROM despesas";
        try (Connection connection = ConnectionFactory.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String descricao = resultSet.getString("descricao");
                Double valor = resultSet.getDouble("valor");
                Categoria categoria = Categoria.valueOf(resultSet.getString("categoria"));
                LocalDate data = resultSet.getDate("data").toLocalDate();

                Despesa despesa = new Despesa(id, descricao, data, valor, categoria);

                despesas.add(despesa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return despesas;
    }

    @Override
    public Optional<Despesa> findById(Long id) {
        String sql = "SELECT * FROM despesas WHERE id = ?";
        Despesa despesa = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long result_id = resultSet.getLong("id");
                String descricao = resultSet.getString("descricao");
                Double valor = resultSet.getDouble("valor");
                Categoria categoria = Categoria.valueOf(resultSet.getString("categoria"));
                LocalDate data = resultSet.getDate("data").toLocalDate();

                despesa = new Despesa(result_id, descricao, data, valor, categoria);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(despesa);
    }

    @Override
    public List<Despesa> findByCategoria(Categoria categoria) {
        List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT * FROM despesas WHERE categoria = ?";
        try (Connection connection = ConnectionFactory.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoria.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String descricao = resultSet.getString("descricao");
                Double valor = resultSet.getDouble("valor");
                Categoria resultCategoria = Categoria.valueOf(resultSet.getString("categoria"));
                LocalDate data = resultSet.getDate("data").toLocalDate();

                Despesa despesa = new Despesa(id, descricao, data, valor, resultCategoria);

                despesas.add(despesa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return despesas;
    }

}
