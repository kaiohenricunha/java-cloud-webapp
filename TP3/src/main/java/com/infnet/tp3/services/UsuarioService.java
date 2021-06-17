package com.infnet.tp3.services;

import com.infnet.tp3.clients.ViaCEPClient;
import com.infnet.tp3.domains.Endereco;
import com.infnet.tp3.domains.Usuario;
import com.infnet.tp3.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository ur;

    public UsuarioService(UsuarioRepository ur) {
        this.ur = ur;
    }

    public Usuario register(String nome, String email, String telefone,
                         String cep, Endereco endereco) {

        return this.ur.save(new Usuario(nome, email, telefone, cep, endereco));
    }

    public void update(Long id, Usuario u) {
        u.setId(id);
        ur.save(u);
    }

    public Usuario findUserByEmail(String email){
        Usuario usuario = this.ur.findByEmail(email);
        return usuario;
    }

}
