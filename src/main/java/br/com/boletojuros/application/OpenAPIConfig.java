package br.com.boletojuros.application;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {


    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("API juros Boleto")
                        .description("API para calcular juros de boleto vencido")
                        .contact(new Contact().name("Thiago Araújo").email("ojuaradev@gmail.com"))
                        .version("1.0.0"));
    }

}
