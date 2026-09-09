package br.ufms.cpcx.api.demo.Service;


import br.ufms.cpcx.api.demo.Model.PetModel;
import br.ufms.cpcx.api.demo.Repositories.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
public class PetService { ;
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Transactional
    public PetModel save(PetModel petModel){
        return petRepository.save(petModel);
    }


    @Transactional
    public  void delete(PetModel petmodel){
         petRepository.delete(petmodel);
    }

    public Optional<PetModel> findById(Long id){
        return petRepository.findById(id);
    }

    public Page<PetModel> findAll(Pageable pageable) {
        return petRepository.findAll(pageable);
    }


}
