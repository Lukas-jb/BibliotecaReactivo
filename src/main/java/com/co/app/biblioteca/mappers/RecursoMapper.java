package com.co.app.biblioteca.mappers;

import com.co.app.biblioteca.dto.RecursoDTO;
import com.sofka.biblioteca.model.Recurso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecursoMapper {

    public Recurso fromDTO(RecursoDTO dto){
        Recurso recurso = new Recurso();
        recurso.setId(dto.getId());
        recurso.setArea(dto.getArea());
        recurso.setDisponible(dto.isDisponible());
        recurso.setFecha(dto.getFecha());
        recurso.setNombre(dto.getNombre());
        recurso.setTipo(dto.getTipo());
        return recurso;
    }

    public RecursoDTO fromCollection(Recurso collection){
        RecursoDTO recursoDTO = new RecursoDTO();
        recursoDTO.setId(collection.getId());
        recursoDTO.setArea(collection.getArea());
        recursoDTO.setDisponible(collection.isDisponible());
        recursoDTO.setFecha(collection.getFecha());
        recursoDTO.setNombre(collection.getNombre());
        recursoDTO.setTipo(collection.getTipo());
        return recursoDTO;
    }

    public List<RecursoDTO> fromCollectionList(List<Recurso> collection){
        if(collection==null){
            return null;
        }
        List<RecursoDTO> list = new ArrayList<>(collection.size());
        Iterator listTrack = collection.iterator();

        while(listTrack.hasNext()){
            Recurso recurso = (Recurso) listTrack.next();
            list.add(fromCollection(recurso));
        }
        return list;
    }
}