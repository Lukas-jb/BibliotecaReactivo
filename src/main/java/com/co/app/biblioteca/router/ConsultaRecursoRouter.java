package com.co.app.biblioteca.router;

import com.co.app.biblioteca.useCase.UseCaseListar;
import com.co.app.biblioteca.dto.RecursoDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ConsultaRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> getall(UseCaseListar useCaseListar) {
        return router(
                GET("/consutar").and(accept(MediaType.APPLICATION_JSON)),
                request ->ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseListar.get(), RecursoDTO.class))
        );
    }
}
