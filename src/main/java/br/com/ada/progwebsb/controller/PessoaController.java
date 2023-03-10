package br.com.ada.progwebsb.controller;

import br.com.ada.progwebsb.model.Pessoa;
import br.com.ada.progwebsb.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoas")
    public String pessoas(Model model) {
        List<Pessoa> pessoas = this.pessoaService.listarTodos();
        System.out.println(pessoas);
        model.addAttribute("pessoas", pessoas);
        return "pessoas";
    }

    @GetMapping("/pessoas_adultas")
    public String pessoasAdultas(Model model) {
        List<Pessoa> pessoas = this.pessoaService.buscarPessoasAdultas();
        System.out.println(pessoas);
        model.addAttribute("pessoas_adultas", pessoas);
        return "pessoas_adultas";
    }

    @GetMapping("/pessoas_menores")
    public String pessoasMenores(Model model) {
        List<Pessoa> pessoas = this.pessoaService.buscarPessoasMenores();
        System.out.println(pessoas);
        model.addAttribute("pessoas_menores", pessoas);
        return "pessoas_menores";
    }

    @GetMapping("/pessoa/add")
    public String addPessoa(Model model) {
        model.addAttribute("add", Boolean.TRUE);
        model.addAttribute("pessoa", new Pessoa());
        return "pessoa-add";
    }

    @PostMapping("/pessoa/add")
    public String criarPessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
        this.pessoaService.createPessoa(pessoa);
        return "redirect:/pessoas";
    }

    @GetMapping("/pessoa/{pessoaId}/delete")
    public String deletarPessoa(@PathVariable("pessoaId") Long pessoaId) {
        this.pessoaService.removerPessoaPorId(pessoaId);
        return "redirect:/pessoas";
    }

    @GetMapping("/pessoa/{pessoaId}/edit")
    public String mostrarEdicaoPessoa(Model model, @PathVariable("pessoaId") Long pessoaId) {
        Optional<Pessoa> optionalPessoa = this.pessoaService.buscarPessoaPorId(pessoaId);
        optionalPessoa.ifPresent(pessoa -> model.addAttribute("pessoa", pessoa));
        model.addAttribute("add", Boolean.FALSE);
        return "pessoa-add";
    }

    @PutMapping("/pessoa/{pessoaId}/edit")
    public String editarPessoa(@ModelAttribute("pessoa") Pessoa pessoa,
                                @PathVariable("pessoaId") Long pessoaId) {
        pessoa.setId(pessoaId);
        this.pessoaService.createPessoa(pessoa);
        return "redirect:/pessoas";
    }

}