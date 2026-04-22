package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service.NinjaService;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/alterarMissao")
    public String alterarMissao(){
        return "Missao alterada";
    }

    // DELETE -- Mandar uma requisição para deletar as missões
    @DeleteMapping("/deletarMissao/{id}")
    public void deletarMissao(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }

    // GET -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listarMissao")
    public String listarMissao(){
        return "Missao listada";
    }
}
