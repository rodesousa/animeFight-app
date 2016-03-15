package fr.android.animefight.bean;

import java.io.Serializable;

/**
 * Created by rodesousa on 22/02/16.
 * todo
 */
public class Tacticien extends Character implements Serializable {

    public Tacticien(String name, int life) {
        super(name);
        this.setLife(life);
        this.setLifeCurrent(life);
    }

}
