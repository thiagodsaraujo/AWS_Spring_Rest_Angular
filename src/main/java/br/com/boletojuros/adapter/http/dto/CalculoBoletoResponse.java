package br.com.boletojuros.adapter.http.dto;

import br.com.boletojuros.core.domain.enums.TipoBoleto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CalculoBoletoResponse {

    private String codigo;


    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataVencimento;

    private BigDecimal valor;

    private TipoBoleto tipo;
}
