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
                    if(cep.matches("[0-9]+") && cep.length() == 8) {
                        Endereco endereco = client.buscaEnderecoPor(cep);
                        System.out.println(endereco);
                    } else {
                        System.out.println("CEP inválido.");
                    }
                }
            };
        }
}
