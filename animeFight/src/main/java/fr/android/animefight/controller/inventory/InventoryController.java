package fr.android.animefight.controller.inventory;

import android.view.View;
import fr.android.animefight.bean.inventory.CaseInventory;
import fr.android.animefight.bean.items.equipable.Equipable;
import fr.android.animefight.controller.Controller;
import fr.android.animefight.model.Model;
import fr.android.animefight.utils.Some;

/**
 * Created by rodesousa on 28/04/16.
 */
public class InventoryController extends Controller {

    private Type type = Type.Descriptif;
    private Equipable.TypeEquip typeChooseEquip;

    public InventoryController(Model model) {
        super(model);
    }

    //pattern matching
    public boolean sortBy(CaseInventory caseInventory) {
        if (type == Type.Choose)
            return typeChooseEquip.get() == caseInventory.getItem().getType();
        return true;
    }

    public boolean isDescriptif() {
        return type == Type.Descriptif;
    }

    public void chooseItem(View view, int characterId) {
        if (typeChooseEquip.equals(Equipable.TypeEquip.Armor))
            model.getPlayer().getCharacters().get(characterId).setArmor(
                    new Some(model.getPlayer().getInventory().getCases().get(view.getId()).getItem()));
        else if (typeChooseEquip.equals(Equipable.TypeEquip.Weapon))
            model.getPlayer().getCharacters().get(characterId).setWeapon(
                    new Some(model.getPlayer().getInventory().getCases().get(view.getId()).getItem()));
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        Descriptif,
        Choose
    }
}
