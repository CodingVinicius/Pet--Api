package br.ufms.cpcx.api.demo.Dtos;

import br.ufms.cpcx.api.demo.Model.PetModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PetDto(
        @NotBlank
        @Size(max = 100)
        String nome,

        @NotBlank
        @Size(max = 100)
        String especie_raca,

        @NotNull
        Integer idade,

        @NotBlank
        @Size(max = 100)
        String nome_tutor,

        @NotBlank
        @Size(max = 20)
        String telefone_tutor,

        @NotBlank
        @Size(max = 200)
        String endereco,

        @Size(max = 500)
        String historico_observacoes,

        @NotNull
        LocalDate data_cadastro
) {

    public PetModel toModel() {
        PetModel pet = new PetModel();

        pet.setNome(this.nome);
        pet.setEspecie_raca(this.especie_raca);
        pet.setIdade(this.idade);
        pet.setNome_tutor(this.nome_tutor);
        pet.setTelefone_tutor(this.telefone_tutor);
        pet.setEndereco(this.endereco);
        pet.setHistorico_observacoes(this.historico_observacoes);
        pet.setData_cadastro(this.data_cadastro);

        return pet;
    }
}