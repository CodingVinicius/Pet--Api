
package br.ufms.cpcx.api.demo.Service;

import br.ufms.cpcx.api.demo.Model.AgendamentoModel;
import br.ufms.cpcx.api.demo.Model.PetModel;
import br.ufms.cpcx.api.demo.Repositories.AgendamentoRepository;
import br.ufms.cpcx.api.demo.Repositories.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final PetRepository petRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, PetRepository petRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.petRepository = petRepository;
    }

    public AgendamentoModel save(AgendamentoModel agendamento, Long petId) {
        PetModel pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado"));

        agendamento.setPet(pet);

        return agendamentoRepository.save(agendamento);
    }

    public List<AgendamentoModel> findAll() {
        return agendamentoRepository.findAll();
    }

    public AgendamentoModel findById(Long id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
    }

    public AgendamentoModel update(Long id, AgendamentoModel agendamento, Long petId) {
        AgendamentoModel agendamentoAtual = findById(id);

        PetModel pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado"));

        agendamentoAtual.setPet(pet);
        agendamentoAtual.setTipo_servico(agendamento.getTipo_servico());
        agendamentoAtual.setData_horario(agendamento.getData_horario());
        agendamentoAtual.setValor(agendamento.getValor());
        agendamentoAtual.setObservacao(agendamento.getObservacao());

        if (agendamento.getStatus() != null) {
            agendamentoAtual.setStatus(agendamento.getStatus());
        }

        return agendamentoRepository.save(agendamentoAtual);
    }

    public void delete(Long id) {
        AgendamentoModel agendamento = findById(id);

        if (!"Concluído".equals(agendamento.getStatus())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Só é permitido excluir agendamentos com status Concluído");
        }

        agendamentoRepository.delete(agendamento);
    }
}