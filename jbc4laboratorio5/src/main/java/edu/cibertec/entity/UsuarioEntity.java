package edu.cibertec.entity;


import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idUsuario;

    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;

    @Column(name = "nombreapellido")
    private String nombreApellido;

    @Column(name = "foto")
    private byte[] foto;

    @Column(name = "estado")
    private Integer estado;
    
    @Transient
    private String fotoStringBase64;

    public String getFotoStringBase64() {
        return foto != null ? Base64.getEncoder().encodeToString(foto) : null;
    }
}
