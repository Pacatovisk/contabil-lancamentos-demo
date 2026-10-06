package com.contabilidade.gateway.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PLANO_CONTAS", schema = "WSCONTABILIDADE")
public class PlanoContasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plano_contas")
    @SequenceGenerator(
            name = "seq_plano_contas",
            sequenceName = "SEQ_PLANO_CONTAS",
            allocationSize = 1
    )
    @Column(name = "ID_CONTA")
    private Long idConta;

    @Column(name = "CODIGO_CONTA", nullable = false)
    private String codigoConta;

    @Column(name = "DESCRICAO_CONTA", nullable = false)
    private String descricaoConta;

    @Column(name = "TIPO_CONTA", nullable = false)
    private String tipoConta;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "DATA_ATUALIZACAO")
    private LocalDateTime dataAtualizacao;
}