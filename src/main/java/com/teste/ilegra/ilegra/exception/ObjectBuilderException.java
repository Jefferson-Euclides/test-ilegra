package com.teste.ilegra.ilegra.exception;

public class ObjectBuilderException extends RuntimeException {

    public ObjectBuilderException(Exception e) {
        super("Error while building objects from the line, maybe the 'Type ID' is wrong: " + e.getMessage());
    }
}
