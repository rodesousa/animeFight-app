package com.example.animeFight_app.bean.team;

import java.io.Serializable;

/**
 * Created by rodesousa on 22/02/16.
 * todo
 * x et y sont les paramètre de la formation. C'est pas ouf mais pas d'autre idée.
 */
public class Tacticien extends Character implements Serializable {

    public Tacticien(String name, int x, int y) {
        super(name);
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
