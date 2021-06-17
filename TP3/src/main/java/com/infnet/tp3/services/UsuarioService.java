package com.infnet.tp3.services;

import com.infnet.tp3.clients.ViaCEPClient;
import com.infnet.tp3.domains.Endereco;
import com.infnet.tp3.domains.Usuario;
import com.infnet.tp3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ViaCEPClient viaCEPClient;

    public Endereco buscarEndereco(String cep) {
        return viaCEPClient.buscaEnderecoPor(cep);
    }

    public void salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

}
