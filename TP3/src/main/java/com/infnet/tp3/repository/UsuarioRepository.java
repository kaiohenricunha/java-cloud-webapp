package com.infnet.tp3.repository;

import com.infnet.tp3.domains.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    public Usuario findByEmail(String email);
}
