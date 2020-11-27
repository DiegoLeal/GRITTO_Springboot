package br.com.gritto.resource;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatResource implements Serializable {

    private static final long serialVersionUID = 6030862910379069667L;

    @JsonProperty("texto")
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "ChatResource [texto=" + texto + "]";
    }

}