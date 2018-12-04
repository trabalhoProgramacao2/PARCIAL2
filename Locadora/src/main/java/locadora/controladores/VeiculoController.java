/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadora.modeloDAO.VeiculoDAO;
import locadora.modelodados.Veiculo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VeiculoController {
    @RequestMapping(value = "/veiculosIndex", method = RequestMethod.GET)
    public String clientesIndex(Model model) throws SQLException {		
		model.addAttribute("veiculo", new Veiculo());
                model.addAttribute("ListaVeiculos", VeiculoDAO.buscarVeiculos());
                model.addAttribute("fabricantes", VeiculoDAO.buscarFabricantes());
                model.addAttribute("cores", VeiculoDAO.buscarCores());
        return "veiculosIndex";
    }
    
     @RequestMapping(value = "/salvarveiculo", method = RequestMethod.POST)
	public String salvar(@ModelAttribute Veiculo veiculo, Model model) {		
		try {
			VeiculoDAO.adicionarVeiculo(veiculo);
                        model.addAttribute("veiculo", new Veiculo());
                        model.addAttribute("ListaVeiculos", VeiculoDAO.buscarVeiculos());
		} catch (SQLException e) {
			List<String> erros = new ArrayList<String>();
			erros.add("Erro ao inserir registro no banco de dados");
			model.addAttribute("erros", erros);
			return "veiculosIndex";
		}
		model.addAttribute("veiculo", new Veiculo());
	    return "veiculosIndex";
	}
        
    @RequestMapping(value = "/fabricantes", method = RequestMethod.GET)
    public String fabricantes(Model model) throws SQLException {
		model.addAttribute("fabricantes", VeiculoDAO.buscarFabricantes());
        return "fabricantes";
    }
    
    
}
