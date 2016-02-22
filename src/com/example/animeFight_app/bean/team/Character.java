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
    private String Name;
    private Armor armor;
    private Weapon weapon;
    private Trinket trinket;
    private Life life;
    private Defense defense;
    private Attack attack;

    private String imagePath;

    public Character(String name) {
        Name = name;
    }

    public Character() {

    }

    public String getImagePath() {
        return "char_"+this.getName();
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
}
