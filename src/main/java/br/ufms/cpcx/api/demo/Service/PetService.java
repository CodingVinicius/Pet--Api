package br.ufms.cpcx.api.demo.Service;

import br.ufms.cpcx.api.demo.Exceptions.AlreadyExistsException;
import br.ufms.cpcx.api.demo.Model.PetModel;
import br.ufms.cpcx.api.demo.Repositories.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public PetModel save(PetModel pet) {
        boolean duplicado = petRepository.findAll().stream()
                .anyMatch(p -> p.getNome().equalsIgnoreCase(pet.getNome())
                        && p.getTelefone_tutor().equals(pet.getTelefone_tutor()));

        if (duplicado) {
            throw new AlreadyExistsException(
                    "Já existe um pet cadastrado com esse nome e telefone do tutor");
        }

        return petRepository.save(pet);
    }

    public List<PetModel> findAll() {
        return petRepository.findAll();
    }

    public PetModel findById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado"));
    }

    public PetModel update(Long id, PetModel pet) {
        PetModel petAtual = findById(id);

        boolean duplicado = petRepository.findAll().stream()
                .anyMatch(p -> !p.getId().equals(id)
                        && p.getNome().equalsIgnoreCase(pet.getNome())
                        && p.getTelefone_tutor().equals(pet.getTelefone_tutor()));

        if (duplicado) {
            throw new AlreadyExistsException(
                    "Já existe outro pet cadastrado com esse nome e telefone do tutor");
        }

        petAtual.setNome(pet.getNome());
        petAtual.setEspecie_raca(pet.getEspecie_raca());
        petAtual.setIdade(pet.getIdade());
        petAtual.setNome_tutor(pet.getNome_tutor());
        petAtual.setTelefone_tutor(pet.getTelefone_tutor());
        petAtual.setEndereco(pet.getEndereco());
        petAtual.setHistorico_observacoes(pet.getHistorico_observacoes());
        petAtual.setData_cadastro(pet.getData_cadastro());

        return petRepository.save(petAtual);
    }

    public void delete(Long id) {
        PetModel pet = findById(id);
        petRepository.delete(pet);
    }
}