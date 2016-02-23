package com.example.animeFight_app.utils;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * Created by rodesousa on 22/02/16.
 */
public class Option<T> implements Serializable {
    public boolean isEmpty;
    protected T element;

    protected Option() {
    }

    protected Option(T element) {
        this.element = element;
    }

    public T get() {
        return element;
    }

    private T error() {
        throw new NoSuchElementException("None.get");
    }
}

