package com.co.app.biblioteca.mappers;

import com.co.app.biblioteca.collections.Recursor;
import com.co.app.biblioteca.dto.DatoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {

    public Function<DatoDTO, Recursor> mapperToDato(String id) {
        return updateDato -> {
            var dato = new Recursor();
            dato.setId(id);
            dato.setInformacion(updateDato.getInformacion());
            return dato;
        };
    }

    public Function<Recursor, DatoDTO> mapDatoToDTO() {
        return entity -> new DatoDTO(entity.getId(), entity.getInformacion());

    }
}

