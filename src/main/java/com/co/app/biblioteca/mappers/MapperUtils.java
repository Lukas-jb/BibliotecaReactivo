package com.co.app.biblioteca.mappers;

import com.co.app.biblioteca.Collections.Dato;
import com.co.app.biblioteca.dto.DatoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {

    public Function<DatoDTO, Dato> mapperToDato(String id) {
        return updateDato -> {
            var dato = new Dato();
            dato.setId(id);
            dato.setInformacion(updateDato.getInformacion());
            return dato;
        };
    }

    public Function<Dato, DatoDTO> mapDataToDTO() {
        return entity -> new DatoDTO(entity.getId(), entity.getInformacion());

    }
}

