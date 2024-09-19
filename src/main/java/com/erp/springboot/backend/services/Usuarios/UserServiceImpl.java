package com.erp.springboot.backend.services.Usuarios;

import com.erp.springboot.backend.models.dtos.Usuarios.IUsuarioRequest;
import com.erp.springboot.backend.models.dtos.Usuarios.UsuarioRequest;
import com.erp.springboot.backend.models.entidades.Rol;
import com.erp.springboot.backend.models.entidades.Usuario;
import com.erp.springboot.backend.repositories.IUserRepository;
import com.erp.springboot.backend.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(@NonNull Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        usuario.setRoles(getRoles(usuario));
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return userRepository.save(usuario);
    }

    @Override
    @Transactional
    public Optional<Usuario> update(UsuarioRequest user, Long id) {
        Optional<Usuario> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            Usuario userToUpdate = optionalUser.get();
            userToUpdate.setNombre(user.getNombre());
            userToUpdate.setApellido(user.getApellido());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setUsername(user.getUsername());
            return Optional.of(userRepository.save(userToUpdate));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Usuario> findByEnabledTrue() {
        return userRepository.findByEnabledTrue();
    }

    private List<Rol> getRoles(IUsuarioRequest user) {
        List<Rol> Rols = new ArrayList<>();
        Optional<Rol> optionalRolUser = roleRepository.findByNombre("Rol_USER");
        optionalRolUser.ifPresent(Rols::add);

        if (user.isAdmin()) {
            Optional<Rol> optionalRolAdmin = roleRepository.findByNombre("Rol_ADMIN");
            optionalRolAdmin.ifPresent(Rols::add);
        }
        return Rols;
    }
}
