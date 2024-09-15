package com.erp.springboot.backend.services;

import com.erp.springboot.backend.models.entidades.Usuario;
import com.erp.springboot.backend.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
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
        return userRepository.save(usuario);
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
}
