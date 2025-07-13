package edu.cibertec.service.impl;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.repository.CursoRepository;
import edu.cibertec.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {
    
    @Autowired
    private CursoRepository cursoRepository;
    
    @Override
    public List<CursoEntity> listarCursos() {
        return cursoRepository.findByEstadoActive();
    }
    
    @Override
    public CursoEntity obtenerCurso(Integer id) {
        return cursoRepository.findByIdAndEstadoActive(id);
    }
    
    @Override
    public CursoEntity registrarCurso(CursoEntity curso) {
        // Establecer estado activo por defecto
        curso.setEstado(1);
        return cursoRepository.save(curso);
    }
    
    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        // Verificar que el curso existe y está activo
        CursoEntity cursoExistente = obtenerCurso(curso.getIdcurso());
        if (cursoExistente != null) {
            // Mantener el estado actual
            curso.setEstado(cursoExistente.getEstado());
            return cursoRepository.save(curso);
        }
        return null;
    }
    
    @Override
    public boolean eliminarCurso(Integer id) {
        try {
            Optional<CursoEntity> cursoOpt = cursoRepository.findById(id);
            if (cursoOpt.isPresent()) {
                CursoEntity curso = cursoOpt.get();
                // Eliminado lógico: cambiar estado a 0
                curso.setEstado(0);
                cursoRepository.save(curso);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
