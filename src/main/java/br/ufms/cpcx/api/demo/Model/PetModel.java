package br.ufms.cpcx.api.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TB_PET")
@Data
@NoArgsConstructor
public class PetModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String especie_raca;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false, length = 100)
    private String nome_tutor;

    @Column(nullable = false, length = 20)
    private String telefone_tutor;

    @Column(nullable = false, length = 200)
    private String endereco;

    @Column(length = 500)
    private String historico_observacoes;

    @Column(nullable = false)
    private LocalDate data_cadastro;

    @JsonIgnoreProperties("pet")
    @OneToMany(mappedBy = "pet", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<AgendamentoModel> agendamentos;
}