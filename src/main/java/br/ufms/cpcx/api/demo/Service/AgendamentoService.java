package br.ufms.cpcx.api.demo.Service;

import br.ufms.cpcx.api.demo.Model.AgendamentoModel;
import br.ufms.cpcx.api.demo.Repositories.AgendamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
public class AgendamentoService { ;
    private AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @Transactional
    public AgendamentoModel save(AgendamentoModel agendamentoModel) {
        return agendamentoRepository.save(agendamentoModel);
    }

    public Optional<AgendamentoModel> findById(Long id) {
        return agendamentoRepository.findById(id);
    }

    @Transactional
    public void delete(AgendamentoModel agendamentoModel) {
        agendamentoRepository.delete(agendamentoModel);
    }

    public Page<AgendamentoModel> findAll(Pageable pageable) {
        return agendamentoRepository.findAll(pageable);
    }


}

