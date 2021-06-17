package com.khsdc.DR4.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cep;
    private String endereço;

    public User() {
    }

    public User(String nome, String email, String telefone, String cep, String endereço) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.endereço = endereço;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof User)) {
            return false;
        }
        User other = (User) o;
        if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(o))) {
            return false;
        }
        return true;
       }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, telefone, cep, endereço);
    }

    @Override
    public String toString() {
        return "User{" +
                "id: " + id +
                "nome: " + nome + '\'' +
                "email: " + email + '\'' +
                "telefone: " + telefone + '\'' +
                "cep: " + cep + '\'' +
                "endereço: " + endereço + '\'' +
                '}';
    }
}
