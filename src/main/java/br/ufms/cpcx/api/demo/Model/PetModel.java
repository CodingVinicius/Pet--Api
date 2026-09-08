package br.ufms.cpcx.api.demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TB_PET")
@Data
@NoArgsConstructor
public class PetModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String especie_raca;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false, length = 100)
    private String nome_tutor;

    @Column(nullable = false, length = 15)
    private String telefone_tutor;

    @Column(nullable = false, length = 200)
    private String endereco;

    @Column(length = 500)
    private String historico_observacoes;

    @Column(nullable = false)
    private LocalDate data_cadastro;
}