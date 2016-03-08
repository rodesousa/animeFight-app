package fr.android.animefight.utils;

import java.util.NoSuchElementException;

/**
 * Created by rodesousa on 22/02/16.
 */
public class None<T> extends Option<T> {

    public None() {
        super();
        isEmpty = false;
        this.element = null;
    }

    public T error() {
        throw new NoSuchElementException("None.get");
    }

}
