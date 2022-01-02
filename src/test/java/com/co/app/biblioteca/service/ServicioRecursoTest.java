package com.co.app.biblioteca.service;

import com.co.app.biblioteca.services.ServicioRecurso;
import com.co.app.biblioteca.utils.Area;
import com.co.app.biblioteca.utils.Tipo;
import com.sofka.biblioteca.model.Recurso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ServicioRecursoTest {

    @MockBean
    RepositorioRecurso repositorio;

    @Autowired
    private ServicioRecurso servicioRecurso;

    @Test
    void comprobarDisponibilidad() {
        var recurso = new Recurso("123",
                Tipo.DOCUMENTAL,
                Area.CIENCIAS,
                "La selva");

        Mockito.when(repositorio.findById("123")).thenReturn(java.util.Optional.of(recurso));

        var resultado = servicioRecurso.comprobarDisponibilidad("123");

        Assertions.assertEquals(true, resultado.isDisponible());
        Assertions.assertEquals("El material está disponible" , resultado.getMensaje());

        Mockito.verify(repositorio, Mockito.times(1)).findById("123");
    }

    @Test
    void buscarPorTipo() {
        var recursos = List.of( new Recurso("123",
                Tipo.DOCUMENTAL,
                Area.CIENCIAS,
                "La selva"));

        Mockito.when(repositorio.findByTipo("DOCUMENTAL")).thenReturn((List<Recurso>) recursos);

        var resultado = servicioRecurso.buscarPorTipo("DOCUMENTAL");

        Assertions.assertEquals(1, resultado.size());
        Assertions.assertEquals("La selva" , resultado.get(0).getNombre());
        Assertions.assertEquals(Tipo.DOCUMENTAL , resultado.get(0).getTipo());
        Assertions.assertEquals(Area.CIENCIAS, resultado.get(0).getArea());

        Mockito.verify(repositorio, Mockito.times(1)).findByTipo("DOCUMENTAL");
    }

    @Test
    void buscarPorArea() {
        var recursos = List.of( new Recurso("123",
                Tipo.DOCUMENTAL,
                Area.CIENCIAS,
                "La selva"));

        Mockito.when(repositorio.findByArea("CIENCIAS")).thenReturn((List<Recurso>) recursos);

        var resultado = servicioRecurso.buscarPorArea("CIENCIAS");

        Assertions.assertEquals(1, resultado.size());
        Assertions.assertEquals("La selva" , resultado.get(0).getNombre());
        Assertions.assertEquals(Tipo.DOCUMENTAL , resultado.get(0).getTipo());
        Assertions.assertEquals(Area.CIENCIAS, resultado.get(0).getArea());

        Mockito.verify(repositorio, Mockito.times(1)).findByArea("CIENCIAS");
    }

    @Test
    void buscarPorAreaYTipo() {

        var recursos = List.of( new Recurso("123",
                Tipo.DOCUMENTAL,
                Area.CIENCIAS,
                "La selva"));

        Mockito.when(repositorio.findByAreaAndTipo("CIENCIAS", "DOCUMENTAL"))
                .thenReturn((List<Recurso>) recursos);

        var resultado = servicioRecurso.buscarPorAreaYTipo("CIENCIAS", "DOCUMENTAL");

        Assertions.assertEquals(1, resultado.size());
        Assertions.assertEquals("La selva" , resultado.get(0).getNombre());
        Assertions.assertEquals(Tipo.DOCUMENTAL , resultado.get(0).getTipo());
        Assertions.assertEquals(Area.CIENCIAS, resultado.get(0).getArea());

        Mockito.verify(repositorio, Mockito.times(1)).findByAreaAndTipo("CIENCIAS", "DOCUMENTAL");
    }

    @Test
    void prestarRecurso() {
        RecursoMapper mapper = new RecursoMapper();

        var recurso = new Recurso("123",
                Tipo.DOCUMENTAL,
                Area.CIENCIAS,
                "La selva");
        var recursoRetorno = new Recurso("123",
                Tipo.DOCUMENTAL,
                Area.CIENCIAS,
                "La selva");

        Mockito.when(repositorio.findById("123")).thenReturn(Optional.of(recursoRetorno));
        Mockito.when(repositorio.save(any())).thenReturn(recursoRetorno);

        var resultado = servicioRecurso.prestarRecurso("123");

        Assertions.assertEquals(true, resultado.isDisponible());
        Assertions.assertEquals("El material está disponible" , resultado.getMensaje());

        Mockito.verify(repositorio, Mockito.times(1)).findById("123");
    }

    @Test
    void devolverRecurso() {
        RecursoMapper mapper = new RecursoMapper();

        var recurso = new Recurso("123",
                Tipo.DOCUMENTAL,
                Area.CIENCIAS,
                "La selva");
        var recursoRetorno = new Recurso("123",
                Tipo.DOCUMENTAL,
                Area.CIENCIAS,
                "La selva");

        Mockito.when(repositorio.findById("123")).thenReturn(Optional.of(recursoRetorno));
        Mockito.when(repositorio.save(any())).thenReturn(recursoRetorno);

        var resultado = servicioRecurso.devolverRecurso("123");

        Assertions.assertEquals(false, resultado.isDisponible());
        Assertions.assertEquals("El material no está prestado" , resultado.getMensaje());

        Mockito.verify(repositorio, Mockito.times(1)).findById("123");
    }

}
