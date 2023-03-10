package br.com.ada.progwebsb.service;

import br.com.ada.progwebsb.model.Pessoa;
import br.com.ada.progwebsb.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void createPessoa(Pessoa pessoa){
        this.pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarTodos() {
        return this.pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        return this.pessoaRepository.findById(id);
    }

    public List<Pessoa> buscarPessoasAdultas() {
        return this.pessoaRepository.findPessoasAdultas();
    }

    public List<Pessoa> buscarPessoasMenores() {
        return this.pessoaRepository.findPessoasMenores();
    }

    public void removerPessoaPorId(Long id) {
        this.pessoaRepository.deleteById(id);
    }
}