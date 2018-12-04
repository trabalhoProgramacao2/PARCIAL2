/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.controladores;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadora.modeloDAO.ClienteDAO;
import locadora.modeloDAO.LocacaoDAO;
import locadora.modeloDAO.VeiculoDAO;
import locadora.modelodados.Cliente;
import locadora.modelodados.Locacao;
import locadora.modelodados.Veiculo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author USER
 */
@Controller
public class LocacaoController {
     @RequestMapping(value = "/locacoesIndex", method = RequestMethod.GET)
    public String clientesIndex(Model model) throws SQLException {		
		model.addAttribute("locacao", new Locacao());
                model.addAttribute("ListaLocacoes", LocacaoDAO.buscarLocacoes());
                model.addAttribute("ListaClientes", ClienteDAO.buscarClientes());
                model.addAttribute("ListaVeiculos", VeiculoDAO.buscarVeiculos());
        return "locacoesIndex";
    }
    
    @RequestMapping(value = "/salvarlocacao", method = RequestMethod.POST)
	public String salvar(@ModelAttribute Locacao locacao, Model model) throws SQLException {
            try {
			LocacaoDAO.adicionarLocacao(locacao);     
                        model.addAttribute("locacao", new Locacao());
                model.addAttribute("ListaLocacoes", LocacaoDAO.buscarLocacoes());
                model.addAttribute("ListaClientes", ClienteDAO.buscarClientes());
                model.addAttribute("ListaVeiculos", VeiculoDAO.buscarVeiculos());
		} catch (SQLException e) {
			List<String> erros = new ArrayList<String>();
			erros.add("Erro ao inserir registro no banco de dados");
			model.addAttribute("erros", erros);
			return "veiculosIndex";
		}
		
	    return "locacoesIndex";
	}
}
