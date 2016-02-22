package com.example.animeFight_app.mock;

import com.example.animeFight_app.bean.Items.equipable.Armor;
import com.example.animeFight_app.bean.Items.equipable.Trinket;
import com.example.animeFight_app.bean.Items.equipable.Weapon;

/**
 * Created by rohamdi on 22/02/2016.
 */
public class MockEquipable {
    public static Weapon getWeapon(){
        return new Weapon("epee");
    }

    public static Armor getArmor(){
        Armor armor= new Armor("fullplate");

        getArmor().setDescription("Une armure extremement lourde, portee par les membres de la Legion.");

        return armor;
    }

    public static Trinket getTrinket(){
        return new Trinket("SponsoSnakeEaring");
    }
}
