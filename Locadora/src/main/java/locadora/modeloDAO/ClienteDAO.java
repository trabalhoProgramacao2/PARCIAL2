/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadora.config.Conexao;
import locadora.modelodados.Cliente;
/**
 *
 * @author USER
 */
public abstract class ClienteDAO {
    public static void adicionarCliente(Cliente cliente) throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado para adicionar cliente!");
        String sql = "insert into usuario (nome, cpf, telefonecliente) values (?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, 3);
        stmt.setString(1, cliente.getNomeCliente());
        stmt.setString(2, cliente.getCpfCliente()); 
        stmt.setString(3, cliente.getTelefoneCliente()); 
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public static List<Cliente> buscarClientes() throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado!");
        String sql = "select * from usuario";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Cliente> clientes = new ArrayList<Cliente>();
        while (rs.next()) {
        	Cliente cliente = new Cliente();
        	cliente.setIdCliente(rs.getInt("idusuario"));
                cliente.setNomeCliente(rs.getString("nome"));
                cliente.setCpfCliente(rs.getString("cpf"));
                cliente.setTelefoneCliente(rs.getString("telefonecliente"));
            clientes.add(cliente);
        }
        rs.close();
        stmt.close();
        con.close();
        return clientes;
    }
          
    
    public static void removerCliente(Cliente cliente) throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado!");
        String sql = "delete from usuario " +
            " where idusuario = " + cliente.getIdCliente();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        con.close();
    }
    
}
