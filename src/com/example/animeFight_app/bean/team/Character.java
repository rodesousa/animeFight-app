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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
