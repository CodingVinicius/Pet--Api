
package br.ufms.cpcx.api.demo.controllers;

import br.ufms.cpcx.api.demo.Dtos.AgendamentoDto;
import br.ufms.cpcx.api.demo.Model.AgendamentoModel;
import br.ufms.cpcx.api.demo.Service.PetFacade;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/agendamento")
public class AgendamentoController {

    private final PetFacade petFacade;

    public AgendamentoController(PetFacade petFacade) {
        this.petFacade = petFacade;
    }

    @PostMapping
    public ResponseEntity<AgendamentoModel> save(@Valid @RequestBody AgendamentoDto agendamentoDto) {
        return ResponseEntity.ok(petFacade.agendamentoSave(agendamentoDto.toModel(), agendamentoDto.pet_id()));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoModel>> findAll() {
        return ResponseEntity.ok(petFacade.agendamentoFindAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(petFacade.agendamentoFindById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoModel> update(@PathVariable Long id, @Valid @RequestBody AgendamentoDto agendamentoDto) {
        return ResponseEntity.ok(petFacade.agendamentoUpdate(id, agendamentoDto.toModel(), agendamentoDto.pet_id()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        petFacade.agendamentoDelete(id);
        return ResponseEntity.noContent().build();
    }
}