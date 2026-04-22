package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
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
    @DeleteMapping("/deletarMissao")
    public String deletarMissao(){
        return "Missao deletada";
    }

    // GET -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listarMissao")
    public String listarMissao(){
        return "Missao listada";
    }
}
