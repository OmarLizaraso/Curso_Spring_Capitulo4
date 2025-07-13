package edu.cibertec.repository;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioRepository {
    public UsuarioEntity validarUsuario(String user, String password);
}
