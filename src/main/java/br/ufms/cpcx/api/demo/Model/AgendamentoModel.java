package br.ufms.cpcx.api.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_AGENDAMENTO")
@Data
@NoArgsConstructor
public class AgendamentoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties("agendamentos")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "pet",
            foreignKey = @ForeignKey(name = "FK_PET"),
            nullable = false
    )
    private PetModel pet;

    @Column(nullable = false, length = 100)
    private String tipo_servico;

    @Column(nullable = false)
    private LocalDateTime data_horario;

    @Column(nullable = false)
    private Double valor;

    @Column(length = 250)
    private String observacao;
}