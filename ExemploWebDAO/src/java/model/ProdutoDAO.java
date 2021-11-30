/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class ProdutoDAO {

    private Connection getConnection() throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(
                "jdbc:derby://localhost:1527/LOJA_SIMPLES2",
                "LOJA_SIMPLES2", "LOJA_SIMPLES2");
    }

    private Statement getStatement() throws Exception {
        return getConnection().createStatement();
    }

    private void closeStatement(Statement st) throws Exception {
        st.getConnection().close();
    }

    public List<Produto> obterTodos() {
        ArrayList<Produto> lista = new ArrayList<>();
        try {
            ResultSet r1 = getStatement().executeQuery(
                    "SELECT * FROM PRODUTO");
            while (r1.next()) {
                lista.add(new Produto(r1.getInt("codigo"),
                        r1.getString("nome"), r1.getInt("quantidade")));
            }
            closeStatement(r1.getStatement());
        } catch (Exception e) {
            System.out.println("Erro listagem: " + e);
        }
        return lista;
    }

    public void excluir(int codigo) {
        try {
            Statement st = getStatement();
            st.executeUpdate(
                    "DELETE FROM PRODUTO WHERE CODIGO  = "
                    + codigo);
            closeStatement(st);
        } catch (Exception e) {
            System.out.println("Erro exclusão: " + e);
        }
    }

    public void incluir(Produto p) {
        try {
            PreparedStatement ps = getConnection().prepareStatement(
                    "INSERT INTO PRODUTO VALUES(?,?,?)");
            ps.setInt(1, p.codigo);
            ps.setString(2, p.nome);
            ps.setInt(3, p.quantidade);
            ps.executeUpdate();
            closeStatement(ps);
        } catch (Exception e) {
            System.out.println("Erro inclusão: " + e);
        }
    }
    
    public void alterar(Produto p){
        try{
            PreparedStatement ps = getConnection().prepareStatement(
                    "UPDATE produto SET nome = ?, quantidade = ? WHERE codigo = " + p.codigo);
            ps.setString(1, p.nome);
            ps.setInt(2, p.quantidade);
            ps.executeUpdate();
            closeStatement(ps);
        }catch (Exception e){
            System.out.println("Codigo: " + p.codigo + "\nNome: " + p.nome + "\nQuantidade: " + p.quantidade + "\nErro alterar: "+ e);
        }
    }

}
