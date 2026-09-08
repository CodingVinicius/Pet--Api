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

        @Size(max = 250)
        String observacao

) {

    public AgendamentoModel toModel() {
        AgendamentoModel agendamentoModel = new AgendamentoModel();

        agendamentoModel.setPet_id(this.pet_id);
        agendamentoModel.setTipo_servico(this.tipo_servico);
        agendamentoModel.setData_horario(this.data_horario);
        agendamentoModel.setValor(this.valor);
        agendamentoModel.setObservacao(this.observacao);

        return agendamentoModel;
    }
}