package br.com.boletojuros.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;


@Getter
@Setter
public class CalculoBoletoRequest {

    @jakarta.validation.constraints.NotNull
    private String codigo;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("data_pagamento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataPagamento;
}
