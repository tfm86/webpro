package org.webpro.database;

import org.webpro.modelo.USistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class USistemaDao {

    private Connection connection;

    public USistemaDao() {

        connection = new ConnectionDB().getConnection();

    }

    public List<USistema> listaUsuarioSistema() throws Exception {

        List<USistema> lista = new ArrayList<>();
        String sql = "select * from usuario";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet executeQuery = statement.executeQuery();

            while (executeQuery.next()) {

                USistema u = new USistema();
                u.setId(executeQuery.getLong("id"));
                u.setNome(executeQuery.getString("nome"));
                u.setLogin(executeQuery.getString("login"));
                u.setSenha(executeQuery.getString("senha"));
                u.setDataCriacao(executeQuery.getString("dataCriacao"));

                lista.add(u);

            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return lista;

    }

    public USistema buscaUsuarioUser(String user) throws Exception {

        String sql = "select * from usuario where login='" + user + "'";

        USistema u = new USistema();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet executeQuery = statement.executeQuery();

            while (executeQuery.next()) {

                u.setId(executeQuery.getLong("id"));
                u.setNome(executeQuery.getString("nome"));
                u.setLogin(executeQuery.getString("login"));
                u.setSenha(executeQuery.getString("senha"));
                u.setDataCriacao(executeQuery.getString("dataCriacao"));

            }

            connection.close();
            return u;

        } catch (SQLException e) {

            connection.close();
            return null;
        }

    }

    public boolean usuarioExiste(String login, String senha){

        String sql = "select * from usuario where login = '"+login+"' and senha = '"+senha+"'";
        boolean existe;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet executeQuery = statement.executeQuery();
            existe = executeQuery.next();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return existe;

    }

}
