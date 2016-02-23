package com.example.animeFight_app.bean.team;

import com.example.animeFight_app.bean.Items.equipable.Armor;
import com.example.animeFight_app.bean.Items.equipable.Trinket;
import com.example.animeFight_app.bean.Items.equipable.Weapon;
import com.example.animeFight_app.bean.team.stats.Attack;
import com.example.animeFight_app.bean.team.stats.Defense;
import com.example.animeFight_app.bean.team.stats.Life;

import java.io.Serializable;

/**
 * Created by rohamdi on 17/02/2016.
 */
public class Character implements Serializable {
    private String name;
    private Armor armor;
    private Weapon weapon;
    private Trinket trinket;
    private Life life;
    private Defense defense;
    private Attack attack;
    private int vitesse;
    private String imagePath;

    public Character(String name) {
        this.name = name;
    }

    public Character() {

    }

    public String getImagePath() {
        return "char_" + this.toString();
    }

    public Attack getAttack() {
        return attack;
    }

    public Defense getDefense() {
        return defense;
    }

    public Life getLife() {
        return life;
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

    public void setLife(Life life) {
        this.life = life;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
}
