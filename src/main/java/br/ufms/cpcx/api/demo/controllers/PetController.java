package br.ufms.cpcx.api.demo.controllers;

import br.ufms.cpcx.api.demo.Dtos.PetDto;
import br.ufms.cpcx.api.demo.Model.PetModel;
import br.ufms.cpcx.api.demo.Service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<PetModel> save(@RequestBody @Valid PetDto petDto) {
        return ResponseEntity.ok(petService.save(petDto.toModel()));
    }

    @GetMapping
    public ResponseEntity<List<PetModel>> findAll() {
        return ResponseEntity.ok(petService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(petService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetModel> update(
            @PathVariable Long id,
            @RequestBody @Valid PetDto petDto) {

        return ResponseEntity.ok(petService.update(id, petDto.toModel()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        petService.delete(id);
        return ResponseEntity.noContent().build();
    }
}