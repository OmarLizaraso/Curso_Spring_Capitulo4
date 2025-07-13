package edu.cibertec.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "curso")
@Data
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso")
    private Integer idcurso;

    @Column(name = "nomcurso", nullable = false, length = 40)
    private String nombrecurso;

    @Column(name = "fechainicio")
    private java.sql.Date fechaInicio;

    @Column(name = "alumnosmin", nullable = false)
    private Integer alumnosMinimo;

    @Column(name = "alumnosact")
    private Integer alumnosActual;

    @Column(name = "estado", nullable = false)
    private Integer estado;
}
