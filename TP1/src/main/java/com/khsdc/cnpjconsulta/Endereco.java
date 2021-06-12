
package com.khsdc.cnpjconsulta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Endereco {
 
    @JsonProperty
    private String cep;
    @JsonProperty
    private String logradouro;
    @JsonProperty
    private String complemento;
    @JsonProperty
    private String bairro;
    @JsonProperty
    private String localidade;
    @JsonProperty
    private String uf;
    @JsonProperty
    private String ibge;
    @JsonProperty
    private String gia;
    @JsonProperty
    private String ddd;
 
    //getters 
 
    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}