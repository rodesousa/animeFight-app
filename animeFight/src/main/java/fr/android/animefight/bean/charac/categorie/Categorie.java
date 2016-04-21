package fr.android.animefight.bean.charac.categorie;

import fr.android.animefight.R;
import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.bean.items.equipable.Armor;
import fr.android.animefight.bean.perso.Perso;
import fr.android.animefight.utils.None;

import java.io.Serializable;

/**
 * Chaque character appartient a une catégorie. PLus sa Catégorie est elevé, plus ses stats évolueront plus vite
 * Created by rodesousa on 01/03/16.
 */
public class Categorie implements Serializable {
    private String name;

    public Categorie(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Surcharger cette méthode dans toutes les categories !
     * @return
     */
    public Character init(Perso perso) {
        Perso unknow = new Perso(new CategorieSS(), R.drawable.char_unknown, R.drawable.naru, "Unknow");
        return declareCharacter(unknow, 0, 0, 0, 0);
    }

    public Character declareCharacter(Perso perso, int life, int vitesse, int attack, int defense) {
        Character character = new Character(perso.getName());
        character.setLife(life);
        character.setLifeCurrent(life);
        character.setVitesse(vitesse);
        character.setAttack(attack);
        character.setDefense(defense);
        character.setCategorie(perso.getCategorie());
        character.setImagePath(perso.getImage());
        character.setArmor(new None<Armor>());
        character.setHead(new None<Armor>());
        return character;
    }

}
