package br.ufms.cpcx.api.demo.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB-AGENDAMENTO")
@Data
@NoArgsConstructor
public class AgendamentoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long pet_id;

    @Column(nullable = false, length = 100)
    private String tipo_servico;

    @Column(nullable = false, length =100)
    private LocalDateTime data_horario;

    @Column(nullable = false, length = 20)
    private Double valor;

    @Column(nullable = false, length = 250)
    private String observacao;

}
