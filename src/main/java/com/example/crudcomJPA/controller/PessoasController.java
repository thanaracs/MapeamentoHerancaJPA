package com.example.crudcomJPA.controller;


import com.example.crudcomJPA.dao.PessoaFisicaRepository;
import com.example.crudcomJPA.dao.PessoaJuridicaRepository;
import com.example.crudcomJPA.model.PessoaFisica;
import com.example.crudcomJPA.model.PessoaJuridica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Transactional
@Controller
@RequestMapping("pessoas")
public class PessoasController {


    @Autowired
    PessoaFisicaRepository repository;

    @Autowired
    PessoaJuridicaRepository pj_resRepository;


    @GetMapping("/formulario-pessoa-fisica")
    public String formPf(PessoaFisica pessoaFisica) {
        return "/pessoas/form.html";
    }

    @GetMapping("/formulario-pessoa-juridica")
    public String formPj(PessoaJuridica pessoaJuridica) {
        return "/pessoas/formpj.html";
    }

    @GetMapping("/list/pf")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pessoas", repository.pessoaFisica());
        return new ModelAndView("/pessoas/list", model);
    }

    @GetMapping("/list/pj")
    public ModelAndView listarpj(ModelMap model) {
        model.addAttribute("pessoas", pj_resRepository.pessoaJuridica());
        return new ModelAndView("/pessoas/listpj", model);
    }

    @PostMapping("/save/pf")
    public ModelAndView save(@Valid PessoaFisica pessoaFisica) {
        repository.save(pessoaFisica);
        return new ModelAndView("redirect:/pessoas/list/pf");
    }

    @PostMapping("/save/pj")
    public ModelAndView savePj(PessoaJuridica pessoaJuridica) {
        pj_resRepository.save(pessoaJuridica);
        return new ModelAndView("redirect:/pessoas/list/pj");
    }



    @GetMapping("/remove/pf/{id}")
    public ModelAndView remove(@PathVariable("id") int id) {
        repository.remove(id);
        return new ModelAndView("redirect:/pessoas/list/pf");
    }

    @GetMapping("/remove/pj/{id}")
    public ModelAndView removepj(@PathVariable("id") int id) {
        pj_resRepository.remove(id);
        return new ModelAndView("redirect:/pessoas/list/pj");
    }

    @GetMapping("/edit/pf/{id}")
    public ModelAndView edit(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("pessoaFisica", repository.pessoaFisica(id));
        return new ModelAndView("form.html", model);
    }

    @GetMapping("/edit/pj/{id}")
    public ModelAndView editpj(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("pessoaJuridica", pj_resRepository.pessoaJuridica(id));
        return new ModelAndView("/pessoas/formpj", model);
    }

    @PostMapping("/update/pf")
    public ModelAndView update(PessoaFisica pessoaFisica) {
        repository.update(pessoaFisica);
        return new ModelAndView("redirect:/pessoas/list/pf");
    }

    @PostMapping("/update/pj")
    public ModelAndView updatepj(PessoaJuridica pessoaJuridica) {
        pj_resRepository.update(pessoaJuridica);
        return new ModelAndView("redirect:/pessoas/list/pj");
    }

}

