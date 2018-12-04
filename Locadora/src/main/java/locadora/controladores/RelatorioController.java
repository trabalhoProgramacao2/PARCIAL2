/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.controladores;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadora.modeloDAO.RelatorioDAO;
import locadora.modelodados.Relatorio;

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
public class RelatorioController {
     @RequestMapping(value = "/relatorioIndex", method = RequestMethod.GET)
    public String clientesIndex(Model model) throws SQLException {		
		model.addAttribute("ListRelatorio", RelatorioDAO.buscarRelatorio());
        return "relatorioIndex";
    }
      
}
