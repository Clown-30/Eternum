package com.anal.app.Controladores;
import com.anal.app.Entidades.Cliente;
import com.anal.app.Servicios.IClienteServicios;
import com.anal.app.Servicios.ClienteServicios;

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
public class ClienteControlador {

    @Autowired
    private ClienteServicios clienteService;

///////////////////////////////////   Crear   //////////////////////////////////////////////////// Usado para registros

    // Crear 1 cliente
    @RequestMapping(value="/crearCliente", method=RequestMethod.GET)
    public String nuevo(ModelMap mp){
        mp.put("clientef", new Cliente());
        return "crearCliente";
    }
    // Respuesta para el metedo "Crear 1 cliente"
    @RequestMapping(value="/crearCliente", method=RequestMethod.POST)
    public String crear(Cliente cliente,
            BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/showCliente";
        }else{
            clienteService.saveOrUpdate(cliente);
            return "redirect:/show1Cliente/"+cliente.getId_cliente();
        }
    }

/////////////////////////////////////   Mostrar   ////////////////////////////////////////////////// de momento no tiene uso pero es la metodologia para listar weas

    // Mostrar todos los clientes
    @GetMapping("/showCliente")
    public String findClientes(Model model) {
       model.addAttribute("clientes", clienteService.findAll());
        return "showCliente";
    }

    // Mostrar 1 clientes segun su id
    @RequestMapping("/show1Cliente/{id}")
    public String getCliente(@PathVariable String id, Model model){
        model.addAttribute("cliente", clienteService.obtenerporId(Integer.valueOf(id)));
        return "show1Cliente";
    }

//////////////////////////////////////  Borrar     /////////////////////////////////////////////////

    // Borrar 1 cliente segun su id
    @RequestMapping("/delCliente/{id}")
    public String delete(@PathVariable String id){
        clienteService.delete(Integer.valueOf(id));
        return "redirect:/showCliente";
    }


////////////////////////////////////////   Buscar   /////////////////////////////////////////////// Usado para el login

    // Buscar 1 cliente
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String buscarCliente(ModelMap mp){
        mp.put("clientef", new Cliente());
        return "login";
    }
    // Buscar 1 cliente, chekeo de la existencia del cliente segun los datos ingresados con el metodo "Buscar 1 Cliente"
    @RequestMapping(value="/check", method=RequestMethod.GET)
    public String check(Cliente cliente,
            BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/";
        }else{
            List<Cliente> clientes = (List<Cliente>) clienteService.findAll();
            for(int indice = 0;indice<clientes.size();indice++)
            {   String nombre = cliente.getNombre();
                String nombre_l = clientes.get(indice).getNombre();
                if (nombre.equals(nombre_l) && clientes.get(indice).getPassword().equals(cliente.getPassword())){
                  return "redirect:/showConsultas/"+clientes.get(indice).getId_cliente();
                }
            }
            return "redirect:/";
        }
    }

    ///////////////////////////////////////////////////////////////







}
