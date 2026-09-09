package br.ufms.cpcx.api.demo.Dtos;

import br.ufms.cpcx.api.demo.Model.AgendamentoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AgendamentoDto(

        Long pet_id,

        @NotBlank
        @Size(max = 100)
        String tipo_servico,

        LocalDateTime data_horario,

        Double valor,

        @NotBlank
        @Size(max = 50)
        String status,

        @Size(max = 250)
        String observacoes

) {

    public AgendamentoModel toModel() {
        AgendamentoModel agendamentoModel = new AgendamentoModel();

        agendamentoModel.setPet_id(this.pet_id);
        agendamentoModel.setTipo_servico(this.tipo_servico);
        agendamentoModel.setData_horario(this.data_horario);
        agendamentoModel.setValor(this.valor);
        agendamentoModel.setStatus(this.status);
        agendamentoModel.setObservacoes(this.observacoes);

        return agendamentoModel;
    }
}