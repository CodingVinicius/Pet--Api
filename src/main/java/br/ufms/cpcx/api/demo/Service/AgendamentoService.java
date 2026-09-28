package br.ufms.cpcx.api.demo.Service;

import br.ufms.cpcx.api.demo.Model.AgendamentoModel;
import br.ufms.cpcx.api.demo.Repositories.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public AgendamentoModel save(AgendamentoModel agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public List<AgendamentoModel> findAll() {
        return agendamentoRepository.findAll();
    }

    public AgendamentoModel findById(Long id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    public AgendamentoModel update(Long id, AgendamentoModel agendamento) {
        AgendamentoModel agendamentoAtual = findById(id);

        agendamentoAtual.setPet_id(agendamento.getPet_id());
        agendamentoAtual.setTipo_servico(agendamento.getTipo_servico());
        agendamentoAtual.setData_horario(agendamento.getData_horario());
        agendamentoAtual.setValor(agendamento.getValor());
        agendamentoAtual.setObservacao(agendamento.getObservacao());

        return agendamentoRepository.save(agendamentoAtual);
    }

    public void delete(Long id) {
        AgendamentoModel agendamento = findById(id);
        agendamentoRepository.delete(agendamento);
    }
}