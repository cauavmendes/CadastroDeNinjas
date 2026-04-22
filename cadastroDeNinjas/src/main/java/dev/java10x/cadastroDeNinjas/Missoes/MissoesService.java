package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service.NinjaRepository;
import org.springframework.stereotype.Service;

@Service
public class MissoesService {
    private final MissoesRepository missoesRepository;
    private final NinjaRepository ninjaRepository;

    public MissoesService(MissoesRepository missoesRepository, NinjaRepository ninjaRepository) {
        this.missoesRepository = missoesRepository;
        this.ninjaRepository = ninjaRepository;
    }

    // CRIAR MISSAO
    public MissoesModel criarMissao (MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    public void deletarMissao(Long id){
        ninjaRepository.deleteById(id);
    }
}
