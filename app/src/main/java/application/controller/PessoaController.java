package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Pessoa;
import application.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepo;

    @GetMapping
    public Iterable<Pessoa> getAll() {
        return pessoaRepo.findAll();
    }

    @PostMapping
    public Pessoa insert(@RequestBody Pessoa novoRegistro){
        return pessoaRepo.save(novoRegistro);
    }

    @PutMapping("/{id}")
    public Pessoa update(@PathVariable long id, @RequestBody Pessoa dadosNovos){
        Pessoa dadosBanco = pessoaRepo.findById(id).get();
        dadosBanco.setNome(dadosNovos.getNome());
        dadosBanco.setIdade(dadosNovos.getIdade());
        
        return pessoaRepo.save(dadosBanco);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        pessoaRepo.deleteById(id);
    }
}
