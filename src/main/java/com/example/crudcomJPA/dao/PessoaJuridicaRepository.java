package com.example.crudcomJPA.dao;

import com.example.crudcomJPA.model.PessoaJuridica;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PessoaJuridicaRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(PessoaJuridica pessoaJuridica) {
        em.persist(pessoaJuridica);
    }

    public PessoaJuridica pessoaJuridica(int id) {
        return em.find(PessoaJuridica.class, id);
    }

    public List<PessoaJuridica> pessoaJuridica() {
        Query query = em.createQuery("from PessoaJuridica");
        return query.getResultList();
    }

    public void remove(int id) {
        PessoaJuridica pf = em.find(PessoaJuridica.class, id);
        em.remove(pf);
    }

    public void update(PessoaJuridica pessoaJuridica) {
        em.merge(pessoaJuridica);
    }
}

