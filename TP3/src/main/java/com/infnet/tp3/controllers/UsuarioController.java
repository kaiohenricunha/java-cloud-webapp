package com.infnet.tp3.controllers;

import com.infnet.tp3.clients.ViaCEPClient;
import com.infnet.tp3.domains.Endereco;
import com.infnet.tp3.domains.Usuario;
import com.infnet.tp3.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ViaCEPClient viaCEPClient;

    @RequestMapping(method = {RequestMethod.GET}, value = "/usuario/{email}")
    public Usuario findUserByEmail(@PathVariable String email) {
        return (Usuario) usuarioService.findUserByEmail(email);
    }

    @PostMapping("/registrarUsuario")
    public Usuario register(@RequestPart(value = "nome") String nome,
                     @RequestPart(value = "email") String email,
                     @RequestPart(value = "telefone") String telefone,
                     @RequestPart(value = "cep") String cep){

            Endereco endereco = viaCEPClient.buscaEnderecoPor(cep);
            // implementar upload da foto
            return usuarioService.register(nome, email, telefone, cep, endereco);
        }

    @RequestMapping(method = {RequestMethod.PUT}, value = "/alterarUsuario/{id}")
    public void update(@PathVariable Long id, @RequestBody Usuario u) {
        usuarioService.update(id, u);
    }
    }

