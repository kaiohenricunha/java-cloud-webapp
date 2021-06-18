package com.infnet.tp3.services;

import com.infnet.tp3.clients.ViaCEPClient;
import com.infnet.tp3.domains.Endereco;
import com.infnet.tp3.domains.Usuario;
import com.infnet.tp3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository ur;
    @Autowired
    private ViaCEPClient viaCEPClient;

    public UsuarioService(UsuarioRepository ur) {
        this.ur = ur;
    }

    public Usuario register(String nome, String email, String telefone,
                         String cep, Endereco endereco, String fileUrl) {

        return this.ur.save(new Usuario(nome, email, telefone, cep, endereco, fileUrl));
    }

    public void update(Long id, Usuario u) {
        u.setId(id);
        ur.save(u);
    }

    public void edit(String nome, String email, String telefone, String cep) {
        Usuario usuario = ur.findByEmail(email);
        usuario.setNome(nome);
        usuario.setTelefone(telefone);
        usuario.setCep(cep);
        Endereco endereco = viaCEPClient.buscaEnderecoPor(cep);
        usuario.setEndereco(endereco);
        ur.save(usuario);
    }

    public void editarEmail(String email, String novoemail) {
        Usuario usuario = ur.findByEmail(email);
        usuario.setEmail(novoemail);
        ur.save(usuario);
    }

    public Usuario findUserByEmail(String email){
        Usuario usuario = this.ur.findByEmail(email);
        return usuario;
    }

}
