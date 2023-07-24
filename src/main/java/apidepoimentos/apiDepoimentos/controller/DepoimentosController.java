package apidepoimentos.apiDepoimentos.controller;

import apidepoimentos.apiDepoimentos.Depoimentos.*;
import jakarta.transaction.Transactional;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @PutMapping
    @Transactional
    public void editarDepoimentos(@RequestBody DadosAtualizacaoDepoimentos dados ) {
        var depoimento = repository.getReferenceById(dados.id());

        depoimento.AtualizacaoInfos(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDepoimentos(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/depoimentos-home")
    public List<Depoimento> depoimentosRandom() {
        List<Depoimento> todosDepoimentos = repository.findAll();

        List<Depoimento> randomDepoimentos = new ArrayList<>();
        Random random = new Random();

        if (todosDepoimentos.size() <= 3) {
            return todosDepoimentos;
        } else {
            List<Integer> indexes = new ArrayList<>();
            while (indexes.size() < 3) {
                int randomIndex = random.nextInt(todosDepoimentos.size());
                if (!indexes.contains(randomIndex)) {
                    indexes.add(randomIndex);
                }
            }

            for (int index : indexes) {
                randomDepoimentos.add(todosDepoimentos.get(index));
            }

            return randomDepoimentos;
        }
    }
}
