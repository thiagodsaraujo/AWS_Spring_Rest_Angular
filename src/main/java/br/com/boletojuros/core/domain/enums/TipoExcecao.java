package br.com.boletojuros.core.domain.enums;

public enum TipoExcecao {

    BOLETO_INVALIDO {
        @Override
        public String getMessageError() {
            return "O boleto informado é inválido!";
        }
    },
    TIPO_BOLETO_INVALIDO {
        @Override
        public String getMessageError() {
            return "Formato de BOleto inválido";
        }
    },
    BOLETO_NAO_VENCIDO {
        @Override
        public String getMessageError() {
            return "O Boleto informado ainda não está vencido";
        }
    };


    public abstract String getMessageError();




}
