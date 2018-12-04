package locadora.modeloDAO;

import locadora.config.Conexao;
import locadora.modelodados.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public abstract class ModeloDAO {
    
    public static void adicionarModelo(Modelo modelo) throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado para adicionar cliente!");
        String sql = "insert into modelo (nome, anomodelo) values (?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, 3);
        //stmt.setString(2, modelo.getNome());
        //stmt.setString(3, modelo.getAnoFabricacao());       
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public static List<Modelo> buscarModelos() throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado!");
        String sql = "SELECT * FROM MODELO M JOIN FABRICANTE F ON M.IDFABRICANTE = F.IDFABRICANTE";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Modelo> modelos = new ArrayList<Modelo>();
        while (rs.next()) {
        	Modelo modelo = new Modelo();
                modelo.setIdModelo(rs.getInt("IDMODELO"));
                modelo.setNomeModelo(rs.getString("NOMEMODELO"));
                modelo.setIdFabricante(rs.getInt("IDFABRICANTE"));
                modelo.setNomeFabricante(rs.getString("NOMEFABRICANTE"));
            modelos.add(modelo);
        }
        rs.close();
        stmt.close();
        con.close();
        return modelos;
    }
     
    /*public static List<Cliente> buscarClientes() throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado!");
        String sql = "select * from clientes ";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Cliente> clientes = new ArrayList<Cliente>();
        while (rs.next()) {
        	Cliente cliente = new Cliente();
        	cliente.setNome(rs.getString("nome"));
                cliente.setTipoLogradouro(rs.getString("tipoLogradouro"));
                cliente.setLogradouro(rs.getString("Logradouro"));
                cliente.setNumeroLogradouro(rs.getString("numeroLogradouro"));
                cliente.setTelefoneResidencial(rs.getString("telefoneResidencial"));
                cliente.setTelefoneComercial(rs.getString("telefoneComercial"));
                cliente.setTelefoneCelular(rs.getString("telefoneCelular"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setProfissao(rs.getString("profissao"));
            
            clientes.add(cliente);
        }
        rs.close();
        stmt.close();
        con.close();
        return Modelos;
    }*/
    
    /*public static void removerCliente(Cliente cliente) throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado!");
        String sql = "delete from clientes " +
            " where nome = '" + cliente.getNome() + "'" + 
            " and cpf = '" + cliente.getCpf() + "'";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        con.close();
    }*/
}
