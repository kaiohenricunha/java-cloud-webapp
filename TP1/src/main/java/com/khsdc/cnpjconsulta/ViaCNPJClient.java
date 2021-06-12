/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khsdc.cnpjconsulta;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ViaCNPJClient {
    public CNPJ buscaEmpresaPor(String cnpj){
        RestTemplate template = new RestTemplate();
        return template.getForObject("https://receitaws.com.br/v1/cnpj/{cnpj}", CNPJ.class, cnpj);
    }
}