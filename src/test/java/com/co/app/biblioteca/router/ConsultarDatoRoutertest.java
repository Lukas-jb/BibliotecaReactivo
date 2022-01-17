package com.co.app.biblioteca.router;

import com.co.app.biblioteca.collections.Recursor;
import com.co.app.biblioteca.useCase.UseCaseCrear;
import com.co.app.biblioteca.dto.DatoDTO;
import com.co.app.biblioteca.mappers.MapperUtils;
import com.co.app.biblioteca.repositories.Repositorio;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConsultaDatoRouter.class, UseCaseCrear.class, MapperUtils.class})
public class ConsultarDatoRoutertest {

    @MockBean
    private Repositorio repositorio;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetDatos() {
        Recursor dato1 = new Recursor();
        dato1.setInformacion("Informacion 1");
        Recursor dato2 = new Recursor();
        dato2.setInformacion("Informacion 2");

        when(repositorio.findAll()).thenReturn(Flux.just(dato1, dato2));

        webTestClient.get()
                .uri("/consultar")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(DatoDTO.class)
                .value(userResponse -> {
                            Assertions.assertThat(userResponse.get(0).getInformacion()).isEqualTo(dato1.getInformacion());
                            Assertions.assertThat(userResponse.get(1).getInformacion()).isEqualTo(dato2.getInformacion());
                        }
                );
    }
}