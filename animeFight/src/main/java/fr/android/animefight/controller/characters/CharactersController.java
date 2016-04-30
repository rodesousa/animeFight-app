package fr.android.animefight.controller.characters;

import android.content.Intent;
import android.view.View;
import fr.android.animefight.activity.home.character.CharactersActivity;
import fr.android.animefight.activity.home.character.InspectCharacterActivity;
import fr.android.animefight.activity.home.inventory.InventoryActivity;
import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.bean.items.equipable.Equipable;
import fr.android.animefight.controller.Controller;
import fr.android.animefight.model.Model;

/**
 * Created by rodesousa on 28/04/16.
 */
public class CharactersController extends Controller {
    private Character character;
    private Equipable.TypeEquip type;
    private int indice;

    public CharactersController(Model model) {
        super(model);
    }

    public Intent addWeapon(InspectCharacterActivity activity) {
        return addIntent(activity, Equipable.TypeEquip.Weapon);
    }

    public Intent addArmor(InspectCharacterActivity activity) {
        return addIntent(activity, Equipable.TypeEquip.Armor);
    }

    private Intent addIntent(InspectCharacterActivity activity, Equipable.TypeEquip type) {
        Intent intent = new Intent(activity, InventoryActivity.class);
        this.type = type;
        intent.putExtra("Controller", this);
        intent.putExtra("CharacterId", indice);
        intent.putExtra("Type", "ChooseEquipment");
        return intent;
    }

    public void setCharacter(int indice) {
        this.indice = indice;
        character = model.getPlayer().getCharacters().get(indice);
    }

    public Character getCharacter() {
        return character;
    }

    public Intent inspectCharacter(View view, CharactersActivity activity) {
        Intent intent = new Intent(activity, InspectCharacterActivity.class);
        setCharacter(view.getId());
        intent.putExtra("Controller", this);
        return intent;
    }
}
