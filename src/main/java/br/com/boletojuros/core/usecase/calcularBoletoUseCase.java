package br.com.boletojuros.core.usecase;

import br.com.boletojuros.core.domain.Boleto;
import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.domain.enums.TipoBoleto;
import br.com.boletojuros.core.domain.enums.TipoExcecao;
import br.com.boletojuros.core.exception.ApplicationException;
import br.com.boletojuros.core.port.in.CalculoBoletoPort;
import br.com.boletojuros.core.port.out.ComplementoBoletoPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class calcularBoletoUseCase implements CalculoBoletoPort {

    private final ComplementoBoletoPort complementoBoletoPort; //usando a abstração e nao a implementação dela, alguem
    //vai implementar em algum momento

    public calcularBoletoUseCase(ComplementoBoletoPort complementoBoletoPort) {
        this.complementoBoletoPort = complementoBoletoPort;
    }


    @Override
    public BoletoCalculado executar(String codigo, LocalDate dataPagamento) {
        var boleto = complementoBoletoPort.executar(codigo);
        // TODO - validar o boleto
        validar(boleto);


        // TODO - calcular boleto


        // TODO - salvar o boleto



        return null;
    }

    private void validar(Boleto boleto){
        if (boleto == null){
            throw new ApplicationException(TipoExcecao.TIPO_BOLETO_INVALIDO);
        }

        if (boleto.getTipo() != TipoBoleto.XPTO){
            throw new ApplicationException(TipoExcecao.BOLETO_INVALIDO);
        }

        if (boleto.getDataVencimento().isAfter(LocalDate.now())){
            throw new ApplicationException(TipoExcecao.BOLETO_NAO_VENCIDO);

        }
    }

}
