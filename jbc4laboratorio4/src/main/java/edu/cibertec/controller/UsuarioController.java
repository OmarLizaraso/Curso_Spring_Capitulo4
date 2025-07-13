package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Controller
@AllArgsConstructor
@Log
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    @RequestMapping("/")
    public String login(HttpSession session){
        UsuarioEntity usuario = (UsuarioEntity) session.getAttribute("usuario");
        if (usuario != null) {
            log.info("Usuario: " + usuario.getUser() + " ha iniciado sesión.");
            return "redirect:home";
        }else {
            log.warning("Usuario no autenticado, redirigiendo a login.");
            return "login";
        }
    }
    

    @RequestMapping("home")
    public String home(){
        return "home";
    }

    @RequestMapping("logout")
    public String home(HttpSession session){        
        session.removeAttribute("usuario");
        session.invalidate();
        //session.removeAttribute("usuario");//Descomentar si quiero generar un error
        return "redirect:/";
    }

    @RequestMapping("actionLogin")
    public ModelAndView actionLogin(String user, String password, HttpSession session) {
        ModelAndView mv = new ModelAndView("login");
        UsuarioEntity usuario = usuarioService.validarUsuario(user, password);
        if (usuario != null) {
           session.setAttribute("usuario", usuario);
           mv.setViewName("redirect:/");
        } else {
           mv.addObject("msgError", "Usuario o contraseña incorrectos");
        }
        return mv;
    }
}
