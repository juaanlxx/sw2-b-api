package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
