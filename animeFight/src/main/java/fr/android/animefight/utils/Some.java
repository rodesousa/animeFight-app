package fr.android.animefight.utils;

/**
 * Created by rodesousa on 22/02/16.
 */
public class Some<T> extends Option {
    public Some(T element) {
        super(element);
        isEmpty = false;
    }

}
