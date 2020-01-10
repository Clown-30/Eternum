package com.anal.app.Controladores;
import com.anal.app.Entidades.Consulta;
import com.anal.app.Entidades.Cliente;
import com.anal.app.Servicios.IConsultaServicios;
import com.anal.app.Servicios.ConsultaServicios;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ConsultaControlador {

    @Autowired
    private ConsultaServicios consultaService;

    // Mostrar todos los consultas
    @GetMapping("/showConsultas/{id}")
    public String buscarConsultas(@PathVariable String id,ModelMap model) {

      List<Consulta> consultas_f = new ArrayList<Consulta>();
      List<Consulta> consulta = (List<Consulta>) consultaService.findAll();
      for(int indice = 0;indice<consulta.size();indice++)
      {   int c = consulta.get(indice).getId_cliente();
          int id_t = consulta.get(indice).getId_consulta();
          if (c==Integer.valueOf(id)){
              consultas_f.add(consulta.get(indice));
          }
      }
       model.addAttribute("consultas", consultas_f);
       model.addAttribute("id_clienteh",id);
       return "showConsultas";
    }

    // Mostrar 1 clientes segun su id
    @RequestMapping("/showConsultas/show1Consulta/{id_consulta}")
    public String getConsulta(@PathVariable String id_consulta, Model model){
        model.addAttribute("consulta", consultaService.obtenerporId(Integer.valueOf(id_consulta)));
        return "show1Consulta";
    }


    ///////////////////////////////////   Crear   //////////////////////////////////////////////////// Usado para registros

        // Crear 1 consulta
    @RequestMapping(value="crearConsulta/{id_cliente}", method=RequestMethod.GET)
    public String nuevo(@PathVariable String id_cliente,ModelMap mp){
      Consulta consulta = new Consulta(Integer.valueOf(id_cliente));

      mp.addAttribute("consultaf", consulta);

      //model.addAttribute("id_clienteh",id);
      return "crearConsulta";
    }


    // Respuesta para el metedo "Crear 1 consulta"
    @RequestMapping(value="/crearConsulta", method=RequestMethod.POST)
    public String creare(Consulta consulta,
            BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "showConsultas/"+consulta.getId_cliente();
        }else{
            consultaService.saveOrUpdate(consulta);
            return "redirect:/showConsultas/"+consulta.getId_cliente();
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7

    // Borrar 1 cliente segun su id
    @RequestMapping("/showConsultas/delConsulta/{id}")
    public String delete(@PathVariable String id){
        int id_c = consultaService.obtenerporId(Integer.valueOf(id)).getId_cliente();
        consultaService.delete(Integer.valueOf(id));
        return "redirect:/showConsultas/"+id_c;
    }


}
