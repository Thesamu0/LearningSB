package br.com.ada.progwebsb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_pessoa")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;

    private String cpf;

    private int idade;

    private String nomeDaMae;

    private String rg;

}
