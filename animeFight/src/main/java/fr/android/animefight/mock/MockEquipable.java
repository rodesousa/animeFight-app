package fr.android.animefight.mock;

import fr.android.animefight.bean.items.equipable.Armor;
import fr.android.animefight.bean.items.equipable.Trinket;
import fr.android.animefight.bean.items.equipable.Weapon;

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
