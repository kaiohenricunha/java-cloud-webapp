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
        public CommandLineRunner run(ViaCNPJClient client){
            return args -> {
                if (args.length > 0) {
                    String cnpj = args[0];
                    if(cnpj.matches("[0-9]+") && cnpj.length() == 14) {
                        CNPJ empresa = client.buscaEmpresaPor(cnpj);
                        System.out.println(empresa);
                    } else {
                        System.out.println("CNPJ inválido.");
                    }
                }
            };
        }
}
