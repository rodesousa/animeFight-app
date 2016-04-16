package fr.android.animefight.bean;

import fr.android.animefight.bean.charac.Categorie;
import fr.android.animefight.bean.items.equipable.Armor;
import fr.android.animefight.bean.items.equipable.Trinket;
import fr.android.animefight.bean.items.equipable.Weapon;
import fr.android.animefight.utils.Option;

import java.io.Serializable;

/**
 * un character doit toujours eêtre initialiser par sa categorie.
 * Exemple:
 * CategorieA.init(String nameDuCharacter) : Character
 * <p>
 * Created by rohamdi on 17/02/2016.
 */
public class Character implements Serializable {
    private String name;
    private Option<Armor> head;
    private Option<Armor> armor;
    private Option<Weapon> weapon;
    private Trinket trinket;
    private int life;
    private int lifeCurrent;
    private int defense;
    private int attack;
    private int vitesse;
    private int imagePath;
    private int xp;
    private int xpToShare;
    private Categorie categorie;

    public Character(String name) {
        this.name = name;
    }

    public Character() {

    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXpToShare() {
        return xpToShare;
    }

    public void setXpToShare(int xpToShare) {
        this.xpToShare = xpToShare;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public Option<Armor> getHead() {
        return head;
    }

    public void setHead(Option<Armor> head) {
        this.head = head;
    }

    public int getImagePath() {
        return this.imagePath;
    }

    public Trinket getTrinket() {
        return trinket;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Option<Weapon> getWeapon() {
        return weapon;
    }

    public void setWeapon(Option<Weapon> weapon) {
        this.weapon = weapon;
    }

    public Option<Armor> getArmor() {
        return armor;
    }

    public void setArmor(Option<Armor> armor) {
        this.armor = armor;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public boolean isAlive() {
        return lifeCurrent > 0;
    }
}
