package edu.cibertec.service.impl;

import org.springframework.stereotype.Service;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.service.UsuarioService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

  
    @Override
    public UsuarioEntity validarUsuario(String user, String password) {
        return usuarioRepository.validarUsuario(user, password);
    }
    
}
