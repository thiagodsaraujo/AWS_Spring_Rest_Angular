package br.com.boletojuros.adapter.http;


import br.com.boletojuros.adapter.datasource.mapper.CalculoBoletoMapper;
import br.com.boletojuros.adapter.http.dto.CalculoBoletoRequest;
import br.com.boletojuros.adapter.http.dto.CalculoBoletoResponse;
import br.com.boletojuros.core.port.in.CalculoBoletoPort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boleto")
public class CalculoBoletoController {


    private final CalculoBoletoPort calculoBoletoPort;

    private final CalculoBoletoMapper calculadoMapper;

    public CalculoBoletoController(CalculoBoletoPort calculoBoletoPort, CalculoBoletoMapper calculadoMapper) {
        this.calculoBoletoPort = calculoBoletoPort;
        this.calculadoMapper = calculadoMapper;
    }

    @PostMapping("/calculo")
    @Operation(summary = "Calcular juros de um boleto ")
    public ResponseEntity<CalculoBoletoResponse> calcularBoleto(@Valid @RequestBody CalculoBoletoRequest boleto){

        var boletoCalculado = calculoBoletoPort.executar(boleto.getCodigo(), boleto.getDataPagamento());

        return ResponseEntity.ok(calculadoMapper.toDTO(boletoCalculado));


    }

}
