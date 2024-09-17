package com.erp.springboot.backend.services.Usuarios;

import com.erp.springboot.backend.models.entidades.Usuario;
import com.erp.springboot.backend.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class UsuarioDetailsService implements UserDetailsService {


    private final IUserRepository userRepository;

    @Autowired
    public UsuarioDetailsService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = userRepository.findByUsername(username);

        if (usuarioOptional.isEmpty()) {
            throw new UsernameNotFoundException(String.format("El Usuario %s no se ha encontrado", username));
        }

        Usuario usuario = usuarioOptional.get();

        List<GrantedAuthority> authorities = usuario.getRoles().stream().map(rol -> (GrantedAuthority) rol::getNombre).toList();

        return new User(usuario.getUsername(),
                usuario.getPassword(),
                usuario.getEnabled(),
                true,
                true,
                true,
                authorities);

    }
}
