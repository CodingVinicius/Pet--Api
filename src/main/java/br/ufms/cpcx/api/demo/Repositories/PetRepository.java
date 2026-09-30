package br.ufms.cpcx.api.demo.Repositories;

import br.ufms.cpcx.api.demo.Model.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetModel, Long> {
}