package com.co.app.biblioteca.router;

import com.co.app.biblioteca.useCase.UseCaseCrear;
import com.co.app.biblioteca.dto.RecursoDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CrearDatoRouter {

    @Bean
    public RouterFunction<ServerResponse> createQuestion(UseCaseCrear useCaseCrear){
        return router(
                POST("/crear").and(accept(MediaType.APPLICATION_JSON)),
                request ->request.bodyToMono(RecursoDTO.class)
                        .flatmap(questionDTO-> useCaseCrear.apply(questionDTO))
                        .flatmap(result-> ServerResponse.ok())
                        .contentTyipe(MediaType.TEXT_PLAIN)
                        .bodyValue(result)

        );
    }
}
