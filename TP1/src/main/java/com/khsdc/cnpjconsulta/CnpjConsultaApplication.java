package com.khsdc.cnpjconsulta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CnpjConsultaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CnpjConsultaApplication.class, args);
    }
        @Bean
        public CommandLineRunner run(ViaCEPClient client){
            return args -> {
                if (args.length > 0) {
                    String cep = args[0];
                    Endereco endereco = client.buscaEnderecoPor(cep);

                    System.out.println(endereco);
                }
            };
        }

}
