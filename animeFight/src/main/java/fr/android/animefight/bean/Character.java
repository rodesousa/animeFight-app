package fr.android.animefight.bean;

import fr.android.animefight.bean.charac.Categorie;
import fr.android.animefight.bean.items.equipable.Armor;
import fr.android.animefight.bean.items.equipable.Trinket;
import fr.android.animefight.bean.items.equipable.Weapon;

import java.io.Serializable;

/**
 * un character doit toujours eêtre initialiser par sa categorie.
 * Exemple:
 * CategorieA.init(String nameDuCharacter) : Character
 * <p/>
 * Created by rohamdi on 17/02/2016.
 */
public class Character implements Serializable {
    private String name;
    private Armor armor;
    private Weapon weapon;
    private Trinket trinket;
    private int life;
    private int lifeCurrent;
    private int defense;
    private int attack;
    private int vitesse;
    private String imagePath;
    private Categorie categorie;
    private int id;


    public Character(String name) {
        this.name = name;
    }

    public Character() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return "char_" + this.toString();
    }

    public Trinket getTrinket() {
        return trinket;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setTrinket(Trinket trinket) {
        this.trinket = trinket;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLifeCurrent() {
        return lifeCurrent;
    }

    public void setLifeCurrent(int lifeCurrent) {
        this.lifeCurrent = lifeCurrent;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
}
