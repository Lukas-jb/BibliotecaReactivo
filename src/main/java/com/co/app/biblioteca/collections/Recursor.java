package com.co.app.biblioteca.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Recursor {

    @Id
    private String id;
    private String informacion;

    public String getId() {
        return id;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}
