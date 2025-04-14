package org.kfokam48.todolist.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(" TO-DO-LIST API")
                        .description("API permettant aux utilisateurs d'ajouter, lister, modifier, supprimer et trier des taches par statut")
                        .version("1.0.0")
                );
    }
}

