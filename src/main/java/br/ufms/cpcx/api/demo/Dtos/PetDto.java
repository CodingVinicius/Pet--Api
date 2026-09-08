package br.ufms.cpcx.api.demo.Dtos;

import br.ufms.cpcx.api.demo.Model.PetModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PetDto(

        @NotBlank
        @Size(max = 100)
        String nome,

        @NotBlank
        @Size(max = 100)
        String especie_raca,

        Integer idade,

        @NotBlank
        @Size(max = 100)
        String nome_tutor,

        @NotBlank
        @Size(max = 15)
        String telefone_tutor,

        @NotBlank
        @Size(max = 200)
        String endereco,

        @Size(max = 500)
        String historico_observacoes

) {

    public PetModel toModel() {
        PetModel petModel = new PetModel();

        petModel.setNome(this.nome);
        petModel.setEspecie_raca(this.especie_raca);
        petModel.setIdade(this.idade);
        petModel.setNome_tutor(this.nome_tutor);
        petModel.setTelefone_tutor(this.telefone_tutor);
        petModel.setEndereco(this.endereco);
        petModel.setHistorico_observacoes(this.historico_observacoes);

        return petModel;
    }
}