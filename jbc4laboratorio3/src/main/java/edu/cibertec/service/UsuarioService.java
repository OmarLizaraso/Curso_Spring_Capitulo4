package edu.cibertec.service;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioService {
    public UsuarioEntity validarUsuario(String user, String password);
}
