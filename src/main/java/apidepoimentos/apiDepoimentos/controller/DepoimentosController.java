package apidepoimentos.apiDepoimentos.controller;

import apidepoimentos.apiDepoimentos.Depoimentos.DadosDepoimento;
import apidepoimentos.apiDepoimentos.Depoimentos.DadosListaDepoimentos;
import apidepoimentos.apiDepoimentos.Depoimentos.Depoimento;
import apidepoimentos.apiDepoimentos.Depoimentos.DepoimentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depoimentos")
public class DepoimentosController {

    @Autowired
    private DepoimentoRepository repository;

    @PostMapping
    @Transactional
    public void registrarDepoimentos(@RequestBody DadosDepoimento dados) {
        repository.save(new Depoimento(dados));
    }

    @GetMapping
    public List<DadosListaDepoimentos> listarDepoimentos() {
        return repository.findAll().stream().map(DadosListaDepoimentos::new).toList();
    }
}
