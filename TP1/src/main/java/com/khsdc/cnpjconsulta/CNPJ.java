
package com.khsdc.cnpjconsulta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CNPJ {
 
    @JsonProperty
    private String nome;
    @JsonProperty
    private String uf;
    @JsonProperty
    private String telefone;
    @JsonProperty
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CNPJ{" +
                "nome='" + nome + '\'' +
                ", uf='" + uf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}