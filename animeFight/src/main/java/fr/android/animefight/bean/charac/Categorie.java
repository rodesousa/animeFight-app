package fr.android.animefight.bean.charac;

import fr.android.animefight.bean.Character;

import java.io.Serializable;

/**
 * Chaque character appartient a une catégorie. PLus sa Catégorie est elevé, plus ses stats évolueront plus vite
 * Created by rodesousa on 01/03/16.
 */
public abstract class Categorie implements Serializable {
    private String name;

    public Categorie(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Character init(String name) {
        return null;
    }

    ;
}
