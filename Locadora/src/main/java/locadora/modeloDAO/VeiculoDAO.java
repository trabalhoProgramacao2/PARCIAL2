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
import locadora.modelodados.Veiculo;
import locadora.modelodados.Fabricante;
/**
 *
 * @author USER
 */
public abstract class VeiculoDAO {
    
   
    
    public static List<Veiculo> buscarVeiculos() throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado!");
        String sql = "SELECT \n" +
                    "V.IDVEICULO,\n" +
                    "V.IDMODELO,\n" +
                    "M.NOMEMODELO,\n" +
                    "F.IDFABRICANTE,\n" +
                    "F.NOMEFABRICANTE,\n" +
                    "V.IDCOR,\n" +
                    "C.NOMECOR,\n" +
                    "V.PLACA\n" +
                    "FROM VEICULO V\n" +
                    "\n" +
                    "JOIN MODELO M ON M.IDMODELO = V.IDMODELO\n" +
                    "JOIN FABRICANTE F ON F.IDFABRICANTE = M.IDFABRICANTE\n" +
                    "JOIN COR C ON C.IDCOR = V.IDCOR";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        while (rs.next()) {
        	Veiculo veiculo = new Veiculo();
                
                veiculo.setIdVeiculo(rs.getInt("IDVEICULO"));
                
                veiculo.setIdModelo(rs.getInt("IDMODELO"));
                veiculo.setNomeModelo(rs.getString("NOMEMODELO"));
                
                veiculo.setIdFabricante(rs.getInt("IDFABRICANTE"));
                veiculo.setNomeFabricante(rs.getString("NOMEFABRICANTE"));
                
                veiculo.setIdCor(rs.getInt("IDCOR"));
                veiculo.setNomeCor(rs.getString("NOMECOR"));
                
                veiculo.setPlacaVeiculo(rs.getString("PLACA"));

        	
                
            veiculos.add(veiculo);
        }
        rs.close();
        stmt.close();
        con.close();
        return veiculos;
    }
    
    public static List<String> buscarFabricantes() throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado!");
        String sql = "SELECT * FROM FABRICANTE";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<String> fabricantes = new ArrayList<String>();
                
        while (rs.next()) {              
               
            fabricantes.add(rs.getString("NOMEFABRICANTE"));
        }
        rs.close();
        stmt.close();
        con.close();
        return fabricantes;
    }
    
      public static List<String> buscarCores() throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado!");
        String sql = "SELECT * FROM COR";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<String> cores = new ArrayList<String>();
                
        while (rs.next()) {              
               
            cores.add(rs.getInt("IDCOR") + " - " + rs.getString("NOMECOR"));
        }
        rs.close();
        stmt.close();
        con.close();
        return cores;
    }
    
     public static void adicionarVeiculo(Veiculo veiculo) throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado para adicionar veículo!");
        String sql = "insert into veiculo (idmodelo, idcor, placa) values (?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, 3);
        stmt.setInt(1, veiculo.getIdModelo());
        stmt.setInt(2, veiculo.getIdCor()); 
        stmt.setString(3, veiculo.getPlacaVeiculo());
        stmt.execute();
        stmt.close();
        con.close();
    }
}
