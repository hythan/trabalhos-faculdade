package model;


import model.DAO.PessoaDAO;

import java.util.List;

public class Pessoa {
    private Integer _id;

    private String nome, endereco, email, telefone, celular, dataNascimento;


    public Pessoa(String nome, String endereco, String telefone, String celular, String email, String dataNascimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa(int _id, String nome, String endereco, String telefone, String celular, String email, String dataNascimento) {
        this._id = _id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Integer getID() {
        return _id;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "<HTML>Nome: "+nome+"<BR>Telefone: "+telefone+"<BR>Celular: "+celular+"<BR><BR>";
    }


    private static PessoaDAO pessoaDAO = new PessoaDAO();

    public void salvar(){
        if( _id != null && pessoaDAO.pesquisa(_id) != null){
            pessoaDAO.atualiza(this);
        }else
            pessoaDAO.criar(this);
    }

    public void delete(){
        if( pessoaDAO.pesquisa(_id) != null){
            pessoaDAO.delete(this);
        }
    }

    public static List<Pessoa> pesquisa(String nome){
        return pessoaDAO.pesquisa(nome);
    }

    public static List<Pessoa> todos(){
        return pessoaDAO.todos();
    }

    public static Pessoa pesquisar(int pk){
        return pessoaDAO.pesquisa(pk);
    }


}
