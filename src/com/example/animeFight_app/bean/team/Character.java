package com.example.animeFight_app.bean.team;

import com.example.animeFight_app.bean.Items.equipable.Armor;
import com.example.animeFight_app.bean.Items.equipable.Trinket;
import com.example.animeFight_app.bean.Items.equipable.Weapon;
import com.example.animeFight_app.bean.team.stats.Attack;
import com.example.animeFight_app.bean.team.stats.Defense;
import com.example.animeFight_app.bean.team.stats.Life;

/**
 * Created by rohamdi on 17/02/2016.
 */
public class Character {
    private String Name;
    private Armor armor;
    private Weapon weapon;
    private Trinket trinket;
    private Life life;
    private Defense defense;
    private Attack attack;
}
