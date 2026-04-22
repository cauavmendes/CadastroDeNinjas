package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesService missoesService;
    private final NinjaService ninjaService;

    public MissoesController(MissoesService missoesService, NinjaService ninjaService) {
        this.missoesService = missoesService;
        this.ninjaService = ninjaService;
    }

    // POST -- Mandar uma requisição para criar as missões
    @PostMapping("/criarMissao")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao) {
        return missoesService.criarMissao(missao);
    }

    // PUT -- Mandar uma requisição parar alterar as missões
    @PutMapping("/alterarMissao/{id}")
    public MissoesModel alterarMissao(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada){
        return missoesService.alterarMissao(id, missaoAtualizada);
    }

    // DELETE -- Mandar uma requisição para deletar as missões
    @DeleteMapping("/deletarMissao/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }

    // GET -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listarMissao")
    public List<MissoesModel> listarMissao(){
        return missoesService.listarMissao();
    }
}
