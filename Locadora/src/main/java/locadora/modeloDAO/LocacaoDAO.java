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
import locadora.modelodados.Locacao;
import locadora.modelodados.Veiculo;
/**
/**
 *
 * @author USER
 */
public abstract class LocacaoDAO {
    public static List<Locacao> buscarLocacoes() throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado!");
        String sql = "SELECT\n" +
                        "L.IDLOCACAO,\n" +
                        "L.IDUSUARIO,\n" +
                        "U.NOME,\n" +
                        "L.IDVEICULO,\n" +
                        "M.NOMEMODELO,\n" +
                        "L.DATAENTRADA,\n" +
                        "L.DATASAIDA,\n" +
                        "L.VALOR\n" +
                        "FROM LOCACAO L\n" +
                        "JOIN VEICULO V ON L.IDVEICULO = V.IDVEICULO\n" +
                        "JOIN USUARIO U ON U.IDUSUARIO = L.IDUSUARIO\n" +
                        "JOIN MODELO M ON M.IDMODELO = V.IDMODELO\n";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Locacao> locacoes = new ArrayList<Locacao>();
        while (rs.next()) {
        	Locacao locacao = new Locacao();
                
                locacao.setIdLocacao(rs.getInt("IDLOCACAO"));
                
                locacao.setIdUsuario(rs.getInt("IDUSUARIO"));
                locacao.setNome(rs.getString("NOME"));
                
                locacao.setIdVeiculo(rs.getInt("IDVEICULO"));
                locacao.setNomeModelo(rs.getString("NOMEMODELO"));
                
                locacao.setDataEntrada(rs.getString("DATAENTRADA"));
                locacao.setDataSaida(rs.getString("DATASAIDA"));
                
                locacao.setValor(rs.getDouble("VALOR"));

        	
                
            locacoes.add(locacao);
        }
        rs.close();
        stmt.close();
        con.close();
        return locacoes;
    }
    
     public static void adicionarLocacao(Locacao locacao) throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado para adicionar locacao!");
        String sql = "insert into locacao (idlocacao, idusuario, idveiculo, dataentrada,datasaida, valor) values (?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, 3);
        stmt.setInt(2, locacao.getIdUsuario());
        stmt.setInt(3, locacao.getIdUsuario()); 
        stmt.setString(4, locacao.getDataEntrada());
        stmt.setString(5, locacao.getDataSaida());
        stmt.setDouble(6, locacao.getValor());
        stmt.execute();
        stmt.close();
        con.close();
    }
}
