package edu.cibertec.repository;

import edu.cibertec.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Integer> {
    
    // Buscar cursos activos (eliminado lógico)
    @Query("SELECT c FROM CursoEntity c WHERE c.estado = 1")
    List<CursoEntity> findByEstadoActive();
    
    // Buscar curso por id solo si está activo
    @Query("SELECT c FROM CursoEntity c WHERE c.idcurso = ?1 AND c.estado = 1")
    CursoEntity findByIdAndEstadoActive(Integer id);
}
