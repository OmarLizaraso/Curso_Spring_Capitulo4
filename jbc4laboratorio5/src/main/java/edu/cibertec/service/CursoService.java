package edu.cibertec.service;

import edu.cibertec.entity.CursoEntity;

import java.util.List;

public interface CursoService {
    
    /**
     * Lista todos los cursos activos
     * @return Lista de cursos
     */
    List<CursoEntity> listarCursos();
    
    /**
     * Obtiene un curso por su ID
     * @param id ID del curso
     * @return Curso encontrado o null
     */
    CursoEntity obtenerCurso(Integer id);
    
    /**
     * Registra un nuevo curso
     * @param curso Curso a registrar
     * @return Curso registrado
     */
    CursoEntity registrarCurso(CursoEntity curso);
    
    /**
     * Actualiza un curso existente
     * @param curso Curso con datos actualizados
     * @return Curso actualizado
     */
    CursoEntity actualizarCurso(CursoEntity curso);
    
    /**
     * Elimina un curso de forma lógica (cambia estado a 0)
     * @param id ID del curso a eliminar
     * @return true si se eliminó correctamente
     */
    boolean eliminarCurso(Integer id);
}
