
package br.ufms.cpcx.api.demo.controllers;

import br.ufms.cpcx.api.demo.Dtos.AgendamentoPetDto;
import br.ufms.cpcx.api.demo.Dtos.PetDto;
import br.ufms.cpcx.api.demo.Model.AgendamentoModel;
import br.ufms.cpcx.api.demo.Model.PetModel;
import br.ufms.cpcx.api.demo.Service.PetFacade;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pet")
public class PetController {

    private final PetFacade petFacade;

    public PetController(PetFacade petFacade) {
        this.petFacade = petFacade;
    }

    @PostMapping
    public ResponseEntity<PetModel> save(@Valid @RequestBody PetDto petDto) {
        return ResponseEntity.ok(petFacade.petSave(petDto.toModel()));
    }

    @GetMapping
    public ResponseEntity<List<PetModel>> findAll() {
        return ResponseEntity.ok(petFacade.petFindAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(petFacade.petFindById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetModel> update(@PathVariable Long id, @Valid @RequestBody PetDto petDto) {
        return ResponseEntity.ok(petFacade.petUpdate(id, petDto.toModel()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        petFacade.petDelete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{petId}/agendamento")
    public ResponseEntity<AgendamentoModel> saveAgendamento(@PathVariable Long petId, @Valid @RequestBody AgendamentoPetDto agendamentoPetDto) {
        return ResponseEntity.ok(petFacade.agendamentoSave(agendamentoPetDto.toModel(), petId));
    }
}