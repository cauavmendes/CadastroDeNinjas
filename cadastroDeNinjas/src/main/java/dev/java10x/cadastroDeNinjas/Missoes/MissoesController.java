package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;
    private final NinjaService ninjaService;

    public MissoesController(MissoesService missoesService, NinjaService ninjaService) {
        this.missoesService = missoesService;
        this.ninjaService = ninjaService;
    }

    // POST -- Mandar uma requisição para criar as missões
    @PostMapping("/criarMissao")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao) {
        MissoesDTO novaMissao = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + novaMissao.getNome() + " (ID): " + novaMissao.getId());
    }

    // PUT -- Mandar uma requisição parar alterar as missões
    @PutMapping("/alterarMissao/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        MissoesDTO atualizarMissao = missoesService.alterarMissao(id, missaoAtualizada);
        if (atualizarMissao != null){
            return ResponseEntity.ok(atualizarMissao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " não encontrada");
        }
    }

    // DELETE -- Mandar uma requisição para deletar as missões
    @DeleteMapping("/deletarMissao/{id}")
    public ResponseEntity deletarMissao(@PathVariable Long id){
        if (missoesService.listarMissao() != null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão com o ID " + id + " deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o ID " + id + " não foi encontrada");
        }
    }

    // GET -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listarMissao")
    public ResponseEntity<List<MissoesDTO>> listarMissao(){
        List<MissoesDTO> missoes = missoesService.listarMissao();
        return ResponseEntity.ok(missoes);
    }
}
