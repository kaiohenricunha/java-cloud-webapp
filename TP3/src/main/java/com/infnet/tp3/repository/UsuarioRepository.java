package com.infnet.tp3.repository;

import com.infnet.tp3.domains.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    public Usuario findByEmail(String email);
}
