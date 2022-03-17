package com.example.crudcomJPA.model;


import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "tb_pessoajuridica")
public class PessoaJuridica extends Pessoa implements Serializable {

    @NotBlank
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


}