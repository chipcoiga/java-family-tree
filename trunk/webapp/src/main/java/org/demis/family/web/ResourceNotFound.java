package org.demis.family.web;

public class ResourceNotFound extends Exception {

    public ResourceNotFound(String message, Throwable e) {
        super(message, e);
    }

    public ResourceNotFound(String message) {
        super(message);
    }
}
