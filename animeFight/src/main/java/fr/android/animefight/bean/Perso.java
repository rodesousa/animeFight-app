package fr.android.animefight.bean;

import fr.android.animefight.bean.charac.Categorie;

/**
 * Created by rodesousa on 17/03/16.
 */
public class Perso {

    private Categorie categorie;
    private int image;
    private int icone;
    private String name;

    public Perso(Categorie categorie, int image, int icone, String name) {
        this.categorie = categorie;
        this.image = image;
        this.icone = icone;
        this.name = name;
    }

    public Character init() {
        return categorie.init(this);
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getIcone() {
        return icone;
    }

    public void setIcone(int icone) {
        this.icone = icone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
