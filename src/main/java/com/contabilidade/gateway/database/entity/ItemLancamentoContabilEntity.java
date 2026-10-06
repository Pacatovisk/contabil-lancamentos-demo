package com.contabilidade.gateway.database.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ITENS_LANCAMENTO_CONTABIL", schema = "WSCONTABILIDADE")
public class ItemLancamentoContabilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_itens_lancamento")
    @SequenceGenerator(
            name = "seq_itens_lancamento",
            sequenceName = "SEQ_ITENS_LANCAMENTO",
            allocationSize = 1
    )
    @Column(name = "ID_ITEM")
    private Long idItem;

    @ManyToOne(fetch = FetchType.LAZY) // Evita carregar o cabeçalho desnecessariamente
    @JoinColumn(name = "ID_LANCAMENTO", nullable = false)
    private LancamentoContabilEntity lancamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CONTA", nullable = false)
    private PlanoContasEntity conta;

    @Enumerated(EnumType.STRING) // Garante que apenas valores válidos (D/C) entrem no banco
    @Column(name = "TIPO_MOVIMENTO", nullable = false, length = 1)
    private TipoMovimento tipoMovimento;

    @Column(name = "VALOR", nullable = false, precision = 19, scale = 2)
    private BigDecimal valor;

    public enum TipoMovimento {
        DEBITO, CREDITO
    }
}