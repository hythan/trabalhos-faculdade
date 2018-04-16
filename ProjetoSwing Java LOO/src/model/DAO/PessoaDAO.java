package model.DAO;

import model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends SQLite{

    public PessoaDAO()  {
        open();

        try {
            PreparedStatement statement =  connection.prepareStatement("CREATE TABLE IF NOT EXISTS Pessoas (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome VARCHAR(50) NOT NULL," +
                    "endereco VARCHAR(50)," +
                    "telefone VARCHAR(16) ," +
                    "celular VARCHAR(16) NOT NULL," +
                    "email VARCHAR(30) NOT NULL," +
                    "dataNascimento VARCHAR(10));");

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void criar(Pessoa pessoa) {

        open();

        try {
            PreparedStatement statement =  connection.prepareStatement("INSERT INTO Pessoas VALUES(?,?,?,?,?,?,?);");

            statement.setString(2, pessoa.getNome());
            statement.setString(3, pessoa.getEndereco());
            statement.setString(4, pessoa.getTelefone());
            statement.setString(5, pessoa.getCelular());
            statement.setString(6, pessoa.getEmail());
            statement.setString(7, pessoa.getDataNascimento());


            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }


    public List<Pessoa> todos() {
        ArrayList<Pessoa> resultado = new ArrayList<>();

        open();

        try {
            PreparedStatement statement =  connection.prepareStatement("SELECT * FROM Pessoas ORDER BY nome;");

            ResultSet resultSet =  statement.executeQuery();

            while (resultSet.next()){

                Pessoa p = new Pessoa(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7));

                resultado.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }


        return resultado;
    }

    public void atualiza(Pessoa pessoa){
        connection = open();

        try {
            PreparedStatement statement =  connection.prepareStatement("UPDATE Pessoas SET "+
                    "nome = ?, "+
                    "endereco = ?, "+
                    "telefone = ?, "+
                    "celular = ?, "+
                    "email = ?,"+
                    "dataNascimento = ? "+
                    "WHERE id = ?");

            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getEndereco());
            statement.setString(3,pessoa.getTelefone());
            statement.setString(4,pessoa.getCelular());
            statement.setString(5,pessoa.getEmail());
            statement.setString(6,pessoa.getDataNascimento());
            statement.setInt(7,pessoa.getID());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public void delete(Pessoa pessoa){
        connection = open();

        try {
            PreparedStatement statement =  connection.prepareStatement("DELETE FROM Pessoas WHERE id =?;");

            statement.setInt(1,pessoa.getID());



            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }


    public Pessoa pesquisa(int num) {
        Pessoa pessoas = null;


        open();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Pessoas " +
                    "WHERE id = ?;");
            statement.setInt(1,num);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                Pessoa p = new Pessoa(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                );

                pessoas = p;
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }

        return pessoas;
    }


    public List<Pessoa> pesquisa(String nome) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();


        open();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Pessoas " +
                    "WHERE nome LIKE  ? ;");
            statement.setString(1,'%'+nome+'%');

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Pessoa p = new Pessoa(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                );

                pessoas.add(p);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }

        return pessoas;
    }

}
