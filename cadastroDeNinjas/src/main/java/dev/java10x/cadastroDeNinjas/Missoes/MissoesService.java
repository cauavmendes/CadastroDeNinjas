package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

@Service
public class MissoesService {
    private final MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // CRIAR MISSAO

    public MissoesModel criarMissao (MissoesModel missao) {
        return missoesRepository.save(missao);
    }
}
