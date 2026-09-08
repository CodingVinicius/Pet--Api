package br.ufms.cpcx.api.demo.Service;


import br.ufms.cpcx.api.demo.Repositories.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService { ;
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

}
