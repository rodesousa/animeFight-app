package fr.android.animefight.Activity.tools;

import android.view.ViewGroup;

import java.io.Serializable;

/**
 * Objet qui permet de simplifier la liaison entre un lajout et un character.
 * Cela permet de pouvoir refresh le layaout selon le personnage modifier
 * Created by rodesousa on 06/04/16.
 */
public class Duo implements Serializable {
    private ViewGroup viewGroup;
    private int indice;

    public Duo(ViewGroup viewGroup, int indice) {
        this.viewGroup = viewGroup;
        this.indice = indice;
    }

    public ViewGroup getViewGroup() {
        return viewGroup;
    }

    public int getIndice() {
        return indice;
    }
}
