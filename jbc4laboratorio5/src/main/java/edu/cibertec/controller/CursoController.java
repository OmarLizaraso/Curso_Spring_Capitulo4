package edu.cibertec.controller;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;
    
    @GetMapping("/listar")
    public String listarCursos(Model model) {
        try {
            List<CursoEntity> cursos = cursoService.listarCursos();
            model.addAttribute("cursos", cursos);
            model.addAttribute("titulo", "Lista de Cursos");
            return "cursos/listar";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los cursos: " + e.getMessage());
            return "error";
        }
    }
    
    @GetMapping("/mantenimientoCursos")
    public String mantenimientoCursos() {
        return "redirect:/cursos/listar";
    }
    
    @GetMapping("")
    public String redirectToListar() {
        return "redirect:/cursos/listar";
    }
}
