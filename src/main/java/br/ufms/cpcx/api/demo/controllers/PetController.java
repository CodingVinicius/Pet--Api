package br.ufms.cpcx.api.demo.controllers;

import br.ufms.cpcx.api.demo.Dtos.AgendamentoDto;
import br.ufms.cpcx.api.demo.Dtos.PetDto;
import br.ufms.cpcx.api.demo.Model.AgendamentoModel;
import br.ufms.cpcx.api.demo.Model.PetModel;
import br.ufms.cpcx.api.demo.Service.AgendamentoService;
import br.ufms.cpcx.api.demo.Service.PetService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1")
public class PetController {

    final PetService petService;
    final AgendamentoService agendamentoService;

    public PetController(PetService petService, AgendamentoService agendamentoService) {
        this.petService = petService;
        this.agendamentoService = agendamentoService;
    }

    @PostMapping("/pet")
    public ResponseEntity<PetModel> savePet(@RequestBody @Valid PetDto petDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(petService.save(petDto.toModel()));
    }

    @GetMapping("/pet")
    public ResponseEntity<Page<PetModel>> getAllPets(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(petService.findAll(pageable));
    }

    @GetMapping("/pet/{id}")
    public ResponseEntity<Object> getOnePet(@PathVariable(value = "id") Long id) {
        return petService.findById(id)
                .<ResponseEntity<Object>>map(pet -> ResponseEntity.status(HttpStatus.OK).body(pet))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found."));
    }

    @DeleteMapping("/pet/{id}")
    public ResponseEntity<Object> deletePet(@PathVariable(value = "id") Long id) {
        var pet = petService.findById(id);

        if (pet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found.");
        }

        petService.delete(pet.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pet deleted successfully.");
    }

    @PutMapping("/pet/{id}")
    public ResponseEntity<Object> updatePet(
            @PathVariable(value = "id") Long id,
            @RequestBody @Valid PetDto petDto) {

        var pet = petService.findById(id);

        if (pet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found.");
        }

        PetModel petModel = pet.get();
        PetModel updatedPet = petDto.toModel();

        petModel.setNome(updatedPet.getNome());
        petModel.setEspecie_raca(updatedPet.getEspecie_raca());
        petModel.setIdade(updatedPet.getIdade());
        petModel.setNome_tutor(updatedPet.getNome_tutor());
        petModel.setTelefone_tutor(updatedPet.getTelefone_tutor());
        petModel.setEndereco(updatedPet.getEndereco());
        petModel.setHistorico_observacoes(updatedPet.getHistorico_observacoes());

        return ResponseEntity.status(HttpStatus.OK).body(petService.save(petModel));
    }

    @PostMapping("/agendamento")
    public ResponseEntity<AgendamentoModel> saveAgendamento(
            @RequestBody @Valid AgendamentoDto agendamentoDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(agendamentoService.save(agendamentoDto.toModel()));
    }

    @GetMapping("/agendamento")
    public ResponseEntity<Page<AgendamentoModel>> getAllAgendamentos(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(agendamentoService.findAll(pageable));
    }

    @GetMapping("/agendamento/{id}")
    public ResponseEntity<Object> getOneAgendamento(@PathVariable(value = "id") Long id) {
        return agendamentoService.findById(id)
                .<ResponseEntity<Object>>map(agendamento -> ResponseEntity.status(HttpStatus.OK).body(agendamento))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento not found."));
    }

    @DeleteMapping("/agendamento/{id}")
    public ResponseEntity<Object> deleteAgendamento(@PathVariable(value = "id") Long id) {
        var agendamento = agendamentoService.findById(id);

        if (agendamento.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento not found.");
        }

        agendamentoService.delete(agendamento.get());
        return ResponseEntity.status(HttpStatus.OK).body("Agendamento deleted successfully.");
    }

    @PutMapping("/agendamento/{id}")
    public ResponseEntity<Object> updateAgendamento(
            @PathVariable(value = "id") Long id,
            @RequestBody @Valid AgendamentoDto agendamentoDto) {

        var agendamento = agendamentoService.findById(id);

        if (agendamento.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento not found.");
        }

        AgendamentoModel agendamentoModel = agendamento.get();
        AgendamentoModel updatedAgendamento = agendamentoDto.toModel();

        agendamentoModel.setPet_id(updatedAgendamento.getPet_id());
        agendamentoModel.setTipo_servico(updatedAgendamento.getTipo_servico());
        agendamentoModel.setData_horario(updatedAgendamento.getData_horario());
        agendamentoModel.setValor(updatedAgendamento.getValor());
        agendamentoModel.setStatus(updatedAgendamento.getStatus());
        agendamentoModel.setObservacoes(updatedAgendamento.getObservacoes());

        return ResponseEntity.status(HttpStatus.OK)
                .body(agendamentoService.save(agendamentoModel));
    }
}