package fr.android.animefight.bean.items.equipable;

/**
 * Created by rohamdi on 17/02/2016.
 */
public class Armor extends Equipable {

    public Armor(int imagePath, String name, String description) {
        super(imagePath, name, description, TypeEquip.Armor);
    }

//    @Override
//    public String getImagePath() {
//        return "armor_"+this.getName();
//    }
}
