package com.infnet.tp3.controllers;

import com.infnet.tp3.clients.AmazonClient;
import com.infnet.tp3.clients.ViaCEPClient;
import com.infnet.tp3.domains.Endereco;
import com.infnet.tp3.domains.Usuario;
import com.infnet.tp3.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ViaCEPClient viaCEPClient;
    @Autowired
    private AmazonClient amazonClient;

    @RequestMapping(method = {RequestMethod.GET}, value = "/usuario/{email}")
    public Usuario findUserByEmail(@PathVariable String email) {
        return (Usuario) usuarioService.findUserByEmail(email);
    }

    @PostMapping("/registrarUsuario")
    public Usuario register(@RequestPart(value = "nome") String nome,
                            @RequestPart(value = "email") String email,
                            @RequestPart(value = "telefone") String telefone,
                            @RequestPart(value = "cep") String cep,
                            @RequestPart(value = "mfile") MultipartFile mfile) throws IOException {

            Endereco endereco = viaCEPClient.buscaEnderecoPor(cep);

            String fileUrl = amazonClient.uploadFile(mfile);

            File file = amazonClient.convertMultiPartToFile(mfile);

            amazonClient.uploadFileTos3bucket(fileUrl, file);

            return usuarioService.register(nome, email, telefone, cep, endereco, fileUrl);
        }


    @RequestMapping(method = {RequestMethod.PUT}, value = "/alterarUsuario/{id}")
    public void update(@PathVariable Long id, @RequestBody Usuario u) {

        usuarioService.update(id, u);
    }

    @RequestMapping(value = "/editarUsuario", method = RequestMethod.PUT)
    public void editarUsuario(@RequestParam("nome") String nome,
                         @RequestParam("email") String email,
                         @RequestParam("telefone") String telefone,
                         @RequestParam("cep") String cep) {

        usuarioService.edit(nome, email, telefone, cep);
    }

    @RequestMapping(value = "/editarEmail", method = RequestMethod.PUT)
    public void editarEmail(@RequestParam("email") String email,
                            @RequestParam("novoemail") String novoemail) {

        usuarioService.editarEmail(email, novoemail);
    }
    }

