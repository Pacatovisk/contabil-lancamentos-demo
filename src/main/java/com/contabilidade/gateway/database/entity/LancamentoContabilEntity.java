package com.contabilidade.gateway.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class) // Habilita auditoria automática
@Table(name = "LANCAMENTOS_CONTABEIS", schema = "WSCONTABILIDADE")
public class LancamentoContabilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lancamentos_contabeis")
    @SequenceGenerator(
            name = "seq_lancamentos_contabeis",
            sequenceName = "SEQ_LANCAMENTOS_CONTABEIS",
            allocationSize = 1
    )
    @Column(name = "ID_LANCAMENTO")
    private Long idLancamento;

    @Column(name = "NUMERO_LOTE", nullable = false)
    private Long numeroLote;

    @Column(name = "DATA_LANCAMENTO", nullable = false)
    private LocalDate dataLancamento;

    @Column(name = "HISTORICO", length = 500)
    private String historico;

    @CreatedBy
    @Column(name = "USUARIO_CRIACAO", updatable = false)
    private String usuarioCriacao;

    @CreatedDate
    @Column(name = "DATA_CRIACAO", updatable = false)
    private LocalDateTime dataCriacao;

    @Builder.Default
    @OneToMany(
            mappedBy = "lancamento",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<ItemLancamentoContabilEntity> itens = new ArrayList<>();
}