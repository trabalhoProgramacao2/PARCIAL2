package locadora.controladores;

import locadora.modeloDAO.ModeloDAO;
import locadora.modelodados.Modelo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ModeloController {
	
	@RequestMapping(value = "/salvarmodelo", method = RequestMethod.POST)
	public String salvar(@ModelAttribute Modelo modelo, Model model) {		
		try {
                    ModeloDAO.adicionarModelo(modelo);
		} catch (SQLException e) {
			List<String> erros = new ArrayList<String>();
			erros.add("Erro ao inserir registro no banco de dados");
			model.addAttribute("erros", erros);
			return "novomodelo";
		}
		model.addAttribute("Modelo", new Modelo());
	    return "novomodelo";
	}
        
         @RequestMapping(value = "/modelosIndex", method = RequestMethod.GET)
    public String modelosIndex(Model model) throws SQLException {		
		model.addAttribute("modelo", new Modelo());
                model.addAttribute("ListaModelos", ModeloDAO.buscarModelos());
        return "modelosIndex";
    }
        
}