package br.com.boletojuros.adapter.datasource.database.entity;


import br.com.boletojuros.core.domain.enums.TipoBoleto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "boleto_calculado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoletoCalculadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String codigo;

    @Column
    private BigDecimal valorOriginal;

    @Column
    private BigDecimal valor;

    @Column
    private LocalDate dataVencimento;

    @Column
    private LocalDate dataPagamento;

    @Column
    private BigDecimal juros;

    @Column
    private TipoBoleto tipo;


}
