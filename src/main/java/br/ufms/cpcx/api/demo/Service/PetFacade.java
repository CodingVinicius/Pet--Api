
package br.ufms.cpcx.api.demo.Service;

import br.ufms.cpcx.api.demo.Model.AgendamentoModel;
import br.ufms.cpcx.api.demo.Model.PetModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetFacade {

    private final PetService petService;
    private final AgendamentoService agendamentoService;

    public PetFacade(PetService petService, AgendamentoService agendamentoService) {
        this.petService = petService;
        this.agendamentoService = agendamentoService;
    }

    public PetModel petSave(PetModel pet) {
        return petService.save(pet);
    }

    public List<PetModel> petFindAll() {
        return petService.findAll();
    }

    public PetModel petFindById(Long id) {
        return petService.findById(id);
    }

    public PetModel petUpdate(Long id, PetModel pet) {
        return petService.update(id, pet);
    }

    @Transactional
    public void petDelete(Long id) {
        petService.delete(id);
    }

    public AgendamentoModel agendamentoSave(AgendamentoModel agendamento, Long petId) {
        return agendamentoService.save(agendamento, petId);
    }

    public List<AgendamentoModel> agendamentoFindAll() {
        return agendamentoService.findAll();
    }

    public AgendamentoModel agendamentoFindById(Long id) {
        return agendamentoService.findById(id);
    }

    public AgendamentoModel agendamentoUpdate(Long id, AgendamentoModel agendamento, Long petId) {
        return agendamentoService.update(id, agendamento, petId);
    }

    public void agendamentoDelete(Long id) {
        agendamentoService.delete(id);
    }
}