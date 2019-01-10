package com.br.meusconvidados.entities;

public class GuestEntity {

    private int id;
    private String name;
    private String document;
    private int confirmed;

    public GuestEntity(){}

    public GuestEntity(int id, String name,String document, int confirmed) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.confirmed = confirmed;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }
}
