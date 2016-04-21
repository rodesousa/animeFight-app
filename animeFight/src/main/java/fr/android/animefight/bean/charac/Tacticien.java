package fr.android.animefight.bean.charac;

import fr.android.animefight.R;

/**
 * Created by rodesousa on 22/02/16.
 * todo
 */
public class Tacticien extends Character {
    private int column;
    private int raw;
    private int sizeCharacters = 5;

    public Tacticien(String name, int life, int raw, int column) {
        super(name);
        this.setLife(life);
        this.setLifeCurrent(life);
        this.column = column;
        this.raw = raw;
        this.setImagePath(R.drawable.char_unknown);
    }

    public Tacticien(Character bulma, int i, int i1) {

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

    public int getSizeCharacters() {
        return sizeCharacters;
    }

    public void setSizeCharacters(int sizeCharacters) {
        this.sizeCharacters = sizeCharacters;
    }
}
