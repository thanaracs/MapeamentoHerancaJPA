package com.example.crudcomJPA.model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "tb_pessoafisica")
public class PessoaFisica extends Pessoa implements Serializable {

    @NotBlank
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}