package locadora.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadora.modeloDAO.ClienteDAO;
import locadora.modelodados.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {   
    @RequestMapping(value = "/clientesIndex", method = RequestMethod.GET)
    public String clientesIndex(Model model) throws SQLException {		
		model.addAttribute("cliente", new Cliente());
                model.addAttribute("ListaClientes", ClienteDAO.buscarClientes());
        return "clientesIndex";
    }
    
    @RequestMapping(value = "/salvarcliente", method = RequestMethod.POST)
	public String salvar(@ModelAttribute Cliente cliente, Model model) {		
		try {
			ClienteDAO.adicionarCliente(cliente);
                        model.addAttribute("cliente", new Cliente());
                        model.addAttribute("ListaClientes", ClienteDAO.buscarClientes());
		} catch (SQLException e) {
			List<String> erros = new ArrayList<String>();
			erros.add("Erro ao inserir registro no banco de dados");
			model.addAttribute("erros", erros);
			return "clientesIndex";
		}
		model.addAttribute("cliente", new Cliente());
	    return "clientesIndex";
	}
        
         @RequestMapping(value = "/deletarcliente", method = RequestMethod.POST)
	public String deletarcliente(@ModelAttribute Cliente cliente, Model model) {		
		try {
			ClienteDAO.removerCliente(cliente);
                        model.addAttribute("cliente", new Cliente());
                        model.addAttribute("ListaClientes", ClienteDAO.buscarClientes());
		} catch (SQLException e) {
			List<String> erros = new ArrayList<String>();
			erros.add("Erro ao inserir registro no banco de dados");
			model.addAttribute("erros", erros);
			return "clientesIndex";
		}
		model.addAttribute("cliente", new Cliente());
	    return "clientesIndex";
	}
	
}
