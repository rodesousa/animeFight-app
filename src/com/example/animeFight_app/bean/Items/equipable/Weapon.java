package com.example.animeFight_app.bean.Items.equipable;

import com.example.animeFight_app.bean.Items.Equipable;

/**
 * Created by rohamdi on 17/02/2016.
 */
public class Weapon extends Equipable {
    public Weapon(String name) {
        super(name);
    }
    @Override
    public String getImagePath() {
        return "weapon_"+this.getName();
    }
}
