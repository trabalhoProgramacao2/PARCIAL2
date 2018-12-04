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

import locadora.modelodados.Relatorio;

/**
 *
 * @author USER
 */
public abstract class RelatorioDAO {
    public static List<Relatorio> buscarRelatorio() throws SQLException{
        Connection con = Conexao.getConnection();
        System.out.println("Conectado!");
        String sql = "SELECT\n" +                        
                        "U.NOME,\n" +                        
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
        List<Relatorio> listRelatorio = new ArrayList<Relatorio>();
        while (rs.next()) {
        	Relatorio relatorio = new Relatorio();
                relatorio.setNome(rs.getString("NOME"));
                relatorio.setNomeModelo(rs.getString("NOMEMODELO"));
                relatorio.setDataEntrada(rs.getString("DATAENTRADA"));
                relatorio.setDataSaida(rs.getString("DATASAIDA"));
                relatorio.setValor(rs.getDouble("VALOR"));
            listRelatorio.add(relatorio);
        }
        rs.close();
        stmt.close();
        con.close();
        return listRelatorio;
    }
}
