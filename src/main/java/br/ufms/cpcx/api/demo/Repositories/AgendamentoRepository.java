package br.ufms.cpcx.api.demo.Repositories;

import br.ufms.cpcx.api.demo.Model.AgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {

}