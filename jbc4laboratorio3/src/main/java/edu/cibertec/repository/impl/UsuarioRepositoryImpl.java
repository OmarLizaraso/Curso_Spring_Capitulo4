package edu.cibertec.repository.impl;

import org.springframework.stereotype.Repository;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Override
    public UsuarioEntity validarUsuario(String user, String password) {
        if("jperezgil".equals(user) && "123456".equals(password)) {
            return new UsuarioEntity(1, user, password);
        } else {
            return null;
        }
    }
    
}
