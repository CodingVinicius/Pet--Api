package br.ufms.cpcx.api.demo.Dtos;

import br.ufms.cpcx.api.demo.Model.AgendamentoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AgendamentoPetDto(
        @NotBlank
        @Size(max = 100)
        String tipo_servico,

        @NotNull
        LocalDateTime data_horario,

        @NotNull
        Double valor,

        @Size(max = 250)
        String observacao
) {

    public AgendamentoModel toModel() {
        AgendamentoModel agendamento = new AgendamentoModel();

        agendamento.setTipo_servico(this.tipo_servico);
        agendamento.setData_horario(this.data_horario);
        agendamento.setValor(this.valor);
        agendamento.setObservacao(this.observacao);

        return agendamento;
    }
}