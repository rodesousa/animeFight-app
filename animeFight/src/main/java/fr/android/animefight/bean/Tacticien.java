package fr.android.animefight.bean;

import java.io.Serializable;

/**
 * Created by rodesousa on 22/02/16.
 * todo
 */
public class Tacticien extends Character implements Serializable {
    private int column;
    private int raw;

    public Tacticien(String name, int life, int raw, int column) {
        super(name);
        this.setLife(life);
        this.setLifeCurrent(life);
        this.column = column;
        this.raw = raw;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRaw() {
        return raw;
    }

    public void setRaw(int raw) {
        this.raw = raw;
    }
}
