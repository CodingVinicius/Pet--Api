package br.ufms.cpcx.api.demo.controllers;

import br.ufms.cpcx.api.demo.Dtos.AgendamentoDto;
import br.ufms.cpcx.api.demo.Model.AgendamentoModel;
import br.ufms.cpcx.api.demo.Service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<AgendamentoModel> save(@RequestBody @Valid AgendamentoDto agendamentoDto) {
        return ResponseEntity.ok(agendamentoService.save(agendamentoDto.toModel(), agendamentoDto.pet_id()));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoModel>> findAll() {
        return ResponseEntity.ok(agendamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(agendamentoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoModel> update(@PathVariable Long id, @RequestBody @Valid AgendamentoDto agendamentoDto) {
        return ResponseEntity.ok(agendamentoService.update(id, agendamentoDto.toModel(), agendamentoDto.pet_id()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agendamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}